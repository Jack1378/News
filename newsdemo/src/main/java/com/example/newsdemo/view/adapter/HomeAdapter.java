package com.example.newsdemo.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.newsdemo.R;
import com.example.newsdemo.modle.bean.NewsTitlebean;

import java.util.ArrayList;
import java.util.List;

/**
 * name ：李飞宇
 * Date: 2017/5/12
 * desc: 适配器
 */

public class HomeAdapter extends FragmentPagerAdapter {

    private List<NewsTitlebean.ResultBean.DateBean> data;
    private List<Fragment> frags;
    private FragmentManager fml;

    public HomeAdapter(FragmentManager fm, List<Fragment> frags, List<NewsTitlebean.ResultBean.DateBean> date) {
        super(fm);
        this.data = date;
        this.frags = frags;
        this.fml = fm;
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getTitle();
    }

    public void setData(List<NewsTitlebean.ResultBean.DateBean> date) {
        if (data != null) {
            this.data.addAll(date);
        }
    }
}
