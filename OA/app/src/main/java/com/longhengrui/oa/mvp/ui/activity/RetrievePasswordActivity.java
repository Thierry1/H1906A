package com.longhengrui.oa.mvp.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;

public class RetrievePasswordActivity extends IBaseActivity implements View.OnClickListener {


    private ImageView mIvRetriveReturn;
    private EditText mEdRetrivePassword;
    private EditText mEdRetrivePasswordAgin;
    private ImageView mIvRetriveOk;
    private Intent intent;


    @Override
    protected void initView() {
        mIvRetriveReturn = (ImageView) findViewById(R.id.iv_retrive_return);
        mEdRetrivePassword = (EditText) findViewById(R.id.ed_retrive_password);
        mEdRetrivePasswordAgin = (EditText) findViewById(R.id.ed_retrive_password_agin);
        mIvRetriveOk = (ImageView) findViewById(R.id.iv_retrivet_ok);

    }

    @Override
    protected void initListenner() {
        mIvRetriveReturn.setOnClickListener(this);
        mEdRetrivePassword.setOnClickListener(this);
        mEdRetrivePasswordAgin.setOnClickListener(this);
        mIvRetriveOk.setOnClickListener(this);
    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_retrieve_password;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case R.id.iv_register_return:
            break;
            case R.id.ed_retrive_password:
                break;
            case R.id.ed_retrive_password_agin:
                break;
            case R.id.iv_retrivet_ok:
                intent = new Intent(this, HomepageActivity.class);
                startActivity(intent);
                break;
        }

    }
}
