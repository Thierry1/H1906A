package com.longhengrui.oa.mvp.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;

public class MyDataActivity extends IBaseActivity implements View.OnClickListener {


    private ImageView mMyDataReturn;
    private Intent intent;

    @Override
    protected void initView() {

        mMyDataReturn = (ImageView) findViewById(R.id.my_data_return);
        mMyDataReturn.setOnClickListener(this);
    }

    @Override
    protected void initListenner() {

    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_my_data;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.my_data_return:
                intent = new Intent(this, HomepageActivity.class);
                startActivity(intent);
                break;
        }
    }
}
