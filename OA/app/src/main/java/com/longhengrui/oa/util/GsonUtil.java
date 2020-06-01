package com.longhengrui.oa.util;

import com.google.gson.Gson;

/**
 * Gson解析工具类 解析各种不同格式的JSON串
 */
public class GsonUtil {
    static Gson gson;
    static {
        gson=new Gson();
    }
    public static <T> T jsonStrToBean(String jsonStr, Class<T> clazz) {
        return gson.fromJson(jsonStr, clazz);
    }
}
