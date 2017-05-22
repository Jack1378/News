package com.example.newsdemo.view.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsdemo.R;
import com.example.newsdemo.modle.bean.NewsTitlebean;
import com.example.newsdemo.presenter.HomePresenter;
import com.example.newsdemo.view.adapter.HomeAdapter;
import com.example.newsdemo.view.fragment.frag.FragMent;
import com.example.newsdemo.view.iview.IHomeView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * name ：李飞宇
 * Date: 2017/5/12
 * desc:
 */

public class Fragment_1 extends Fragment implements IHomeView<NewsTitlebean> {

    private ViewPager f1_vp;
    private List<NewsTitlebean.ResultBean.DateBean> list = new ArrayList<NewsTitlebean.ResultBean.DateBean>();
    private List<Fragment> frags = new ArrayList<>();
    private TabLayout tablayout;
    private HomeAdapter adapter;
    private FragmentManager fm;
    private HomePresenter homePresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();

    }

    private void initView() {
        tablayout = (TabLayout) getView().findViewById(R.id.tab_layouts);
        f1_vp = (ViewPager) getView().findViewById(R.id.F1_vp);
        fm = getActivity().getSupportFragmentManager();
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        tablayout.setupWithViewPager(f1_vp);
        homePresenter.getHomeDataFromServer(NewsTitlebean.class);
    }

    @Override
    public void callbackStr(NewsTitlebean newsTitlebean) {
        adapter = new HomeAdapter(fm, frags, newsTitlebean.getResult().getDate());
        f1_vp.setAdapter(adapter);
        for (int i = 0; i < newsTitlebean.getResult().getDate().size(); i++) {
            FragMent fragment = new FragMent(newsTitlebean.getResult().getDate().get(i).getUri());
            frags.add(fragment);
        }
        adapter.setData(newsTitlebean.getResult().getDate());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void callbackErr(String errMsg, int errCode) {

    }
}
