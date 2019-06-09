package com.wy.concurrent.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wangyong
 * @date 2019/6/9
 * @description
 */
public class PreLoader {
    private final FutureTask<Integer> future = new FutureTask<Integer>(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            return Integer.valueOf("123");
        }
    });

    private final Thread thread = new Thread(future);
    public void start() {
        thread.start();
    }
    public Integer get() throws InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
        }
        return 0;
    }
}
