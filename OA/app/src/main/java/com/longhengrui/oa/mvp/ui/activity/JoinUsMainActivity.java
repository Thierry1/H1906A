package com.longhengrui.oa.mvp.ui.activity;


import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;
import com.longhengrui.oa.R;
import com.longhengrui.oa.base.IBaseActivity;
import com.longhengrui.oa.mvp.ui.fragment.AgreementFragment;
import com.longhengrui.oa.mvp.ui.fragment.NdaFragmnet;


//加入我们
public class JoinUsMainActivity extends IBaseActivity implements View.OnClickListener {


    private ImageView mIvJoinUsReturn;
    private TabLayout mTabJoinUs;
    private FrameLayout mFrameJoinUs;
    private FragmentManager manager;
    private NdaFragmnet ndaFragmnet;
    private AgreementFragment agreementFragment;
    private int position;
    private Intent intent;

    @Override
    protected void initView() {
        mIvJoinUsReturn = findViewById(R.id.iv_join_us_return);
        mTabJoinUs = findViewById(R.id.tab_join_us);
        mFrameJoinUs = findViewById(R.id.frame_join_us);
    }

    @Override
    protected void initListenner() {
        mIvJoinUsReturn.setOnClickListener(this);
        ndaFragmnet = new NdaFragmnet();
        agreementFragment = new AgreementFragment();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        manager.beginTransaction().replace(R.id.frame_join_us, ndaFragmnet).hide(agreementFragment).commit();
        mTabJoinUs.addTab(mTabJoinUs.newTab().setText("保密协议"));
        mTabJoinUs.addTab(mTabJoinUs.newTab().setText("协议"));
        mTabJoinUs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                if (position == 0) {
                    manager.beginTransaction().replace(R.id.frame_join_us, ndaFragmnet).commit();
                }
                if (position == 1) {
                    manager.beginTransaction().replace(R.id.frame_join_us, agreementFragment).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_join_us_main;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_join_us_return:
                intent = new Intent(this, HomepageActivity.class);
                startActivity(intent);
                break;
        }

    }

}
