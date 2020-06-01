package com.longhengrui.oa.mvp.ui.fragment;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.BasePresenter;
import com.longhengrui.oa.mvp.presenter.NdaPresenter;
import com.longhengrui.oa.mvp.ui.common.LazyFragment;

public class NdaFragmnet extends LazyFragment {

    private NdaPresenter ndaPresenter;

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
        ndaPresenter = new NdaPresenter();
        return ndaPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nda;
    }

    @Override
    public void stateScuess(Object o) {

    }

    @Override
    public void stateError(String msg) {

    }
}
