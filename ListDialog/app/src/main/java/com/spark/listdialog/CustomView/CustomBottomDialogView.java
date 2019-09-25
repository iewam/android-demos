package com.spark.listdialog.CustomView;


import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.WindowManager;

import com.spark.listdialog.R;

public class CustomBottomDialogView extends Dialog {

    private Window window;

    public CustomBottomDialogView(@NonNull Context context) {
        super(context);
    }

    public void showCustomBottomDialogView(int layoutResId, int x, int y) {
        setContentView(layoutResId);
        
        windowDeploy(x, y);

        setCanceledOnTouchOutside(true);

        show();
    }

    private void windowDeploy(int x, int y) {

        window = getWindow();

        window.setWindowAnimations(R.style.BottomDialogAnimation); //设置窗口弹出动画
        window.setBackgroundDrawableResource(R.color.colorAccent); //设置对话框背景为透明
        WindowManager.LayoutParams wl = window.getAttributes();
        //根据x，y坐标设置窗口需要显示的位置
        wl.x = x; //x小于0左移，大于0右移
        wl.y = y; //y小于0上移，大于0下移
//            wl.alpha = 0.6f; //设置透明度
//            wl.gravity = Gravity.BOTTOM; //设置重力
        window.setAttributes(wl);
    }


}
