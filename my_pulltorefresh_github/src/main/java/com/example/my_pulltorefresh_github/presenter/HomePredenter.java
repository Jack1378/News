package com.example.my_pulltorefresh_github.presenter;

import android.widget.ImageView;

import com.example.my_pulltorefresh_github.modle.bean.utils.Utils;
import com.example.my_pulltorefresh_github.view.iview.IHomeView;
import com.example.my_pulltorefresh_github.view.iview.IMvpView;

import org.xutils.x;

/**
 * name ：李飞宇
 * Date: 2017/5/19
 * desc: 继承总的逻辑 泛型里面是接口用到那个是哪个 在里面写加载数据的内容
 */

public class HomePredenter extends BasePresenter<IHomeView> {
    //要加载的数据的网址
    String url = "http://apis.juhe.cn/cook/query.php?key=45fa345c876b34088d825cc939665ea0&menu=秘制红烧肉";

    //自定义的两个方法
    public <T> void getData(Class<T> t) {
        //调用Utils的工具类
        Utils.getUtils(url, new Utils.CalllHomeBack<T>() {

            @Override
            public void calllhomeBack(T t) {

                getMt().callBack(t);
            }
        }, t);
    }

    //获取图片的方法
    public void getImage(String url, ImageView imageView) {
        x.image().bind(imageView, url);
    }

}
