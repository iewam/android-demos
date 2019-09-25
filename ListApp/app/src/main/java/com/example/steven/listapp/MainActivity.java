package com.example.steven.listapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    // Step 1: Define data
    private String data[] = {
            "IPhone",
            "Samsung",
            "Xiaomi",
            "Huawei",
            "LG",
            "HTC",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Ohter",
            "Last Item"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // Step 2: Define Adaptar
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                data
        );

        // Step 3: update Adaptar
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast toast = Toast.makeText(this, position + "", Toast.LENGTH_SHORT);
        toast.show();
    }
}
