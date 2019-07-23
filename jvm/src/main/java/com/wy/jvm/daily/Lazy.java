package com.wy.jvm.daily;

/**
 * @author wy
 * @date 2019-07-23
 * @description 不管是匿名内置类还是lambda表达式都不能去依赖外部类的成员，否则会循环等待，
 *  lambda是dynamic机制，依赖当前类来加载，所以不能执行
 */
public class Lazy {

    private static boolean initialized = false;
    // Lazy static模块执行时（类不完全初始化），Runnable匿名内置类随之初始化
    //
    static {
        System.out.println("static");
        Thread t = new Thread(
                //case1: lambda表达式：InvokeDynamic，机制和匿名内置类并不一样 不能运行
//                () -> initialized = true
                //case2: 如果是匿名内置类，它的初始化不能依赖于外部类 不能运行
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("run");
//                        println("run"); hang 住了
                    }
                }
                //case3: 方法引用：invokeDynamic 能够运行 因为java.io.PrintStream是Bootstrapt classloader加载的
//                System.out::println
        );
        t.start();
        try {
            //
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    private static void println(Object object) {
        System.out.printf("线程 [%s] - %s", Thread.currentThread().getName(), object);
    }

    public static void main(String[] args) {
        //主线程
        System.out.println("main");
        System.out.println(initialized);
    }
}
