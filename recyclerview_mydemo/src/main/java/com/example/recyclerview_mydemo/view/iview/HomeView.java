package com.example.recyclerview_mydemo.view.iview;


public interface HomeView<T> extends IMvpView{

    void callBack(T t);
}
