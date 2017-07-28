package com.dabang.baseapp.module.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;

import com.dabang.baseapp.Main;
import com.dabang.baseapp.R;
import com.dabang.baseapp.fragments.BaseFragment;
import com.dabang.baseapp.module.event.EventFragment;
import com.dabang.baseapp.module.home.HomePageFragment;
import com.dabang.baseapp.module.me.MeMainFragment;
import com.dabang.baseapp.widget.BaseFragmentAdapter;
import com.dabang.baseapp.widget.viewpager.DefaultTransformer;
import com.dabang.widget.viewpager.ViewPager;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jane on 2017/7/27.
 */

public class MainFragment extends BaseFragment {
    private static MainFragment fragment;
    private List<String> pageTitleList;
    private List<Fragment> frgs;
    private ViewPager mVp;
    private BottomBar mBottomBar;
    private BaseFragmentAdapter mAdapter;

    private Main mBinding;      //databinding
    private int mTabIndex = 0;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_main;
    }

    public static MainFragment getInstance() {
        fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        initData();
        initView();
    }


    private void initData() {
        frgs = new ArrayList<Fragment>();

        HomePageFragment homePageFragment = HomePageFragment.getInstance();
        EventFragment eventFragment = EventFragment.getInstance();
        MeMainFragment meFragment = MeMainFragment.getInstance();
        frgs.add(homePageFragment);
        frgs.add(eventFragment);
        frgs.add(meFragment);

        pageTitleList = new ArrayList<>();
        pageTitleList.add(getResources().getString(R.string.home_page_str));
        pageTitleList.add(getResources().getString(R.string.event_str));
        pageTitleList.add(getResources().getString(R.string.me_str));
    }

    private void initView() {
        mBinding = DataBindingUtil.bind(root);
        mVp = mBinding.vp;
        mBottomBar = mBinding.bottomBar;
        mAdapter = new BaseFragmentAdapter(getFragmentManager(), frgs, pageTitleList);
        mVp.setAdapter(mAdapter);
        mVp.setPageTransformer(true, new DefaultTransformer());
        mVp.setOffscreenPageLimit(2);

        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabIndex = position;
                mBottomBar.selectTabAtPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_homePage:
                        switchViewPage(0);
                        break;
                    case R.id.tab_event:
                        switchViewPage(1);
                        break;
                    case R.id.tab_me:
                        switchViewPage(2);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void switchViewPage(int index) {
        if (mVp == null) return;
        if (mTabIndex != index) {
            mVp.setCurrentItem(index);
        }

    }
}
