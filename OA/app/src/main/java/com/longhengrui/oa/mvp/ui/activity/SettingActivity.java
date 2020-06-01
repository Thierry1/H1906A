package com.longhengrui.oa.mvp.ui.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;

public class SettingActivity extends IBaseActivity implements View.OnClickListener {


    private ImageView mIvSettingReturn;
    private RelativeLayout mSettingHead;
    private RelativeLayout mSettingUser;
    /**
     * 退出登录
     */
    private Button mSettingBtExit;
    private Intent intent;
    private Intent intent1;
    private Intent intent2;
    private PopupWindow popupWindow;
    private TextView mTvSettingExitLogin;
    private TextView mTvSettingCancle;

    @Override
    protected void initView() {

        mIvSettingReturn = (ImageView) findViewById(R.id.iv_setting_return);
        mIvSettingReturn.setOnClickListener(this);
        mSettingHead = (RelativeLayout) findViewById(R.id.setting_head);
        mSettingHead.setOnClickListener(this);
        mSettingUser = (RelativeLayout) findViewById(R.id.setting_user);
        mSettingUser.setOnClickListener(this);
        mSettingBtExit = (Button) findViewById(R.id.setting_bt_exit);
        mSettingBtExit.setOnClickListener(this);
    }

    @Override
    protected void initListenner() {

    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
                //返回我的
            case R.id.iv_setting_return:
                intent = new Intent(this, MyMainActivity.class);
                startActivity(intent);
                break;
                //设置头像
            case R.id.setting_head:
                intent1 = new Intent(this, SettingHeadActivity.class);
                startActivity(intent1);
                break;
                //设置用户名
            case R.id.setting_user:
                intent2 = new Intent(this, SettingUserActivity.class);
                startActivity(intent2);
                break;
                //退出登录
            case R.id.setting_bt_exit:
                popu();
                break;

        }
    }

        //弹出popu选择头像
        public void popu() {
            //初始化界面
            View view = View.inflate(this, R.layout.popu_exit_login, null);
            mTvSettingExitLogin = findViewById(R.id.tv_setting_exit_login);
            mTvSettingExitLogin .setOnClickListener(this);
            mTvSettingCancle = findViewById(R.id.tv_setting_cancle);
            mTvSettingCancle .setOnClickListener(this);

//创建popuWindrow      设置布局  宽  高
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//focusable 可聚焦的   一般用在 需要有EditText的popu中
            popupWindow.setFocusable(true);
//点击外部弹框小时   必须跟popupWindow.setBackgroundDrawable(new BitmapDrawable());  一起用才有效
            popupWindow.setOutsideTouchable(true);
//背景
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
//   以下四行：设置弹框自带阴影
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.alpha = 0.3f;
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);  //flag 标识 dim 变暗的 变模糊的 behind  落后的
            getWindow().setAttributes(params);
//还原透明设置
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    WindowManager.LayoutParams params = getWindow().getAttributes();
                    params.alpha = 1.0f;
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                    getWindow().setAttributes(params);
                }
            });
//设置弹框的动画    如果不设置动画弹出和收回都很僵硬 很快执行完毕
            popupWindow.setAnimationStyle(R.style.MyPopuStyle);
//以整个屏幕为参照弹出
            popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);


    }
}
