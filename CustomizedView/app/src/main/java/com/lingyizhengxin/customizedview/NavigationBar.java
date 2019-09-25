package com.lingyizhengxin.customizedview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NavigationBar extends RelativeLayout {

    private ImageView backImg;
    private TextView titleTv;
    private TextView rightItem0;

    private NavigationBarItemClickListener listener;

    public void setListener(NavigationBarItemClickListener listener) {
        this.listener = listener;
    }

    public NavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.nav_bar, this);

        backImg = findViewById(R.id.backImg);
        titleTv = findViewById(R.id.titleTv);
        rightItem0 = findViewById(R.id.rightItem0);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NavigationBar);

        boolean backImgHidden = typedArray.getBoolean(R.styleable.NavigationBar_backImgHidden, false);
        String title = typedArray.getString(R.styleable.NavigationBar_title);
        String rightItem0Text = typedArray.getString(R.styleable.NavigationBar_rightItem0Text);

        titleTv.setText(title);
        rightItem0.setText(rightItem0Text);

        if (backImgHidden) {
            backImg.setVisibility(View.GONE);
        }

        setOnclickListeners();
    }


    private void setOnclickListeners() {
        backImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.backImgClick();
            }
        });

        rightItem0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.rightItem0Click();
            }
        });
    }


    public void setTitle(String title) {
        titleTv.setText(title);
    }


    public interface NavigationBarItemClickListener {
        void backImgClick();
        void rightItem0Click();
    }
}
