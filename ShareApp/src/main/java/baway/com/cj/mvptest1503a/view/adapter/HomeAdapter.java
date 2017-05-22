package baway.com.cj.mvptest1503a.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import baway.com.cj.mvptest1503a.R;
import baway.com.cj.mvptest1503a.model.home.HomeBean;
import baway.com.cj.mvptest1503a.presenter.HomePresenter;

/**
 * Created by cj on 2017/5/9.
 */

public class HomeAdapter extends BaseAdapter {
    private Context mContext;
    private HomePresenter mHomePresenter;
    private List<HomeBean.DataBean> data = new ArrayList<>();

    public HomeAdapter(Context context) {
        this.mContext = context;
    }

    public void setPresenter(HomePresenter presenter) {
        this.mHomePresenter = presenter;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public HomeBean.DataBean getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (contentView == null) {
            Log.e("myMessage","contentView");
            viewHolder = new ViewHolder();
            contentView = View.inflate(mContext, R.layout.home_item,null);
            viewHolder.textView = (TextView) contentView.findViewById(R.id.tv);
            viewHolder.imageView = (ImageView) contentView.findViewById(R.id.imageView);
            contentView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) contentView.getTag();
        }
        viewHolder.textView.setText(getItem(position).getNews_title());
        mHomePresenter.getImageFormServer(viewHolder.imageView,getItem(position).getPic_url());
        return contentView;
    }

    public void setData(List<HomeBean.DataBean> data) {
        if (data != null) {
            this.data.addAll(data);
        }

    }

    static class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}
