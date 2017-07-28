package com.dabang.baseapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dabang.baseapp.R;
import com.dabang.baseapp.utils.StringUtils;

import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultVerticalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by Jane on 2017/7/27.
 */

public abstract class BaseFragment extends RxFragment {
    public View root;

    public int showPosition = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(getLayoutId(), container, false);
        loadFragment(savedInstanceState);
        init(savedInstanceState);
        return root;
    }


    //获得容器布局文件
    public abstract int getLayoutId();

    //初始化
    public abstract void init(Bundle savedInstanceState);


    //获得子Fragment
    public SupportFragment getChildFragment() {
        return null;
    }

    //获得子Fragments
    public SupportFragment[] getMultileChildFragments() {
        return null;
    }

    //加载Fragment
    public void loadFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            if (getChildFragment() != null) {
                loadRootFragment(R.id.fl_child_container, getChildFragment());
            } else if (getMultileChildFragments() != null) {
                loadMultipleRootFragment(R.id.fl_child_container, showPosition, getMultileChildFragments());
            }
        }
    }

    /**
     * 初始化toolbar  带men 的toolBar
     *
     * @param titleRes
     * @param menTxtRes
     * @param menImgResId
     */
    public void initMenuToolBar(Object titleRes, int menTxtRes, int menImgResId) {
        if (root == null) return;
        AppCompatActivity activity = ((AppCompatActivity) getActivity());
        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        TextView toobarTitleTv = (TextView) root.findViewById(R.id.txt_title);
        TextView toobarMenTv = (TextView) root.findViewById(R.id.txt_toobar_menu);
        ImageButton toobarMenImgBtn = (ImageButton) root.findViewById(R.id.imgBtn_toobar_menu);

        if (toolbar != null) {
            //各种设置必须在setSupportActionBar()方法之前否则无效
            toolbar.setNavigationIcon(R.mipmap.icon_nav_n_back);
            activity.setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNavigateClick();
                }
            });
            activity.getSupportActionBar().setDisplayShowHomeEnabled(false);
            //是否显示导航图标
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            if (toobarTitleTv != null) {
                activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
                if (titleRes instanceof Integer && (Integer) titleRes > 0) {
                    String title = getResources().getString((int) titleRes);
                    if (!StringUtils.isEmpty(title)) {
                        toobarTitleTv.setText(title);
                    }
                } else if (titleRes instanceof String) {
                    if (!StringUtils.isEmpty((String) titleRes)) {
                        toobarTitleTv.setText((String) titleRes);
                    }
                }
            }

            if (toobarMenTv != null) {
                if (menTxtRes > 0) {
                    String menTxt = getResources().getString(menTxtRes);
                    if (!StringUtils.isEmpty(menTxt)) {
                        toobarMenTv.setText(menTxt);
                        toobarMenTv.setVisibility(View.VISIBLE);
                        toobarMenTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                onMenuClick(view);
                            }
                        });
                    }
                }
            }
        }

        if (toobarMenImgBtn != null) {
            if (menImgResId > 0) {
                toobarMenImgBtn.setImageResource(menImgResId);
                toobarMenImgBtn.setVisibility(View.VISIBLE);
                toobarMenImgBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onMenuClick(view);
                    }
                });
            }
        }

    }


    //Toolbar 导航图标点击
    public void onNavigateClick() {
        _mActivity.onBackPressed();
    }


    //Toolbar menu图标点击
    public void onMenuClick(View view) {

    }

    //懒加载初始化 懒加载+viewPager 下的懒加载
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
    }


    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultVerticalAnimator();
    }


    @Override
    public void onPause() {
        super.onPause();
        hideSoftInput();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
