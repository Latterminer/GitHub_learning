package com.wy.concurrent.chapter5;

import java.util.concurrent.*;

/**
 * @author wy
 * @date 2019-06-11
 * @description 栅栏等待的是线程的到来，而CountDownLatch等待是某个事件触发
 */
public class CelluarAutomata {

    private final CyclicBarrier barrier;

    private final Worker[] workers;


    public CelluarAutomata() {
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, () -> System.out.println("Barrier Open!"));
        this.workers = new Worker[count];

        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(barrier);
        }
    }

    static class Worker implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public Worker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入。。。");
            try {
                //以睡眠来模拟写入数据操作
                TimeUnit.SECONDS.sleep(5);
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await(5000, TimeUnit.SECONDS);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        for (Worker worker : workers) {
            new Thread(worker).start();
        }
    }

    public static void main(String[] args) {
        CelluarAutomata celluarAutomata = new CelluarAutomata();
        celluarAutomata.start();
    }
}
