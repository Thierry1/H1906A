package com.longhengrui.oa.mvp.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;
import com.longhengrui.oa.util.ActivityMangerUtil;

public class ForgetThePasswordActivity extends IBaseActivity implements View.OnClickListener {
    private ImageView mIvForgetReturn;
    private ImageView mIvForgetUser;
    /**
     * 请输入登录账号
     */
    private EditText mEdForgetUser;
    private ImageView mIvForgetCode;
    /**
     * 请输入验证码
     */
    private EditText mEdForgetCode;
    /**
     * 发送验证码
     */
    private TextView mTvForgetCode;
    private ImageView mIvForgetNext;
    /**
     * 下一步
     */
    private TextView mTvForgetNext;
    private Intent intent;


    @Override
    protected void initListenner() {
        mIvForgetReturn.setOnClickListener(this);
        mIvForgetUser.setOnClickListener(this);
        mEdForgetUser.setOnClickListener(this);
        mIvForgetCode.setOnClickListener(this);
        mEdForgetCode.setOnClickListener(this);
        mTvForgetCode.setOnClickListener(this);
        mIvForgetNext.setOnClickListener(this);
        mTvForgetNext.setOnClickListener(this);
    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_forget_the_password;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            //返回到登陆界面
            case R.id.iv_forget_return:
                ActivityMangerUtil.startActivity(this, LoginActivity.class, false);
                break;
            //输入登录账号
            case R.id.ed_forget_user:
                break;
            //输入验证码
            case R.id.ed_forget_code:
                break;
            //下一步的按钮
            case R.id.iv_forget_next:
            case R.id.tv_forget_next:
                intent = new Intent(this, RetrievePasswordActivity.class);
                startActivity(intent);
                break;
            //发送验证码
            case R.id.tv_forget_code:
                break;
            case R.id.iv_forget_user:
                break;
            case R.id.iv_forget_code:
                break;
        }
    }


    public void initView() {
        mIvForgetReturn = (ImageView) findViewById(R.id.iv_forget_return);
        mIvForgetUser = (ImageView) findViewById(R.id.iv_forget_user);
        mEdForgetUser = (EditText) findViewById(R.id.ed_forget_user);
        mIvForgetCode = (ImageView) findViewById(R.id.iv_forget_code);
        mEdForgetCode = (EditText) findViewById(R.id.ed_forget_code);
        mTvForgetCode = (TextView) findViewById(R.id.tv_forget_code);
        mIvForgetNext = (ImageView) findViewById(R.id.iv_forget_next);
        mTvForgetNext = (TextView) findViewById(R.id.tv_forget_next);
    }
}
