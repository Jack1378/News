package com.baway.myrecycleview.view.activity;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.baway.myrecycleview.R;
import com.baway.myrecycleview.mondel.HomeBean;
import com.baway.myrecycleview.present.HomePresent;
import com.baway.myrecycleview.present.MyDivider;
import com.baway.myrecycleview.view.adapter.RecycleAdapter;
import com.baway.myrecycleview.view.iview.HomeView;

public class MainActivity extends AppCompatActivity implements HomeView<HomeBean>, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private HomePresent homePresent;
    private RecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        homePresent = new HomePresent();
        homePresent.attachView(this);
//        LinearLayoutManager manager = new LinearLayoutManager(this);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
//        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);

        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN);

        adapter = new RecycleAdapter(MainActivity.this);
        adapter.setpresent(homePresent);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyDivider(this));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int itemCount = layoutManager.getItemCount();
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition + 1 == itemCount) {
                    swipeRefreshLayout.setRefreshing(true);
                }
            }
        });
        //添加分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        homePresent.setData(HomeBean.class);
    }

    @Override
    public void callBack(HomeBean homeBean) {
        adapter.setDatas(homeBean);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }
}
