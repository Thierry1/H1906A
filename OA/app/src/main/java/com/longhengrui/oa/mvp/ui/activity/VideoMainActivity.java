package com.longhengrui.oa.mvp.ui.activity;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;


//视频
public class VideoMainActivity extends IBaseActivity implements View.OnClickListener {

    private ImageView mIvVideoReturn;
    private Intent intent;

    @Override
    protected void initView() {

        mIvVideoReturn = (ImageView) findViewById(R.id.iv_video_return);
        mIvVideoReturn.setOnClickListener(this);
    }

    @Override
    protected void initListenner() {


    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_video_main;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_video_return:
                intent = new Intent(this, HomepageActivity.class);
                startActivity(intent);
                break;
        }
    }


}
