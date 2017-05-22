package com.example.newsdemo.view.iview;

/**
 * name ：李飞宇
 * Date: 2017/5/13
 * desc:
 */

public interface IFragView<T> extends IMvpView {
    void fragcallbackstr(T t);

    void fragcallbackErr(String errMsg, int errCode);
}
