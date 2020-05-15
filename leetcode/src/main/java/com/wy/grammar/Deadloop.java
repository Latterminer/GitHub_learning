package com.wy.grammar;

/**
 * @author wy
 * @date 2020/5/11
 * @description
 */
public class Deadloop {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + "init deadloopClass");
            while (true) {
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                Deadloop deadloop = new Deadloop();
                System.out.println(Thread.currentThread() + "run over");
            }
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
