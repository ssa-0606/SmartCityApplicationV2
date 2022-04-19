package com.example.testsmartcityapplication.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testsmartcityapplication.R;
import com.example.testsmartcityapplication.databinding.FragmentHomeBinding;
import com.example.testsmartcityapplication.tools.MyUtils;
import com.example.testsmartcityapplication.ui.home.adapter.HotAdapter;
import com.example.testsmartcityapplication.ui.home.adapter.NewsAdapter;
import com.example.testsmartcityapplication.ui.home.adapter.ServiceAdapter;
import com.example.testsmartcityapplication.ui.home.pojo.LunBo;
import com.example.testsmartcityapplication.ui.home.pojo.NewsCategory;
import com.example.testsmartcityapplication.ui.home.pojo.NewsItem;
import com.example.testsmartcityapplication.ui.home.pojo.Service;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;
    private List<LunBo> lunBos;
    private List<Service> services;
    private List<Service> showServices;
    private RecyclerView serviceRecycler;
    private RecyclerView hotService;
    private List<Service> showHot;
    private List<NewsCategory> newsCategories;
    private List<NewsItem> newsItems;
    private TabLayout tabLayout;
    private RecyclerView newsRecycler;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewFlipper = (ViewFlipper) view.findViewById(R.id.vf);
        serviceRecycler = (RecyclerView) view.findViewById(R.id.main_service);
        hotService = (RecyclerView) view.findViewById(R.id.main_hot);
        tabLayout = (TabLayout) view.findViewById(R.id.main_tab);
        newsRecycler = (RecyclerView) view.findViewById(R.id.main_news);
        getLunBo();
        getService();
        getNews();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Message message = new Message();
                message.obj = tab.getPosition();
                message.what = 4;
                handler.sendMessage(message);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    private void getLunBo() {

        Thread thread = new Thread(()->{
            try {
                String jsonData = MyUtils.GET("http://124.93.196.45:10001/prod-api/api/rotation/list?type=2");
                lunBos = new ArrayList<>();
                Gson gson = new Gson();
                JsonObject data = new JsonParser().parse(jsonData).getAsJsonObject();
                JsonArray rows = data.getAsJsonArray("rows");
                for(JsonElement user :rows){
                    LunBo lunBo = gson.fromJson(user, new TypeToken<LunBo>() {}.getType());
                    lunBos.add(lunBo);
                }
                handler.sendEmptyMessage(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();


    }

    private void getService(){
        Thread thread = new Thread(()->{
            try {
                String result = MyUtils.GET("http://124.93.196.45:10001/prod-api/api/service/list");
                JsonObject json = new JsonParser().parse(result).getAsJsonObject();
                JsonArray rows = json.getAsJsonArray("rows");
                services = new ArrayList<>();
                Gson gson = new Gson();
                for (JsonElement row : rows) {
                      Service service = gson.fromJson(row, new TypeToken<Service>() {}.getType());
                      services.add(service);
                }
                handler.sendEmptyMessage(2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    private void getNews(){
        Thread thread = new Thread(()->{
            try {
                String result = MyUtils.GET("http://124.93.196.45:10001/prod-api/press/category/list");
                newsCategories = new ArrayList<>();
                JsonObject json = new JsonParser().parse(result).getAsJsonObject();
                JsonArray rows = json.getAsJsonArray("data");
                for (JsonElement row : rows) {
                    NewsCategory newsCategory = new Gson().fromJson(row,new TypeToken<NewsCategory>(){}.getType());
                    String result1 = MyUtils.GET("http://124.93.196.45:10001/prod-api/press/press/list?type=" + newsCategory.getId());
                    JsonObject asJsonObject = new JsonParser().parse(result1).getAsJsonObject();
                    JsonArray rows1 = asJsonObject.getAsJsonArray("rows");
                    newsItems = new ArrayList<>();
                    for (JsonElement jsonElement : rows1) {
                        NewsItem newsItem = new Gson().fromJson(jsonElement,new TypeToken<NewsItem>(){}.getType());
                        newsItems.add(newsItem);
                        newsCategory.setNewsItems(newsItems);
                    }
                    newsCategories.add(newsCategory);
                }
                for (NewsCategory newsCategory : newsCategories) {
                    Log.d("TAG1", "getNews: "+newsCategory.getName());
                }
                handler.sendEmptyMessage(3);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    for (int i = 0; i < lunBos.size(); i++) {
                        ImageView imageView = new ImageView(getContext());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        Glide.with(getContext()).load("http://124.93.196.45:10001"+lunBos.get(i).getAdvImg()).into(imageView);
                        viewFlipper.addView(imageView);
                    }
                    break;
                case 2:
                    showServices = new ArrayList<>();
                    showHot = new ArrayList<>();
                    for (int i = 0; i < 9; i++) {
                        showServices.add(services.get(i));
                    }
                    for (int i = 0; i < 2; i++) {
                        showHot.add(services.get(i));
                    }
                    showServices.add(new Service(0,"全部服务","全部服务","",0));
                    serviceRecycler.setLayoutManager(new GridLayoutManager(getContext(),5));
                    serviceRecycler.setAdapter(new ServiceAdapter(R.layout.service_layout,showServices));

                    hotService.setLayoutManager(new GridLayoutManager(getContext(),2));
                    hotService.setAdapter(new HotAdapter(R.layout.hot_layout,showHot));

                    break;
                case 3:
                    for (NewsCategory newsCategory : newsCategories) {
                        tabLayout.addTab(tabLayout.newTab().setText(newsCategory.getName()).setTag(newsCategory.getId()));
                    }
                    newsRecycler.setLayoutManager(new GridLayoutManager(getContext(),1));
                    newsRecycler.setAdapter(new NewsAdapter(R.layout.news_layout,newsCategories.get(0).getNewsItems()));
                    break;
                case 4:
                    int i = (int)msg.obj;
                    newsRecycler.setLayoutManager(new GridLayoutManager(getContext(),1));
                    newsRecycler.setAdapter(new NewsAdapter(R.layout.news_layout,newsCategories.get(i).getNewsItems()));
                    break;
            }
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}