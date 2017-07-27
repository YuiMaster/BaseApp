package com.dabang.baseapp.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Jane on 2017/7/27.
 */

public class BaseFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> datas;
    private List<String> stringList;

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> datas, List<String> list) {
        super(fm);
        this.datas = datas;
        this.stringList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
