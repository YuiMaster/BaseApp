package com.dabang.baseapp.widget.viewpager;

import android.view.View;

/**
 * Created by Jane on 2017/7/27.
 */
public class DefaultTransformer extends ABaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
    }

    @Override
    public boolean isPagingEnabled() {
        return true;
    }

}
