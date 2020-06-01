package com.longhengrui.oa.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;

public class SettingHeadActivity extends IBaseActivity implements View.OnClickListener {


    private ImageView mIvMySettingReturn;
    private ImageView mMySettingHeadSan;
    private ImageView mIvMySettingHead;
    private Intent intent;
    private PopupWindow popupWindow;
    private TextView mTvCancle;
    private TextView mMobileAlbum;
    private TextView mTvSaveImage;
    private Intent intent1;
    private Intent intent2;

    @SuppressLint("SdCardPath")
    private static String path = "/sdcard/myHead/"; //sd路径

    @Override
    protected void initView() {
        mIvMySettingReturn = (ImageView) findViewById(R.id.iv_my_setting_return);
        mMySettingHeadSan = (ImageView) findViewById(R.id.my_setting_head_san);
        mIvMySettingHead = (ImageView) findViewById(R.id.iv_my_setting_head);


    }

    @Override
    protected void initListenner() {
        mMySettingHeadSan.setOnClickListener(this);
        mIvMySettingReturn.setOnClickListener(this);
        mIvMySettingHead.setOnClickListener(this);
    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_setting_head;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_my_setting_return:
                intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
            //三个点
            case R.id.my_setting_head_san:
                popu();
                break;
            case R.id.iv_my_setting_head:
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 1);

                break;
        }
    }


    //弹出popu选择头像
    public void popu() {
        //初始化界面
        View view = View.inflate(this, R.layout.popu_view, null);
        mTvCancle =   view.findViewById(R.id.tv_cancle);

         mTvSaveImage = view. findViewById(R.id.tv_save_image);
        mMobileAlbum =view. findViewById(R.id.tv_mobile_album);
        //保存图片
        mTvSaveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // getBitmap();
            }
        });
        //取消
        mTvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        //从手机相册选择图片
        mMobileAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent2 = new Intent(Intent.ACTION_PICK);
                intent2.setType("image/*");
                startActivityForResult(intent2,1);
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == SettingHeadActivity.RESULT_OK) {
            Uri uri = data.getData();
            mIvMySettingHead.setImageURI(uri);
        }
    }


}
