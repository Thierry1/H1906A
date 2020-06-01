package com.longhengrui.oa.mvp.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.longhengrui.oa.R;
import com.longhengrui.oa.mvp.ui.adapter.GuidePageAdapter;
import com.longhengrui.oa.util.ActivityMangerUtil;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class GuidePageActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 跳过>
     */
    private TextView mTvSkip;
    private ViewPager mViewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page);

        initView();
        mTvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMangerUtil.startActivity(GuidePageActivity.this, HomepageActivity.class, false);

            }
        });
    }

    private void initView() {
        mTvSkip = (TextView) findViewById(R.id.tv_skip);
        mTvSkip.setOnClickListener(this);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mViewpager.setOnClickListener(this);

        // 数据源
        ArrayList<View> list = new ArrayList<>();
        View view1 = LayoutInflater.from(this).inflate(R.layout.fragment_vp1, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.fragment_vp2, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.fragment_vp3, null);
        list.add(view1);
        list.add(view2);
        list.add(view3);

        GuidePageAdapter myFragmentAdapter = new GuidePageAdapter(getSupportFragmentManager(), list);
        mViewpager.setAdapter(myFragmentAdapter);
        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        //该软件已经打开过了   viewpager只在安装软件的时候才会有   已经打开过的就不会有viewpager引导页
        edit.putBoolean("isclick",false);
        edit.commit();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;


        }
    }
}
