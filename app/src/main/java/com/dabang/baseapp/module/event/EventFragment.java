package com.dabang.baseapp.module.event;

import android.os.Bundle;

import com.dabang.baseapp.R;
import com.dabang.baseapp.base.fragments.BaseFragment;
/**
 * Created by Jane on 2017/7/27.
 */

public class EventFragment extends BaseFragment {
    private static EventFragment fragment;

    public static EventFragment getInstance() {
        fragment = new EventFragment();
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_event;
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }
}
