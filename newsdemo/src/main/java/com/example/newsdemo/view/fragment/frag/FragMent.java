package com.example.newsdemo.view.fragment.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.newsdemo.R;
import com.example.newsdemo.modle.bean.NewsContentBean;
import com.example.newsdemo.presenter.FragPresenter;
import com.example.newsdemo.view.adapter.FratgAdapter;
import com.example.newsdemo.view.fragment.ContentEvery;
import com.example.newsdemo.view.iview.IFragView;

import java.util.List;

/**
 * name ：李飞宇
 * Date: 2017/5/12
 * desc:
 */

public class FragMent extends Fragment implements IFragView<NewsContentBean> {

    private ListView vp_lv;
    private FragPresenter fragpresenter;
    private FratgAdapter fratgAdapter;
    private String pp;
    private List<NewsContentBean.ResultBean.DataBean> list;

    public FragMent(String pp) {
        this.pp = pp;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f1_vp_listview, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        fragpresenter = new FragPresenter();
        fragpresenter.attachView(this);
        fratgAdapter = new FratgAdapter(getActivity());
        fratgAdapter.setPresenter(fragpresenter);
        vp_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ContentEvery.class);
                String stt = null;
                if (list != null) {
                    stt = list.get(position).getUrl();
                }
                intent.putExtra("aa", stt);
                startActivity(intent);
            }
        });
        vp_lv.setAdapter(fratgAdapter);
        fragpresenter.getFragDataFromServer(NewsContentBean.class, pp);

    }

    private void initView() {
        vp_lv = (ListView) getView().findViewById(R.id.vp_lv);

}

    @Override
    public void fragcallbackstr(NewsContentBean newsContentBean) {
        list = newsContentBean.getResult().getData();
        fratgAdapter.setData(newsContentBean.getResult().getData());
        fratgAdapter.notifyDataSetChanged();

    }

    @Override
    public void fragcallbackErr(String errMsg, int errCode) {

    }
}
