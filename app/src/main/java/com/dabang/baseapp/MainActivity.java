package com.dabang.baseapp;

import android.os.Bundle;

import com.dabang.baseapp.activity.BaseActivity;
import com.dabang.baseapp.module.main.MainFragment;

import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseActivity {
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public SupportFragment getRootFragment() {
        mainFragment = MainFragment.getInstance();
        return mainFragment;
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }
}
