package com.example.my_pulltorefresh_github.view.iview;

/**
 * name ：李飞宇
 * Date: 2017/5/19
 * desc: 自定义子接口 加个泛型
 */

public interface IHomeView<T> extends IMvpView {
    void callBack(T t);

    void callBackHome(String str, int code);
}
