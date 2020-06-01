package com.longhengrui.oa.base;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.longhengrui.oa.app.App;

public abstract class BaseActivity<P extends BasePresenter, T> extends IBaseActivity<T> implements IBaseView<T> {
    // private Unbinder unbinder;
    private int layoutId;
    private Window window;
    private P mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null)
            mPresenter = createPresenter();
        //2.P层关联V层的生命周期
        mPresenter.attachView(this);
    }

    public P getmPresenter() {
        if (mPresenter != null)
            return mPresenter;
        return null;
    }

    protected abstract P createPresenter();

    protected abstract void initView();

    protected abstract void initListenner();

    protected abstract void onViewCreated();

    protected abstract int getLayout();


    @Override
    protected void onDestroy() {
            super.onDestroy();
        //3.P层释放V层引用
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}

