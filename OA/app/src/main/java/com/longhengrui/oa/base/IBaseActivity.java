package com.longhengrui.oa.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.longhengrui.oa.app.App;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.util.jar.Attributes;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class IBaseActivity<T> extends AppCompatActivity implements IBaseView<T> {
    // private Unbinder unbinder;
    private int layoutId;
    private Window window;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutId = getLayout();
        if (layoutId != 0)
            setContentView(layoutId);
        App.getInstance().addActivity(this);
        // unbinder = ButterKnife.bind(this);
        //初始化控件
        initView();
        onViewCreated();
        //初始化监听
        initListenner();
        //隐藏操作栏
        window = getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @Override
    public void stateScuess(Object o) {
    }

    @Override
    public void stateError(String msg) {

    }

    protected abstract void initView();

    protected abstract void initListenner();

    protected abstract void onViewCreated();

    protected abstract int getLayout();


    @Override
    protected void onDestroy() {
        super.onDestroy();
       /* if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }*/
    }
}

