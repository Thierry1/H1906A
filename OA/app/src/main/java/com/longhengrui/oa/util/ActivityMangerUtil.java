package com.longhengrui.oa.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityMangerUtil {
    public static <T> void startActivity(Activity context, Class<T> clazz, boolean isfinish) {
        context.startActivity(new Intent(context, clazz));
        if (isfinish) {
            context.finish();
        }
    }

    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        String s2 = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$";// 验证手机号
        if (!TextUtils.isEmpty(str)) {
            p = Pattern.compile(s2);
            m = p.matcher(str);
            b = m.matches();
        }
        return b;
    }


    public static String getCurrentTemp() {
        return Long.toString(System.currentTimeMillis() / 1000L);
    }

    public static String getNonce_str() {
        String strRand = "";
        for (int i = 0; i < 32; i++) {
            strRand += String.valueOf((int) (Math.random() * 10)); //[0.0,1) ===[0,9]
        }
        return strRand;
    }



    public static <T> String getSign(Map<String, T> map) {
        String buffer = "";
        if (map != null) {
            Set<String> keys = map.keySet();
            Object[] arr = keys.toArray(); // phone  time  nonce_str
            Arrays.sort(arr);
            for (Object key : arr) {
                //   nonce_str  >  phone >  time
                T t = map.get(key);
                if (t != null) {
                    //   nonce_str  >  phone >  time
                    buffer += key + "=" + t + "&";   // nonce_str=69721844581225711953649241263094&phone=13070091011&time=1589990182
                }
            }
        }
        buffer = buffer.trim() + "key=bolong";
        Log.e("tahashhdad", "====000000====================" + buffer);
        String md5Str = md5SignStr(buffer);
        Log.e("tahashhdad", "====000000===" + md5Str);
        return md5Str.toLowerCase();
    }

    private static String md5SignStr(String buffer) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    buffer.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

}
