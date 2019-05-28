package com.wy.interview;

/**
 * @Description:
 * @Author: wy
 * @CreateDate: 2018/11/9 17:47
 * @Version: 1.0
 */
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }


    public static void main(String[] args) {
        Singleton instance = Singleton.getSingleton();
        instance.showMessage();
    }
}
