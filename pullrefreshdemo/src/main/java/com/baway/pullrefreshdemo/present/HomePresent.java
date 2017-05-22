package com.baway.pullrefreshdemo.present;


import android.widget.ImageView;

import com.baway.pullrefreshdemo.mondel.utils.Utils;
import com.baway.pullrefreshdemo.view.iview.IHomeView;

import org.xutils.x;

/**
 * 类用途 :
 * 作者 : 郁文涛
 * 时间 : 2017/5/19 15:35
 */

public class HomePresent extends BasePresent<IHomeView> {

    private String url="http://apis.juhe.cn/cook/query.php?key=ce47d5a854cfc0ebbc7637573d30e27c&menu=秘制红烧肉";

    public <T> void getData(Class<T> t) {
        Utils.getUtils(url, new Utils.CallHomeBack<T>() {
            @Override
            public void callHome(T t) {
                getMt().callBack(t);
            }
        },t);
    }

    public void getImage(String url, ImageView imageView){
        x.image().bind(imageView,url);
    }
}
