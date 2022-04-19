package com.example.testsmartcityapplication.ui.home.adapter;

import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testsmartcityapplication.R;
import com.example.testsmartcityapplication.tools.MyBaseAdapter;
import com.example.testsmartcityapplication.ui.home.pojo.NewsItem;

import java.util.List;

public class NewsAdapter extends MyBaseAdapter<NewsItem> {

    private int resourceId;
    private List<NewsItem> list;

    public NewsAdapter(int resourceId, List<NewsItem> list) {
        super(resourceId, list);
        this.resourceId = resourceId;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        NewsItem newsItem = list.get(position);
        View itemView = holder.itemView;

        TextView title = (TextView) itemView.findViewById(R.id.news_title);
        TextView content = (TextView) itemView.findViewById(R.id.news_content);
        ImageView cover = (ImageView) itemView.findViewById(R.id.news_cover);
        TextView publish = (TextView) itemView.findViewById(R.id.news_publish);
        TextView comment = (TextView) itemView.findViewById(R.id.news_comment);

        title.setText(newsItem.getTitle());
        content.setText(Html.fromHtml(newsItem.getContent()));
        Glide.with(itemView).load("http://124.93.196.45:10001"+newsItem.getCover()).into(cover);
        publish.setText(newsItem.getPublishDate());
        comment.setText(newsItem.getCommentNum()+"条评论");

    }
}
