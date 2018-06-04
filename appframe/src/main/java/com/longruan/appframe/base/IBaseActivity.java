package com.longruan.appframe.base;

public interface IBaseActivity<T extends AbsBasePresenter> {

    void initInject();
    T getPresenter();
}
