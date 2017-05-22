package com.baway.myrecycleview.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.myrecycleview.R;
import com.baway.myrecycleview.mondel.HomeBean;
import com.baway.myrecycleview.present.HomePresent;

import org.xutils.image.ImageOptions;

import java.util.ArrayList;
import java.util.List;


/**
 * 类用途 :
 * 作者 : 郁文涛
 * 时间 : 2017/5/18 8:39
 */

public class RecycleAdapter extends RecyclerView.Adapter {

    private Context mcontext;
    private List<HomeBean.ResultBean.DataBean> list = new ArrayList<>();
    private HomePresent mhomePresent;

    public void setpresent(HomePresent homePresent) {
        this.mhomePresent = homePresent;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView textview;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_image);
            textview = (TextView) itemView.findViewById(R.id.item_text);
        }

    }

    public RecycleAdapter(Context context) {
        this.mcontext = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(mcontext, R.layout.item, null);
        MyViewHolder holder = new MyViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder vh = (MyViewHolder) holder;
        vh.textview.setText(list.get(position).getTitle());
        mhomePresent.getImage(vh.image, list.get(position).getThumbnail_pic_s());
        
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDatas(HomeBean homeBean) {
        if (homeBean != null) {
            this.list.addAll(homeBean.getResult().getData());
        }
    }
}
