package com.simple.commonlibrary.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 利用反射获取每个类的泛型
 * 使用性能问题方面待定
 * <p>
 * Created by hych on 2017/4/12.
 */

public class TUtil {

    @SuppressWarnings("unchecked")
    public static <T> T getT(Object o, int i) {
        try {
            Type type = o.getClass().getGenericSuperclass();
            Type[] actualTypeArguments = ((ParameterizedType) (type)).getActualTypeArguments();
            return ((Class<T>) actualTypeArguments[i]).newInstance();
        } catch (InstantiationException | ClassCastException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


//    /**
//     * 测试-反射举例
//     */
//    public void test() {
//        // 1,获取字节码文件
//        Class<?> clazz = Class.forName("com.example.reflecr.Reflex");
//        // 2,获取方法
//        Method method = clazz.getMethod("getReflex");
//        //3，创建对应字节码类的实例对象
//        Reflex reflex = (Reflex) clazz.newInstance();
//        //4，调用方法，拿到返回的string"测试"
//        String value = (String) method.invoke(reflex);
//    }
//
//    /**
//     * 测试-反射类
//     * package com.example.reflecr;
//     */
//    class Reflex {
//        public String getReflex() {
//            Log.i("TAG", "进来了反射");
//            String reflexResult = "测试";
//            return reflexResult;
//        }
//    }
}
