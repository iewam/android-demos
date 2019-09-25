package com.lingyizhengxin.customizedview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class CustomListView extends ListView implements GestureDetector.OnGestureListener , View.OnTouchListener {

    private GestureDetector gestureDetector;// 手势动作探测器
    private CustomItemDeleteListener itemDeleteListener; // 删除监听器
    private View deleteButton; // 删除按钮
    private ViewGroup itemLayout;// 列表布局
    private int selectedItemIndex; // 选中的列表项
    private boolean isDeleteButtonShow; // 删除按钮是否显示出来


    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 创建手势探测器
        gestureDetector = new GestureDetector(context, (GestureDetector.OnGestureListener) this);
        setOnTouchListener(this);
    }

    public void setItemDeleteListener(CustomItemDeleteListener itemDeleteListener) {
        this.itemDeleteListener = itemDeleteListener;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (isDeleteButtonShow) {
            hideDeleteButton();
            return false;
        } else  {
            return gestureDetector.onTouchEvent(motionEvent);
        }
    }

    /**
     * 移除删除按钮
     */
    private void hideDeleteButton() {
        itemLayout.removeView(deleteButton);
        deleteButton = null;
        isDeleteButtonShow = false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        if (!isDeleteButtonShow) {
            selectedItemIndex = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }

        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float velocityX, float velocityY) {
        // !isDeleteButtonShow && Math.abs(velocityX) > Math.abs(velocityY)
        if (!isDeleteButtonShow && motionEvent1.getX() - motionEvent.getX() < -50) {
            deleteButton = LayoutInflater.from(getContext()).inflate(R.layout.delete_button, null);

            deleteButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemLayout.removeView(deleteButton);
                    deleteButton = null;
                    isDeleteButtonShow = false;
                    itemDeleteListener.onDelete(selectedItemIndex);
                }
            });

            itemLayout = (ViewGroup)getChildAt(selectedItemIndex - getFirstVisiblePosition());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);

            itemLayout.addView(deleteButton, layoutParams);
            isDeleteButtonShow = true;
        }

        return false;
    }






    // 删除监听器
    public interface CustomItemDeleteListener {
        void onDelete(int index);
    }

}
