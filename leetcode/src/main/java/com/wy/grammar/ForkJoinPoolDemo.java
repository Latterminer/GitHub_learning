package com.wy.grammar;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ForkJoinPoolDemo extends RecursiveTask {
    @Override
    protected Object compute() {
        return null;
    }

    public static void main(String[] args) {
        Lock lock = (Lock) new ReentrantReadWriteLock();
    }
}
