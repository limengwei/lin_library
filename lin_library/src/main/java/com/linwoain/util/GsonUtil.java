/**
 * 知我者为我心忧，不知我者谓我何求！
 * linwoain@outlook.com
 * 作者 linwoain
 * 日期 2014/12/15 18:01
 */
package com.linwoain.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author linwoain
 * @version 2014/12/15 18:01
 */
public class GsonUtil {

    private static Gson gson;

    /**
     * @return gson instance
     */
    public static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    /**
     * 将一个复合json转为一个内含列表的对象
     *
     * @param s   json字符串
     * @param t   类型
     * @param <T> 那个类
     * @return T类型的对象
     */

    public static <T> T get(String s, TypeToken<?> t) {
        return getGson().fromJson(s, t.getType());
    }

    /**
     * 将一个json对象转换为java对象
     *
     * @param s        待转换的值
     * @param classOfT 要转换的类型
     * @param <T>      类型
     * @return 转换后java对象
     */
    public static <T> T get(String s, Class<T> classOfT) {

        return getGson().fromJson(s, classOfT);
    }

    /**
     * 将对象中字段转为json字符串
     *
     * @param o 一个对象
     * @return json字符串
     */
    public static String toGson(Object o) {
        return getGson().toJson(o);
    }
}
