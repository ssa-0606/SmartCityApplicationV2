package com.example.testsmartcityapplication.ui.home.adapter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testsmartcityapplication.MainActivity;
import com.example.testsmartcityapplication.R;
import com.example.testsmartcityapplication.tools.MyBaseAdapter;
import com.example.testsmartcityapplication.ui.home.pojo.Service;

import java.util.List;

public class ServiceAdapter extends MyBaseAdapter<Service> {

    private int resourceId;
    private List<Service> list;

    public ServiceAdapter(int resourceId, List<Service> list) {
        super(resourceId, list);
        this.resourceId = resourceId;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Service service = list.get(position);
        View itemView = holder.itemView;
        ImageView imageView = (ImageView) itemView.findViewById(R.id.service_img);
        TextView textView = (TextView) itemView.findViewById(R.id.service_text);
        if(TextUtils.equals(service.getServiceName(),"全部服务")){
            imageView.setImageResource(R.drawable.ic_dashboard_black_24dp);
        }else{
            Glide.with(itemView).load("http://124.93.196.45:10001"+service.getImgUrl()).into(imageView);
        }
        textView.setText(service.getServiceName());

        imageView.setOnClickListener(view -> {
            if(TextUtils.equals(service.getServiceName(),"全部服务")){
                NavController navController = Navigation.findNavController(itemView);
                navController.navigate(R.id.action_navigation_home_to_navigation_dashboard);
            }
        });


    }
}
