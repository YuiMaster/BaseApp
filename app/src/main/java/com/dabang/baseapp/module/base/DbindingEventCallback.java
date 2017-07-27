package com.dabang.baseapp.module.base;

import android.view.View;

/**
 * Created by Jane on 2017/7/27.
 * dataBinding 事件绑定 回调
 */

public interface DbindingEventCallback<T> {

    //带参数的点击
    void onViewClick(View view, T t);

    void onViewClick(View view);


    //带参数的长点击
    void onViewLongClick(View view, T t);

    void onViewLongClick(View view);


}
