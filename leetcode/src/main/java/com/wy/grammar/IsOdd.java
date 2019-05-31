package com.wy.grammar;

/**
 * @author wy
 * @date 2019-05-29
 * @description
 */
public class IsOdd {

    private final static Integer counter;
    static  {
        counter = new Integer(10);
    }

    public static boolean isOdd(int i) {
        long start = System.nanoTime();
        boolean result = false;
        for (int loop = 0; loop < 10000; loop++) {
            result = (i & 1) == 1;
        }
        long end = System.nanoTime();
        System.out.println(end - start);
        return result;
    }

    public static boolean isOdd1(int i) {
        long start = System.nanoTime();
        boolean result = false;
        for (int loop = 0; loop < 10000; loop++) {
            result = i % 2 == 1;
        }

        long end = System.nanoTime();
        System.out.println(end - start);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isOdd(20000));
        System.out.println(isOdd1(20000));
    }
}
