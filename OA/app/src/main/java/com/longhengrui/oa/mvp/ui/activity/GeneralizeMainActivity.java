package com.longhengrui.oa.mvp.ui.activity;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;
import com.longhengrui.oa.util.ActivityMangerUtil;


public class GeneralizeMainActivity extends IBaseActivity implements View.OnClickListener {


    private ImageView mIvQrReturn;
    private ImageView mIvQr;
    private Intent intent;

    @Override
    protected void initView() {

        mIvQrReturn = findViewById(R.id.iv_qr_return);
        mIvQr = findViewById(R.id.iv_qr);
    }

    @Override
    protected void initListenner() {
        mIvQr.setOnClickListener(this);
        mIvQrReturn.setOnClickListener(this);

    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_generalize_main;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_qr_return:
                intent = new Intent(this, HomepageActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_qr:
                ActivityMangerUtil.startActivity(this,HomepageActivity.class,false);
                break;

        }
    }
}
