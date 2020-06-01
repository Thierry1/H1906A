package com.longhengrui.oa.mvp.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;
import com.longhengrui.oa.util.ActivityMangerUtil;

public class HomepageActivity extends IBaseActivity implements View.OnClickListener {

    private static final String TAG = "点击";
     /**
      * 扫一扫
      * */
    private ImageView mIvScan;
    private ImageView mIvEllipse1;
    /**
     * 登录/注册
     */
    private TextView mTvLoginRegin;
    private ImageView mIvVideo;
    private ImageView mIvJoinUs;
    private ImageView mIvGeneralize;
    /**
     * 视频
     */
    private TextView mTvVideo;
    /**
     * 加入我们
     */
    private TextView mTvJoinUs;
    /**
     * 推广APP
     */
    private TextView mTvGeneralize;
    private ImageView mIvMy;
    private ImageView mIvList;
    private ImageView mIvMessage;
    /**
     * 我的
     */
    private TextView mTvMy;
    /**
     * 好友列表
     */
    private TextView mTvList;
    /**
     * 消息
     */
    private TextView mTvMessage;
    private Intent intent;
    private Intent intent1;
    private Intent intent2;
    private Intent intent3;


    @Override
    protected void initView() {
        mIvScan = (ImageView) findViewById(R.id.iv_scan);
        mIvEllipse1 = (ImageView) findViewById(R.id.iv_ellipse_1);
        mTvLoginRegin = (TextView) findViewById(R.id.tv_login_regin);
        mIvVideo = (ImageView) findViewById(R.id.iv_video);
        mIvJoinUs = (ImageView) findViewById(R.id.iv_join_us);
        mIvGeneralize = (ImageView) findViewById(R.id.iv_generalize);
        mTvVideo = (TextView) findViewById(R.id.tv_video);
        mTvJoinUs = (TextView) findViewById(R.id.tv_join_us);
        mTvGeneralize = (TextView) findViewById(R.id.tv_generalize);
        mIvMy = (ImageView) findViewById(R.id.iv_my);
        mIvList = (ImageView) findViewById(R.id.iv_list);
        mIvMessage = (ImageView) findViewById(R.id.iv_message);
        mTvMy = (TextView) findViewById(R.id.tv_my);
        mTvList = (TextView) findViewById(R.id.tv_list);
        mTvMessage = (TextView) findViewById(R.id.tv_message);
    }

    //初始化监听器
    @Override
    protected void initListenner() {
        mIvScan .setOnClickListener(this);
        mIvEllipse1 .setOnClickListener(this);
        mTvLoginRegin .setOnClickListener(this);
        mIvVideo .setOnClickListener(this);
        mTvVideo .setOnClickListener(this);
        mIvJoinUs.setOnClickListener(this);
        mIvGeneralize .setOnClickListener(this);
        mTvJoinUs .setOnClickListener(this);
        mTvGeneralize .setOnClickListener(this);
        mIvMy .setOnClickListener(this);
        mIvList .setOnClickListener(this);
        mIvMessage .setOnClickListener(this);
        mTvMy .setOnClickListener(this);
        mTvList.setOnClickListener(this);
        mTvMessage .setOnClickListener(this);

    }

    //初始化控件
    @Override
    protected void onViewCreated() {
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //视频
            case R.id.iv_video:
            case R.id.tv_video:
                intent2 = new Intent(this, VideoMainActivity.class);
                startActivity(intent2);
                break;
            //加入我们
            case R.id.iv_join_us:
            case R.id.tv_join_us:
                ActivityMangerUtil.startActivity(this, JoinUsMainActivity.class, false);
                break;
            //推广APP
            case R.id.iv_generalize:
            case R.id.tv_generalize:
                ActivityMangerUtil.startActivity(this, GeneralizeMainActivity.class, false);
                break;
            //我的
            case R.id.iv_my:
            case R.id.tv_my:
                ActivityMangerUtil.startActivity(this, MyMainActivity.class, false);
                break;
            //好友列表
            case R.id.iv_list:
            case R.id.tv_list:
                ActivityMangerUtil.startActivity(this, ListMainActivity.class, false);
                break;
            //信息
            case R.id.iv_message:
            case R.id.tv_message:
                intent3 = new Intent(this, MessageMainActivity.class);
                startActivity(intent3);
                break;
            //登录/注册
            case R.id.tv_login_regin:
                intent = new Intent(this, ReginActivity.class);
                startActivity(intent);
                break;
            //扫一扫
            case R.id.iv_scan:
                ActivityMangerUtil.startActivity(this, ScanActivity.class, false);
                break;
                //我的头像
            case R.id.iv_ellipse_1:
                intent1 = new Intent(this, SettingHeadActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == SettingHeadActivity.RESULT_OK) {
            Uri uri = data.getData();
            mIvEllipse1.setImageURI(uri);
        }
    }


}
