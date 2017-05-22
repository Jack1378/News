package com.baway.myrecycleview.present;

import com.baway.myrecycleview.view.iview.IMvpView;

/**
 * 类用途 :
 * 作者 : 郁文涛
 * 时间 : 2017/5/17 21:00
 */

public class BasePresnet<T extends IMvpView> {
    private T mt;
    public void attachView(T t){
        this.mt=t;
    }

    public T getMt() {
        return mt;
    }
}
