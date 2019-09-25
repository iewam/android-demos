package com.spark.baseadapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class DemoActivity extends Activity implements View.OnClickListener{

    private Button addBtn;
    private EditText editText;
    private GridView gridView;

    private ArrayAdapter<String> adapter;
    private List<String> dataSource = new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);


        initControl();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataSource);

        gridView.setAdapter(adapter);
    }



    private void initControl() {
        addBtn = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);
        gridView = (GridView)findViewById(R.id.gridView);

        addBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String name = editText.getText().toString();
        dataSource.add(name);

        adapter.notifyDataSetChanged();
    }
}
