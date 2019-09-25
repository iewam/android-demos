package com.lingyizhengxin.customizedview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationBar = findViewById(R.id.navBar);

        navigationBar.setListener(new NavigationBar.NavigationBarItemClickListener() {
            @Override
            public void backImgClick() {
                Toast.makeText(MainActivity.this, "back", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightItem0Click() {
                Toast.makeText(MainActivity.this, "next", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }

        });


    }

}
