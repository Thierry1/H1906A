package com.longhengrui.oa.di.component;

import android.content.SharedPreferences;

import com.longhengrui.oa.di.module.AppModule;
import com.longhengrui.oa.mvp.model.OkManagerModule;
import com.longhengrui.oa.mvp.model.api.ApiService;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

//专门对外提供单例(SP,OK,OkHttClient.Builder ,Retrofit和RetrofitBuidelr ApiService)的桥梁
@Singleton
@Component(modules = {AppModule.class, OkManagerModule.class})
public interface AppComponent {
    SharedPreferences provideSp();
    OkHttpClient provideOk();
    ApiService provideApiService();
}
