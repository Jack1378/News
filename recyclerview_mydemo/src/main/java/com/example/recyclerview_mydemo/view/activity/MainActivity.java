package com.example.recyclerview_mydemo.view.activity;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.recyclerview_mydemo.mondel.Bean;
import com.example.recyclerview_mydemo.present.HomePresent;
import com.example.recyclerview_mydemo.view.adapter.MyAdapter;
import com.example.recyclerview_mydemo.present.MyDivider;
import com.example.recyclerview_mydemo.R;
import com.example.recyclerview_mydemo.view.iview.HomeView;

public class MainActivity extends AppCompatActivity implements HomeView<Bean>, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipe;
    private RecyclerView recycler;
    private MyAdapter myAdapter;
    private HomePresent homePresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        initData();
    }

    private void initView() {
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        //瀑布流效果
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        swipe.setColorSchemeColors(Color.RED);
        recycler.addItemDecoration(new MyDivider(this));
        myAdapter = new MyAdapter(MainActivity.this);
        myAdapter.setpresent(homePresent);
        recycler.setAdapter(myAdapter);
        homePresent.setData(Bean.class);

    }

    @Override
    public void onRefresh() {
        swipe.setRefreshing(false);
    }

    @Override
    public void callBack(Bean bean) {
        myAdapter.setDatas(bean);
        myAdapter.notifyDataSetChanged();

    }
}
