package com.baway.myrecycleview.present;


import android.widget.ImageView;

import com.baway.myrecycleview.mondel.utils.Utils;
import com.baway.myrecycleview.view.iview.HomeView;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.HashMap;


public class HomePresent extends BasePresnet<HomeView> {

    private String url="http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri=gj";
    private HashMap<String, String> hashMap = new HashMap<>();

    public <T> void setData(final Class<T> t) {
        Utils.getData(url, hashMap, new Utils.CallBackHome<T>() {
            @Override
            public void callBack(T t) {
                getMt().callBack(t);
            }
        }, t);
    }

    public void getImage(ImageView imageView, String path) {
        x.image().bind(imageView, path);
    }
}
