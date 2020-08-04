package com.wy.jvm.daily;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author wy
 * @date 2020/5/23
 * @description
 */
public class DeadloopVsSleep {

    static class SleepN implements Runnable {
        @Override
        public void run() {
            try {
                Thread.currentThread().setName("sleeping-thread");
                TimeUnit.MINUTES.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class DeadLoop implements Runnable {
        @Override
        public void run() {
            Thread.currentThread().setName("deadloop-thread");
            while (!Thread.currentThread().isInterrupted()) {
                Thread.currentThread().interrupt();
                System.out.println("dead loop");
            }
        }
    }



    public static void main(String[] args) {
//        final CompletableFuture<Void> sleepFuture = CompletableFuture.runAsync(new SleepN());
//        final CompletableFuture<Void> deadLoopFuture = CompletableFuture.runAsync(new DeadLoop());
//        CompletableFuture.allOf(sleepFuture, deadLoopFuture).join();
        Thread thread = new Thread(new DeadLoop());
        thread.start();

    }
}
