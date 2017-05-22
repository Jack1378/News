package com.example.my_pulltorefresh_github.presenter;

import com.example.my_pulltorefresh_github.view.iview.IMvpView;

/**
 * name ：李飞宇
 * Date: 2017/5/19
 * desc: 总逻辑
 * presenter 逻辑
 * modle     模型
 * view      视图
 * 添加泛型继承总接口 这样就跟总接口有联系了  接口调用
 * 泛型T表示：？
 */

public class BasePresenter<T extends IMvpView> {
    private T pt;

    public void getAttch(T t) {
        this.pt = t;
    }
    //返回T值
    public T getMt(){
        return pt;
    }
}
