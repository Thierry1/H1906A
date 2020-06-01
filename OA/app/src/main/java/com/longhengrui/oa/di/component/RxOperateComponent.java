package com.longhengrui.oa.di.component;



import com.longhengrui.oa.di.annotation.PerSinglelton;
import com.longhengrui.oa.mvp.model.RxOperateImpl;

import dagger.Component;

@PerSinglelton
@Component(dependencies = AppComponent.class)
public interface RxOperateComponent {
    void inject(RxOperateImpl rxOperate);
}
