package com.example.testsmartcityapplication.ui.home.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testsmartcityapplication.R;
import com.example.testsmartcityapplication.tools.MyBaseAdapter;
import com.example.testsmartcityapplication.ui.home.pojo.Service;

import java.util.List;

public class HotAdapter extends MyBaseAdapter<Service> {

    private int resourceId;
    private List<Service> list;

    public HotAdapter(int resourceId, List<Service> list) {
        super(resourceId, list);
        this.resourceId = resourceId;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        Service service = list.get(position);
        View itemView = holder.itemView;
        ImageView imageView = (ImageView) itemView.findViewById(R.id.hot_img);
        TextView textView = (TextView) itemView.findViewById(R.id.hot_text);
        Glide.with(itemView).load("http://124.93.196.45:10001"+service.getImgUrl()).into(imageView);
        textView.setText(service.getServiceName());

    }
}
