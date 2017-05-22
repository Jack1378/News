package com.example.newsdemo.view.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.newsdemo.R;
import com.example.newsdemo.modle.tool.Night_styleutils;
import com.example.newsdemo.view.fragment.Fragment_1;
import com.example.newsdemo.view.fragment.Fragment_2;
import com.example.newsdemo.view.fragment.Fragment_3;
import com.example.newsdemo.view.fragment.Fragment_4;
import com.umeng.socialize.UMShareAPI;

public class MainActivity extends FragmentActivity {

    private RadioGroup radioGroup;
    private int theme = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Night_styleutils.changeStyle(this, theme, savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDat();
    }

    //夜间切换效果
    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);//进入动画
        finish();
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        startActivity(intent);
    }

    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.radio);

    }

    private void initDat() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radio_home_page:
                        addFragments(new Fragment_1());
                        break;
                    case R.id.radio_video:
                        addFragments(new Fragment_2());
                        break;
                    case R.id.radio_headline:
                        addFragments(new Fragment_3());
                        break;
                    case R.id.radio_mine:
                        addFragments(new Fragment_4());
                        break;
                }
            }
        });
        // 动态添加fragment
        addFragments(new Fragment_1());
    }

    private void addFragments(Fragment f) {
        // 第一步：得到fragment管理类
        FragmentManager manager = getSupportFragmentManager();
        // 第二步：开启一个事务
        FragmentTransaction transaction = manager.beginTransaction();
        // 第三步：调用添加fragment的方法 第一个参数：容器的id 第二个参数：要放置的fragment的一个实例对象
        transaction.replace(R.id.frag, f);
        // 第四步：提交
        transaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }


}
