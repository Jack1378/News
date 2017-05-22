package com.example.newsdemo.view.iview;


/**
 * name ：李飞宇
 * Date: 2017/5/12
 * desc: 
 */

public interface IHomeView<T> extends IMvpView {

    void callbackStr(T t);

    void callbackErr(String errMsg, int errCode);
}
