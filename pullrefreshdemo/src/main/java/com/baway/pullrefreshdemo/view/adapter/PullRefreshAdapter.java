package com.baway.pullrefreshdemo.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.pullrefreshdemo.R;
import com.baway.pullrefreshdemo.mondel.HomeBean;
import com.baway.pullrefreshdemo.present.HomePresent;

import java.util.ArrayList;
import java.util.List;


/**
 * 类用途 :
 * 作者 : 郁文涛
 * 时间 : 2017/5/19 15:54
 */

public class PullRefreshAdapter extends BaseAdapter {

    private Context mcontext;
    private HomePresent mhomePresent;
    private List<HomeBean.ResultBean.DataBean> list=new ArrayList<>();

    public PullRefreshAdapter(Context context) {
        this.mcontext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public HomeBean.ResultBean.DataBean getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListHolder holder;
        if (convertView == null) {
            convertView=View.inflate(mcontext, R.layout.item_list,null);
            holder=new ListHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.item_image);
            holder.textView= (TextView) convertView.findViewById(R.id.item_text);
            convertView.setTag(holder);
        }else {
            holder= (ListHolder) convertView.getTag();
        }
        mhomePresent.getImage(list.get(position).getAlbums().get(0),holder.imageView);
        holder.textView.setText(list.get(position).getTags());
        return convertView;
    }

    public void setPresent(HomePresent homePresent) {
        this.mhomePresent=homePresent;
    }

    class ListHolder{
        ImageView imageView;
        TextView textView;
    }

    public void addData(HomeBean homeBean) {
        if (homeBean!=null){
            list.addAll(homeBean.getResult().getData());
        }
    }
}
