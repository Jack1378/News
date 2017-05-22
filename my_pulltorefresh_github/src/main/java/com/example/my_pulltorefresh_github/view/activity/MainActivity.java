package com.example.my_pulltorefresh_github.view.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.my_pulltorefresh_github.R;
import com.example.my_pulltorefresh_github.modle.bean.HomeBean;
import com.example.my_pulltorefresh_github.presenter.HomePredenter;
import com.example.my_pulltorefresh_github.view.adapter.MyAdapter;
import com.example.my_pulltorefresh_github.view.iview.IHomeView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends AppCompatActivity implements IHomeView<HomeBean>, PullToRefreshListView.OnRefreshListener2 {

    private PullToRefreshListView ptr_listView;
    private int currentPage = 1;
    private HomePredenter hp;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initdata();
    }

    private void initdata() {
    }

    private void initView() {
        ptr_listView = (PullToRefreshListView) findViewById(R.id.PTR_ListView);
        //监听上拉或下拉
        ptr_listView.setOnRefreshListener(this);
        ListView refreshableView = ptr_listView.getRefreshableView();

        //接口调用
        invoking();
    }

    private void invoking() {
        hp = new HomePredenter();
        hp.getAttch(this);
        myAdapter = new MyAdapter(MainActivity.this);
        myAdapter.setPresent(hp);
        ptr_listView.setAdapter(myAdapter);
        hp.getData(HomeBean.class);
    }

    //向下 加载更多
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {

        ptr_listView.setRefreshing(false);
        //刷新数据
        refreshView();
    }

    private void refreshView() {
        currentPage = 1;
        //延时3秒后隐藏
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ptr_listView.setRefreshing(false);
            }
        }, 3000);
    }

    //向上刷新数据
    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        //加载更多
        loadMore();
    }

    private void loadMore() {

    }


    @Override
    public void callBack(HomeBean homeBean) {
        myAdapter.getThing(homeBean.getResult().getData());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void callBackHome(String str, int code) {

    }
}
