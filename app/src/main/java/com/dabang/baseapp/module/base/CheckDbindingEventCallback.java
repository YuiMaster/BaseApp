package com.dabang.baseapp.module.base;

/**
 * Created by Jane on 2017/7/27.
 * 可用于checkbox 选中是否状态监听
 * android:onCheckedChanged="@{(cb, isChecked) -> event.onChecked(bean, isChecked)}"
 */

public interface CheckDbindingEventCallback<T> extends DbindingEventCallback {
    //checkbox 带选择的
    void onChecked(T t, boolean isChecked);

}
