package com.example.recyclerviewdemo.view.activity;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.view.adapter.RecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private SwipeRefreshLayout swipe;
    private ArrayList<String> mlist;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        swipe = (SwipeRefreshLayout) findViewById(R.id.Swipe);
        recycler = (RecyclerView) findViewById(R.id.Recycler);

        LinearLayoutManager linear = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager grid = new GridLayoutManager(this, 3);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
//如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
//        recycler.setHasFixedSize(true);
        //设置布局管理器
        recycler.setLayoutManager(staggeredGridLayoutManager);

        //设置颜色
        swipe.setColorSchemeColors(Color.RED, Color.BLUE, Color.YELLOW);

        recycler.setAdapter(mAdapter = new HomeAdapter());
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //添加分割线
//        recycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recycler.addItemDecoration(new MyDivider(this));
    }


    private void initData() {
        mlist = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mlist.add("" + (char) i);
        }
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = View.inflate(MainActivity.this, R.layout.home_item, null);
            MyViewHolder holder = new MyViewHolder(inflate);
//            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.home_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mlist.get(position));
            MyViewHolder vh = (MyViewHolder) holder;
            vh.tv.setText(mlist.get(position));
            //.getTitle()

        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.home_tv);
            }
        }

    }

}
