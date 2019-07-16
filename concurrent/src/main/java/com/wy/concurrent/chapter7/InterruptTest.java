package com.wy.concurrent.chapter7;

import java.util.concurrent.*;

/**
 * @author wy
 * @date 2019-07-03
 * @description
 */
public class InterruptTest {

    private ExecutorService executor = new ThreadPoolExecutor(
            10,
            10,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());


    public void timeRun(Runnable r, long timeout, TimeUnit unit) {
        Future<?> task = executor.submit(r);
        try {
            task.get(timeout, unit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            // 对于不再需要结果的任务要及时取消
            task.cancel(true);
        }
    }

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleep被打断！");
                /*
                正常执行的线程，不会去检查中断标识位，
                 */
                Thread.currentThread().interrupt();
            }
            /*
            sleep()在响应中断的时候的操作包括：清除中断状态，抛出interruptException异常，因此线程会接着执行下面的语句
             */
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("线程标识位已经被置为true！");
            }
            System.out.println("打断后的操作！");
        };
        Thread thread = new Thread(task);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断位置为true
        thread.interrupt();
    }
}
