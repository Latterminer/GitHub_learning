package com.wy.jvm.daily;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author wy
 * @date 2020/5/7
 * @description
 */
public class HumongousObjTest {
    public static void main(String[] args) {
        byte[] bigObj = new byte[1024 * 1024 * 100];
        int sleepCount = 0;
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println(sleepCount++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
