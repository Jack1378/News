package com.example.recyclerview_mydemo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview_mydemo.R;
import com.example.recyclerview_mydemo.mondel.Bean;
import com.example.recyclerview_mydemo.present.HomePresent;

import java.util.ArrayList;
import java.util.List;

/**
 * name ：李飞宇
 * Date: 2017/5/19
 * desc:
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context Mcontext;
    private List<Bean.ResultBean.DataBean> mlist = new ArrayList<Bean.ResultBean.DataBean>();
    private HomePresent homePresent;

    public MyAdapter(Context context) {
        this.Mcontext = context;
    }
    public void setpresent(HomePresent homePresent) {
        this.homePresent = homePresent;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView home_image;
        private final TextView home_text;

        public MyViewHolder(View itemView) {
            super(itemView);
            home_image = (ImageView) itemView.findViewById(R.id.home_image);
            home_text = (TextView) itemView.findViewById(R.id.home_text);

        }
    }

    //找到布局
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(Mcontext, R.layout.home_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder mv = (MyViewHolder) holder;
        mv.home_text.setText(mlist.get(position).getTitle());
        homePresent.getImage(mv.home_image, mlist.get(position).getThumbnail_pic_s());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setDatas(Bean bean) {
        if (bean != null) {
            this.mlist.addAll(bean.getResult().getData());
        }
    }
}
