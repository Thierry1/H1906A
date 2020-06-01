package com.longhengrui.oa.mvp.ui.activity;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;
import com.longhengrui.oa.util.ActivityMangerUtil;

import androidx.fragment.app.FragmentManager;


public class MyMainActivity extends IBaseActivity implements View.OnClickListener {


    private ImageView mIvMyReturn;
    private ImageView mMyIvSetting;
    private ImageView mIvQrCode;
    private RelativeLayout mMyRelaCode;
    private ImageView mIvData;
    private RelativeLayout mMyRelaData;

    private Intent intent;
    private FragmentManager manager;
    private Intent intent1;
    private Intent intent2;
    private Intent intent3;


    @Override
    protected void initView() {

        mIvMyReturn = (ImageView) findViewById(R.id.iv_my_return);
        mMyIvSetting = (ImageView) findViewById(R.id.my_iv_setting);
        mIvQrCode = (ImageView) findViewById(R.id.iv_qr_code);
        mMyRelaCode = (RelativeLayout) findViewById(R.id.my_rela_code);
        mIvData = (ImageView) findViewById(R.id.iv_data);
        mMyRelaData = (RelativeLayout) findViewById(R.id.my_rela_data);
        manager = getSupportFragmentManager();


    }

    @Override
    protected void initListenner() {
        mIvQrCode.setOnClickListener(this);
        mMyRelaData.setOnClickListener(this);
        mIvData.setOnClickListener(this);
        mMyRelaCode.setOnClickListener(this);
        mMyIvSetting.setOnClickListener(this);
        mIvMyReturn.setOnClickListener(this);

    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_my_main;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_my_return:
                ActivityMangerUtil.startActivity(this, HomepageActivity.class, false);
                break;
                //设置
            case R.id.my_iv_setting:
                intent3 = new Intent(this, SettingActivity.class);
                startActivity(intent3);
                break;
                //二维码
            case R.id.my_rela_code:
                intent1 = new Intent(this, QRcodeActivity.class);
                startActivity(intent1);
                break;
            case R.id.iv_data:
                break;
                //我的数据
            case R.id.my_rela_data:
                intent2 = new Intent(this, MyDataActivity.class);
                startActivity(intent2);
                break;
            case R.id.iv_qr_code:
                break;

        }
    }
}
