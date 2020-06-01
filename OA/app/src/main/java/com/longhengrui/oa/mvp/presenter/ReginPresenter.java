package com.longhengrui.oa.mvp.presenter;

import android.util.Log;

import com.longhengrui.oa.base.BasePresenter;
import com.longhengrui.oa.callback.IDataCallBack;
import com.longhengrui.oa.mvp.model.RxOperateImpl;
import com.longhengrui.oa.mvp.model.api.Constants;
import com.longhengrui.oa.mvp.ui.activity.ReginActivity;
import com.longhengrui.oa.util.ActivityMangerUtil;
import com.longhengrui.oa.util.CountDownTimerUtils;
import com.longhengrui.oa.util.GsonUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class ReginPresenter extends BasePresenter {
    private ReginActivity mReginActivity;
    private RxOperateImpl mImpl;

    public ReginPresenter(ReginActivity activity) {
        this.mReginActivity = activity;
        this.mImpl = new RxOperateImpl();
    }

    @Override
    public void start(Object obj) {
        super.start(obj);
        if (obj instanceof String) {
            String phone = (String) obj;

            Log.e("TAG", "===0000==" + phone);
            Map<String, String> signMap = new HashMap<String, String>();
            Map<String, String> params = new HashMap<String, String>();
            params.put("phone", phone);
            params.put("time", ActivityMangerUtil.getCurrentTemp());
            params.put("nonce_str", ActivityMangerUtil.getNonce_str());

            //需要生成签名规则的参数
            signMap.put("phone", phone);
            signMap.put("time", ActivityMangerUtil.getCurrentTemp());
            signMap.put("nonce_str", ActivityMangerUtil.getNonce_str());

            params.put("sign", ActivityMangerUtil.getSign(signMap));

            mImpl.requestFormData(Constants.SEND_SMS, params, new IDataCallBack<ResponseBody>() {
                @Override
                public void onStateSucess(ResponseBody body) {
                    try {
                        String string = body.string();
                        mReginActivity.stateScuess(string);
                        Log.e("tahashhdad", string + "=====");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStateError(String msg) {
                    Log.e("TAG", msg + "=====");
                    mReginActivity.stateError(msg);
                }

                @Override
                public void onResponseDisposable(Disposable disposable) {
                    addDisposable(disposable);
                }
            });
        }
    }

}
