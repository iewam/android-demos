package com.lingyizhengxin.customizedview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        navigationBar = findViewById(R.id.navBar);
        navigationBar.setListener(new NavigationBar.NavigationBarItemClickListener() {
            @Override
            public void backImgClick() {
                finish();
            }

            @Override
            public void rightItem0Click() {

                Intent intent = new Intent(Main2Activity.this, ThirdActivity.class);
                startActivity(intent);
            }

        });
    }
}
