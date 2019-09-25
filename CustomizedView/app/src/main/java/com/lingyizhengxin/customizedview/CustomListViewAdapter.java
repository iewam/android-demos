package com.lingyizhengxin.customizedview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<String> {

    public CustomListViewAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_item, null);
        } else {
            view = convertView;
        }

        TextView titleTv = view.findViewById(R.id.titleTv);
        titleTv.setText(getItem(position));

        return view;
    }
}
