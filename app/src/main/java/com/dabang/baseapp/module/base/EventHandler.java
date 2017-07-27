package com.dabang.baseapp.module.base;


/**
 * Created by Jane on 2017/7/27.
 * 绑定点击事件
 * 如果不带参数 xml 写法 handler::onClick
 * 带参数写法：(view)->handler.onClick(view,obj)
 */

import android.content.Context;
import android.view.View;

public class EventHandler<T> {
    private static final String TAG = EventHandler.class.getSimpleName();
    Context context;
    DbindingEventCallback<T> mCallback;

    public EventHandler(Context context) {
        this.context = context;
    }

    public EventHandler(Context context, DbindingEventCallback<T> callback) {
        this.context = context;
        mCallback = callback;
    }

    public void setEventCallback(DbindingEventCallback<T> callback) {
        this.mCallback = callback;
    }


    public void onClick(View view) {
        mCallback.onViewClick(view);
    }

    //必须是public 否则出错
    public void onClick(View view, T t) {
        mCallback.onViewClick(view, t);
    }

    public void onLongClick(View view) {
        mCallback.onViewLongClick(view);
    }

    public void onLongClick(View view, T t) {
        mCallback.onViewLongClick(view, t);
    }

    //checkbox 带选择的
    public void onChecked(T t, boolean isChecked) {
        if (mCallback != null && mCallback instanceof CheckDbindingEventCallback) {
            ((CheckDbindingEventCallback) mCallback).onChecked(t, isChecked);
        }
    }
}
