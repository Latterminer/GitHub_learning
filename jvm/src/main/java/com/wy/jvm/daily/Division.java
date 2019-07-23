package com.wy.jvm.daily;

/**
 * @author wy
 * @date 2019-07-16
 * @description 在乘方时Java发现结果（1000000000000）已经超出了int基本数据类型的最大范围（2147483647），
 * 于是作了默认的类型提升（type promotion），中间结果做为long类型存放，返回结果时目标数据类型int不能够容纳下结果，
 * 于是根据Java的基础类型的变窄转换（Narrowing primitive conversion）规则，把结果宽于int类型宽度的部分全部丢弃，
 * 也就是只取结果的低32位，于是就得到了上面的结果。
 */
public class Division {
    private static final long MILLIS_PER_DAY
            = 24 * 60 * 60 * 1000;
    /**
     * 如果所有的因子中不添加任何L则计算结果是int类型，会造成int溢出
     */
    private static final long MICROS_PER_DAY
            = 24L * 60 * 60 * 1000 * 1000;

    public static void main(String[] args) {
//        System.out.println(Long.toBinaryString(MICROS_PER_DAY));
//        //下一句的输出是5，而不是1000
//        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("1");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.start();
    }
}
