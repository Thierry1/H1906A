package com.longhengrui.oa.mvp.ui.activity;


import android.graphics.Typeface;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;
import com.longhengrui.oa.base.BasePresenter;
import com.longhengrui.oa.util.ActivityMangerUtil;


public class LoginActivity extends IBaseActivity implements View.OnClickListener {


    /**
     * 忘记密码
     */
    private TextView mTvForgetThePassword;
    /**
     * 账号密码登录
     */
    private RadioButton mRadioLoginAccountNumber;
    /**
     * 短信快捷登录
     */
    private RadioButton mRadioLoginNote;
    private RadioGroup mRgLogin;
    private ImageView mIvLoginReturn;
    /**
     * 请输入手机号
     */
    private EditText mEdLoginPhone;
    /**
     * 密码
     */
    private TextView mTvPassword;
    /**
     * 请输入你的密码
     */
    private EditText mEdPassword;
    private LinearLayout mLoginLlPassword;
    /**
     * 验证码
     */
    private TextView mTvLoginCode;
    /**
     * 请输入验证码
     */
    private EditText mEdLoginCode;
    private LinearLayout mLoginLlCode;
    /**
     * 需要勾选同意《OA系统协议》!
     */
    private TextView mTvAgreement;
    private ImageView mIvReginLogin;
    /**
     * 登录
     */
    private TextView mTvLogin;
    /**
     * 立即注册
     */
    private TextView mTvRegin;


    @Override
    protected void initListenner() {
        mIvLoginReturn.setOnClickListener(this);
        mEdLoginPhone.setOnClickListener(this);
        mEdPassword.setOnClickListener(this);
        mLoginLlPassword.setOnClickListener(this);
        mTvPassword.setOnClickListener(this);
        mTvLoginCode.setOnClickListener(this);
        mEdLoginCode.setOnClickListener(this);
        mLoginLlCode.setOnClickListener(this);
        mTvAgreement.setOnClickListener(this);
        mIvReginLogin.setOnClickListener(this);
        mTvLogin.setOnClickListener(this);
        mTvForgetThePassword.setOnClickListener(this);
        mTvRegin.setOnClickListener(this);
    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            //返回注册页面
            case R.id.iv_login_return:
                //立即注册
            case R.id.tv_regin:
                ActivityMangerUtil.startActivity(LoginActivity.this,
                        ReginActivity.class, false);
                break;
            //登录按钮的图文
            case R.id.iv_regin_login:
            case R.id.tv_login:
                if (mEdPassword != null && mEdPassword != null) {
                    ActivityMangerUtil.startActivity(LoginActivity.this, HomepageActivity.class, false);
                } else {
                    Toast.makeText(this, "手机号或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            //登录界面的手机号
            case R.id.ed_login_phone:
                break;
            case R.id.tv_password:
                break;
            case R.id.ed_password:
                break;
            case R.id.login_ll_password:
                break;
            case R.id.tv_login_code:
                break;
            case R.id.ed_login_code:
                break;
            case R.id.login_ll_code:
                break;
            case R.id.tv_agreement:
                break;
            case R.id.tv_forget_the_password:
                ActivityMangerUtil.startActivity(LoginActivity.this, ForgetThePasswordActivity.class, false);
                break;
                

        }

    }


    public void initView() {
        mTvForgetThePassword = (TextView) findViewById(R.id.tv_forget_the_password);
        mTvRegin = (TextView) findViewById(R.id.tv_regin);
        mRadioLoginAccountNumber = (RadioButton) findViewById(R.id.radio_login_account_number);
        mRadioLoginNote = (RadioButton) findViewById(R.id.radio_login_note);
        mRgLogin = (RadioGroup) findViewById(R.id.rg_login);
        mIvLoginReturn = (ImageView) findViewById(R.id.iv_login_return);
        mEdLoginPhone = (EditText) findViewById(R.id.ed_login_phone);
        mTvPassword = (TextView) findViewById(R.id.tv_password);
        mEdPassword = (EditText) findViewById(R.id.ed_password);
        mLoginLlPassword = (LinearLayout) findViewById(R.id.login_ll_password);
        mTvLoginCode = (TextView) findViewById(R.id.tv_login_code);
        mEdLoginCode = (EditText) findViewById(R.id.ed_login_code);
        mLoginLlCode = (LinearLayout) findViewById(R.id.login_ll_code);
        mTvAgreement = (TextView) findViewById(R.id.tv_agreement);
        mIvReginLogin = (ImageView) findViewById(R.id.iv_regin_login);
        mTvLogin = (TextView) findViewById(R.id.tv_login);

        /*
        * 登录方式的切换
        * */
        mTvRegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityMangerUtil.startActivity(LoginActivity.this, ReginActivity.class, false);
            }
        });
        mRgLogin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio_login_account_number:
                        mRadioLoginAccountNumber.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                        mRadioLoginNote.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                        mLoginLlCode.setVisibility(View.GONE);
                        mLoginLlPassword.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radio_login_note:
                        mRadioLoginNote.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                        mRadioLoginAccountNumber.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                        mLoginLlCode.setVisibility(View.VISIBLE);
                        mLoginLlPassword.setVisibility(View.GONE);
                        break;
                }
            }
        });

    }
}
