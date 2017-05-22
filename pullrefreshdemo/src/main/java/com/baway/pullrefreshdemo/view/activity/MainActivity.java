package com.baway.pullrefreshdemo.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baway.pullrefreshdemo.R;
import com.baway.pullrefreshdemo.mondel.HomeBean;
import com.baway.pullrefreshdemo.present.HomePresent;
import com.baway.pullrefreshdemo.view.adapter.PullRefreshAdapter;
import com.baway.pullrefreshdemo.view.iview.IHomeView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends AppCompatActivity implements IHomeView<HomeBean>,PullToRefreshListView.OnRefreshListener2 {

    private PullToRefreshListView pullToRefreshListView;
    private HomePresent homePresent;
    private PullRefreshAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_listview);
        homePresent = new HomePresent();
        homePresent.getAttach(this);
        adapter = new PullRefreshAdapter(this);
        adapter.setPresent(homePresent);
        pullToRefreshListView.setAdapter(adapter);
        homePresent.getData(HomeBean.class);
    }

    @Override
    public void callBack(HomeBean homeBean) {
        adapter.addData(homeBean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void callBackHome(String pp, int code) {

    }
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {

    }

}
