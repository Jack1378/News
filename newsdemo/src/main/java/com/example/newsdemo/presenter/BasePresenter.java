package com.example.newsdemo.presenter;

import com.example.newsdemo.view.iview.IMvpView;

/**
 * name ：李飞宇
 * Date: 2017/5/12
 * desc:
 */

public class BasePresenter<T extends IMvpView> {
    //自定义两个方法
    private T mt;

    public void attachView(T t) {
        this.mt = t;
    }

    public T getT() {
        return mt;
    }
}
