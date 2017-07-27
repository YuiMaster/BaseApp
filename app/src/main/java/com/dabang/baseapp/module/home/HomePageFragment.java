package com.dabang.baseapp.module.home;

import android.os.Bundle;

import com.dabang.baseapp.R;
import com.dabang.baseapp.fragments.BaseFragment;

/**
 * Created by Jane on 2017/7/27.
 */

public class HomePageFragment extends BaseFragment {
    private static HomePageFragment fragment;

    public static HomePageFragment getInstance() {
        fragment = new HomePageFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_homepage;
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }
}
