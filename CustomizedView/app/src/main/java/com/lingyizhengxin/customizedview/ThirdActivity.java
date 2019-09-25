package com.lingyizhengxin.customizedview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends BaseActivity {

    private CustomListView customListView;
    private CustomListViewAdapter customListViewAdapter;
    private List<String> datas = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        navigationBar = findViewById(R.id.navBar);
        navigationBar.setListener(new NavigationBar.NavigationBarItemClickListener() {
            @Override
            public void backImgClick() {
                finish();
            }

            @Override
            public void rightItem0Click() {

            }
        });






        initlizeDatas();

        customListView = findViewById(R.id.custListView);
        customListViewAdapter = new CustomListViewAdapter(this,0, datas);
        customListView.setAdapter(customListViewAdapter);

        customListView.setItemDeleteListener(new CustomListView.CustomItemDeleteListener() {
            @Override
            public void onDelete(int index) {
                datas.remove(index);
                customListViewAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initlizeDatas() {
        for (int i = 0; i < 100; i++) {
            datas.add("test--"+i);

        }
    }
}
