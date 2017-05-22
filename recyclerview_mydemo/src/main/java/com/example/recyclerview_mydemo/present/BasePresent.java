package com.example.recyclerview_mydemo.present;

import com.example.recyclerview_mydemo.view.iview.IMvpView;

/**
 * name ：李飞宇
 * Date: 2017/5/19
 * desc:
 */
class BasePresnet<T extends IMvpView> {
    private T mt;
    public void attachView(T t){
        this.mt=t;
    }

    public T getMt() {
        return mt;
    }

}
