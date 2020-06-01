package com.longhengrui.oa.mvp.ui.activity;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;


public class MessageMainActivity extends IBaseActivity implements View.OnClickListener {


    private ImageView mIvMessageReturn;
    private RecyclerView mMessageRecycler;
    private Intent intent;

    @Override
    protected void initView() {

        mIvMessageReturn = (ImageView) findViewById(R.id.iv_message_return);
        mMessageRecycler = (RecyclerView) findViewById(R.id.message_recycler);

    }

    @Override
    protected void initListenner() {
        mIvMessageReturn.setOnClickListener(this);
        mMessageRecycler.setOnClickListener(this);
    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_message_main;
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
                //返回首页
            case R.id.iv_message_return:
                intent = new Intent(this, HomepageActivity.class);
                startActivity(intent);
                break;
            case R.id.message_recycler:
                break;
        }
    }
}
