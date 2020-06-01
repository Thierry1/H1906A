package com.longhengrui.oa.mvp.ui.activity;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.BaseActivity;
import com.longhengrui.oa.base.IBaseActivity;
import com.longhengrui.oa.base.BasePresenter;
import com.longhengrui.oa.mvp.presenter.ReginPresenter;
import com.longhengrui.oa.util.ActivityMangerUtil;
import com.longhengrui.oa.util.CountDownTimerUtils;

import java.util.logging.LogRecord;


//注册页面
public class ReginActivity extends BaseActivity implements View.OnClickListener {

    public static boolean flag = false;

    private ImageView mIvRegisterReturn;
    /**
     * 请输入手机号
     */
    private EditText mEdPhone;
    /**
     * 请输入您的验证码
     */
    private EditText mEdReginCode;
    /**
     * 发送验证码
     */
    private TextView mTvCode;
    /**
     * 需要勾选同意《OA系统协议》!
     */
    private TextView mTvAgreement;
    private ImageView mIvReginLogin;
    private Intent intent;


    @Override
    protected BasePresenter createPresenter() {
        ReginPresenter reginPresenter = new ReginPresenter(this);
        return reginPresenter;
    }

    @Override
    protected void initView() {
        mIvRegisterReturn = (ImageView) findViewById(R.id.iv_register_return);
        mEdPhone = (EditText) findViewById(R.id.ed_phone);
        mEdReginCode = (EditText) findViewById(R.id.ed_regin_code);
        mTvCode = (TextView) findViewById(R.id.tv_code);
        mTvAgreement = (TextView) findViewById(R.id.tv_agreement);
        mIvReginLogin = (ImageView) findViewById(R.id.iv_regin_login);
    }

    @Override
    protected void initListenner() {
        mIvRegisterReturn.setOnClickListener(this);
        mEdPhone.setOnClickListener(this);
        mEdReginCode.setOnClickListener(this);
        mTvCode.setOnClickListener(this);
        mTvAgreement.setOnClickListener(this);
        mIvReginLogin.setOnClickListener(this);

    }


    @Override
    protected void onViewCreated() {

    }

    @Override
    public void onClick(View v) {
        String phone = null;
        switch (v.getId()) {
            //注册按钮
            case R.id.iv_regin_login:
                phone = mEdPhone.getText().toString().trim();
                if (!TextUtils.isEmpty(phone)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_LONG).show();
                } else {
                    if (ActivityMangerUtil.isMobile(phone)) {
                        //TODO 验证码判断
                    } else {
                        Toast.makeText(this, "手机号格式不正确，请重新输入", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            //返回的图标
            case R.id.iv_register_return:
                ActivityMangerUtil.startActivity(this, HomepageActivity.class, false);
                break;
            //发送验证码
            case R.id.tv_code:
                phone = mEdPhone.getText().toString().trim();
                getmPresenter().start(phone);

                CountDownTimerUtils mCountDownTimerUtils =
                        new CountDownTimerUtils(mTvCode, 60000, 1000);
                mCountDownTimerUtils.start();
                break;
            //跳转到协议页面
            case R.id.tv_agreement:
                intent = new Intent(this, AgreementActivity.class);
                startActivity(intent);
                break;
            case R.id.ed_phone:
                break;
            case R.id.ed_regin_code:
                break;
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_regin;
    }


}
