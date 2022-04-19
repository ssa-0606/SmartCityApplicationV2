package com.example.testsmartcityapplication.tools;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyBaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int resourceId;
    private List<T> list;

    private RecyclerView.ViewHolder holder;

    public MyBaseAdapter(int resourceId, List<T> list) {
        this.resourceId = resourceId;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        holder = new RecyclerView.ViewHolder(inflate) {};
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
