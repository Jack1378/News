package com.baway.pullrefreshdemo.view.iview;

/**
 * 类用途 :
 * 作者 : 郁文涛
 * 时间 : 2017/5/19 15:33
 */

public interface IHomeView<T> extends IMvpView {
    void callBack(T t);
    void callBackHome(String pp,int code);
}
