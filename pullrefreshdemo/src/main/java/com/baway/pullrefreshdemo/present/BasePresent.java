package com.baway.pullrefreshdemo.present;

import com.baway.pullrefreshdemo.view.activity.MainActivity;
import com.baway.pullrefreshdemo.view.iview.IMvpView;

/**
 * 类用途 :
 * 作者 : 郁文涛
 * 时间 : 2017/5/19 15:35
 */

public class BasePresent<T extends IMvpView> {
    private T mt;

    public void getAttach(T t) {
        this.mt = t;
    }

    public T getMt() {
        return mt;
    }
}
