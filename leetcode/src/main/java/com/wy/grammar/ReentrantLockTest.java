package com.wy.grammar;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wy
 * @date 2020/5/2
 * @description
 */
public class ReentrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        final int queueLength = lock.getQueueLength();
        final Condition condition = lock.newCondition();
        lock.lock();
//        condition.await();

    }
}
