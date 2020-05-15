package com.wy.grammar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author wy
 * @date 2020/5/13
 * @description
 */
public class ParallelStreamTest {
    public static void main(String[] args) throws IOException {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 9997; i < 10000; i++) {
//            integerList.add(i);
            ForkJoinPool.commonPool().execute(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        System.in.read();


//        integerList.stream().parallel().forEach(integer -> {
//            System.out.println(Thread.currentThread().getName() + ":" + integer);
//            try {
//                TimeUnit.SECONDS.sleep(integer);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
    }
}
