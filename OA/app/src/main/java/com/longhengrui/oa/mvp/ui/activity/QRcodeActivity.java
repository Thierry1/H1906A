package com.longhengrui.oa.mvp.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;
import com.longhengrui.oa.mvp.ui.activity.ReginActivity.MyThread;
import com.longhengrui.oa.util.ActivityMangerUtil;

public class QRcodeActivity extends IBaseActivity implements View.OnClickListener {


    private ImageView mIvQrCodeReturn;
    private ImageView mMyQrHead;
    /**
     * 用户名
     */
    private TextView mTvQrUser;
    private ImageView mIvQr;

    @Override
    protected void initView() {
        mIvQrCodeReturn = (ImageView) findViewById(R.id.iv_qr_code_return);
        mMyQrHead = (ImageView) findViewById(R.id.my_qr_head);
        mTvQrUser = (TextView) findViewById(R.id.tv_qr_user);
        mIvQr = (ImageView) findViewById(R.id.iv_qr);
        mIvQr.setOnClickListener(this);
        mIvQrCodeReturn.setOnClickListener(this);
        mMyQrHead.setOnClickListener(this);
        mTvQrUser.setOnClickListener(this);
    }

    @Override
    protected void initListenner() {

    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_qrcode;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            //用户的二维码
            case R.id.iv_qr:
                break;
            case R.id.iv_qr_code_return:
                ActivityMangerUtil.startActivity(this, MyMainActivity.class, false);
                break;
            //用户头像
            case R.id.my_qr_head:
                break;
            //用户名
            case R.id.tv_qr_user:
                break;
        }
    }


}
