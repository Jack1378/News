package com.example.my_pulltorefresh_github.view.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my_pulltorefresh_github.R;
import com.example.my_pulltorefresh_github.modle.bean.HomeBean;
import com.example.my_pulltorefresh_github.presenter.HomePredenter;

import java.util.ArrayList;
import java.util.List;

/**
 * name ：李飞宇
 * Date: 2017/5/19
 * desc: 适配器
 */

public class MyAdapter extends BaseAdapter {
    private Context mcontext;
    private HomePredenter homePredenter;
    private List<HomeBean.ResultBean.DataBean> list = new ArrayList<HomeBean.ResultBean.DataBean>();

    public MyAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public HomeBean.ResultBean.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mcontext, R.layout.image_text, null);
            viewHolder = new ViewHolder();
            viewHolder.tx = (TextView) convertView.findViewById(R.id.lv_tv);
            viewHolder.im = (ImageView) convertView.findViewById(R.id.lv_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tx.setText(getItem(position).getTags());
        homePredenter.getImage(getItem(position).getAlbums().get(0), viewHolder.im);
        return convertView;















    }

    public void setPresent(HomePredenter homePredenter) {
        this.homePredenter = homePredenter;
    }


    public void getThing(List<HomeBean.ResultBean.DataBean> data) {
        if (data!=null){
            list.addAll(data);
        }
    }

    static class ViewHolder {
        TextView tx;
        ImageView im;

    }
}
