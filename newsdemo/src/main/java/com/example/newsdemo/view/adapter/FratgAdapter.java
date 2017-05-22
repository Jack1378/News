package com.example.newsdemo.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsdemo.R;
import com.example.newsdemo.modle.bean.NewsContentBean;
import com.example.newsdemo.presenter.FragPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * name ：李飞宇
 * Date: 2017/5/13
 * desc: 适配器（Fragment里的）
 */

public class FratgAdapter extends BaseAdapter {
    private Context ccontext;
    private FragPresenter fragPresenter;
    private static final int TYPE_1 = 0;
    private static final int TYPE_2 = 1;
    private List<NewsContentBean.ResultBean.DataBean> list = new ArrayList<NewsContentBean.ResultBean.DataBean>();

    public FratgAdapter(Context context) {
        this.ccontext = context;
    }

    public void setPresenter(FragPresenter presenter) {

        this.fragPresenter = presenter;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public NewsContentBean.ResultBean.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getThumbnail_pic_s02() == null) {
            return TYPE_1;
        } else {
            return TYPE_2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VideoHoder videoHoder;
        ViewHolder2 viewHolder2;
        int type = getItemViewType(position);
        switch (type) {
            case TYPE_1:
                if (convertView == null) {
                    videoHoder = new VideoHoder();
                    convertView = View.inflate(ccontext, R.layout.image_text, null);
                    videoHoder.textView = (TextView) convertView.findViewById(R.id.tv);
                    videoHoder.imageView = (ImageView) convertView.findViewById(R.id.image_imag);
                    convertView.setTag(videoHoder);
                } else {
                    videoHoder = (VideoHoder) convertView.getTag();
                }
                videoHoder.textView.setText(getItem(position).getTitle());
                fragPresenter.getFragImageFormServer(videoHoder.imageView, getItem(position).getThumbnail_pic_s());
                break;
            case TYPE_2:
                if (convertView == null) {
                    viewHolder2 = new ViewHolder2();
                    convertView = View.inflate(ccontext, R.layout.image_text2, null);
                    viewHolder2.tvContent2 = (TextView) convertView.findViewById(R.id.tv2);
                    viewHolder2.imageView2 = (ImageView) convertView.findViewById(R.id.image_imag2);
                    viewHolder2.imageView3 = (ImageView) convertView.findViewById(R.id.image_imag3);
                    convertView.setTag(viewHolder2);
                } else {
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                }
                viewHolder2.tvContent2.setText(getItem(position).getTitle());
                fragPresenter.getFragImageFormServer(viewHolder2.imageView2, getItem(position).getThumbnail_pic_s());
                fragPresenter.getFragImageFormServer(viewHolder2.imageView3, getItem(position).getThumbnail_pic_s02());

                break;
        }
        return convertView;
    }

    public void setData(List<NewsContentBean.ResultBean.DataBean> data) {
        if (data != null) {
            this.list.addAll(data);
        }
    }

    static class VideoHoder {
        TextView textView;
        ImageView imageView;
    }

    static class ViewHolder2 {
        TextView tvContent2;
        ImageView imageView2;
        ImageView imageView3;
    }
}
