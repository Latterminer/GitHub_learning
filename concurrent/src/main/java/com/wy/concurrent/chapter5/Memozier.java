package com.wy.concurrent.chapter5;

import java.util.concurrent.*;

/**
 * @author wy
 * @date 2019-06-13
 * @description 通过concurrentHashMap实现的缓存
 */
public class Memozier<I, O> implements Computable<I, O> {
    /**
     * 结果缓存
     */
    private final ConcurrentHashMap<I, Future<O>> resultCache = new ConcurrentHashMap<>();

    private final Computable<I, O> computable;

    public Memozier(Computable<I, O> computable) {
        this.computable = computable;
    }

    @Override
    public O compute(I input) {
        while (true) {
            Future<O> f = resultCache.get(input);
            if (f == null) {
                FutureTask<O> task = new FutureTask<>(() -> computable.compute(input));
                /*
                putIfAbsent是一个原子操作，防止任务的重复添加
                 */
                f = resultCache.putIfAbsent(input, task);
                if (f == null) {
                    f = task;
                    task.run();
                }
            }
            try {
                //会阻塞，直到获取到结果
                return f.get();
            } catch (InterruptedException e) {
                //发生异常，需要把缓存中对应的任务清理，否则会造成缓存污染
                resultCache.remove(input);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
