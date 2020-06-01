package com.longhengrui.oa.mvp.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.BasePresenter;
import com.longhengrui.oa.mvp.ui.common.LazyFragment;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountNumberFragment extends LazyFragment {


    @Override
    protected void stopLazyLoad() {

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void initInject() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_account_number;
    }

    @Override
    public void stateScuess(Object o) {

    }

    @Override
    public void stateError(String msg) {

    }
}
