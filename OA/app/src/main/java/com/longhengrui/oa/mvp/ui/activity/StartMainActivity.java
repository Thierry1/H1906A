package com.longhengrui.oa.mvp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.longhengrui.oa.R;

public class StartMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_main);
        //false   第一次打开
        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        boolean isclick = sp.getBoolean("isclick", true);
        if (isclick) {
            startActivity(new Intent(this, GuidePageActivity.class));
        }else{
            //该软件已经打开过了   viewpager只在安装软件的时候才会有   已经打开过的就不会有viewpager引导页
            startActivity(new Intent(StartMainActivity.this,
                    HomepageActivity.class));
        }
    }
}
