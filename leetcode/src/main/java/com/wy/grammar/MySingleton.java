package com.wy.grammar;

/**
 * @author wy
 * @date 2020/4/13
 * @description 单例模式，内部静态类，双重锁校验
 */
public class MySingleton {

    private volatile static MySingleton instance;

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            synchronized (MySingleton.class) {
                // 双重检查
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }
}
