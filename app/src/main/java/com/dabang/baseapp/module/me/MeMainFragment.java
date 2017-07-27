package com.dabang.baseapp.module.me;

import android.os.Bundle;

import com.dabang.baseapp.R;
import com.dabang.baseapp.fragments.BaseFragment;

/**
 * Created by Jane on 2017/7/27.
 */

public class MeMainFragment extends BaseFragment {
    private static MeMainFragment fragment;

    public static MeMainFragment getInstance() {
        fragment = new MeMainFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_me_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }
}
