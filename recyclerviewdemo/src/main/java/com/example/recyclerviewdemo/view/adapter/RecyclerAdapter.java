package com.example.recyclerviewdemo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * name ：李飞宇
 * Date: 2017/5/17
 * desc: 适配器
 */

public class RecyclerAdapter extends RecyclerView.Adapter {
    private Context mcontext;
    private ArrayList<String> mList = new ArrayList<>();

    public RecyclerAdapter(Context context) {
        this.mcontext = context;
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mcontext, R.layout.home_item, null);
        MyViewHodler myViewHodler = new MyViewHodler(null);
        return myViewHodler;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHodler myViewHodler = (MyViewHodler) holder;
        myViewHodler.home_tv.setText(""+mList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setData(ArrayList<String> data) {
        if (data != null) {
            mList.addAll(data);
        }
    }

    //自定义viewHodler
    class MyViewHodler extends RecyclerView.ViewHolder {

//        private final ImageView home_image;
        private final TextView home_tv;

        public MyViewHodler(View itemView) {
            super(itemView);
//            home_image = (ImageView) itemView.findViewById(R.id.home_image);
            home_tv = (TextView) itemView.findViewById(R.id.home_tv);

        }
    }
}
