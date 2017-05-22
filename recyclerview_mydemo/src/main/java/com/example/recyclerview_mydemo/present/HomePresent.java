package com.example.recyclerview_mydemo.present;

import android.widget.ImageView;

import com.example.recyclerview_mydemo.mondel.utils.Utils;
import com.example.recyclerview_mydemo.view.iview.HomeView;

import org.xutils.x;

import java.util.HashMap;

/**
 * name ：李飞宇
 * Date: 2017/5/19
 * desc:
 */
public class HomePresent extends BasePresnet<HomeView>{
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
