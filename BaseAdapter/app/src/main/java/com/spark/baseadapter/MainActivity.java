package com.spark.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private int[] imgResIds = {
            R.drawable.temp_bottom_goods01,
            R.drawable.temp_bottom_goods02,
            R.drawable.temp_bottom_goods03,
            R.drawable.temp_bottom_goods04
    };

    private String[] goodsNames = {
            "goods_1",
            "goods_2",
            "goods_3",
            "goods_4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, adapterView.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View itemView = null;
            ViewHolder viewHolder = null;
            if (view == null) {
                LayoutInflater inflater = getLayoutInflater();
                itemView = inflater.inflate(R.layout.list_item, null);

                viewHolder = new ViewHolder(itemView);
                itemView.setTag(viewHolder);
            } else {
                itemView = view;
                viewHolder = (ViewHolder)itemView.getTag();
            }

            ImageView img = viewHolder.getImg();
            img.setImageResource(imgResIds[i % imgResIds.length]);

            TextView nameTv = viewHolder.getNameTv();
            nameTv.setText(goodsNames[i % goodsNames.length]);

            return itemView;
        }
    }




    class ViewHolder {
        private View itemView;
        private ImageView img;
        private TextView nameTv;

        public ViewHolder(View view) {
            this.itemView = view;
        }

        public ImageView getImg() {
            if (img == null) {
                img = itemView.findViewById(R.id.img);
            }
            return img;
        }

        public TextView getNameTv() {
            if (nameTv == null) {
                nameTv = itemView.findViewById(R.id.name);
            }
            return nameTv;
        }
    }


}
