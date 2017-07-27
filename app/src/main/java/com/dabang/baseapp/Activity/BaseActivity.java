package com.dabang.baseapp.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dabang.baseapp.AppExitEvent;
import com.dabang.baseapp.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultVerticalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by Jane on 2017/7/27.
 */
public abstract class BaseActivity extends RxActivity {
    public final String TAG = this.getClass().getSimpleName();
    public int showPosition = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (savedInstanceState == null) {
            if (getMultileRootFragments() != null) {
                loadMultipleRootFragment(R.id.fl_container, showPosition, getMultileRootFragments());
            } else {
                if (getRootFragment() != null) {
                    loadRootFragment(R.id.fl_container, getRootFragment());
                }
            }
        }
        init(savedInstanceState);
        EventBus.getDefault().register(this);

    }


    public void sendExitEvent() {
        EventBus.getDefault().post(new AppExitEvent());
    }


    //彻底退出APP
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAppExitEvent(AppExitEvent event) {
        finish();
    }


    //获得容器布局文件
    public abstract int getLayoutId();

    //获得添加到根目录的Fragment
    public abstract SupportFragment getRootFragment();

    //获得根目录下的Fragments
    public SupportFragment[] getMultileRootFragments() {
        return null;
    }

    public abstract void init(Bundle savedInstanceState);


    /*
    * fragment 切换动画
    * */
    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultVerticalAnimator();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}