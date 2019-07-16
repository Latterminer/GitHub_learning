package com.wy.concurrent.chapter4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wy
 * @date 2019-06-24
 * @description
 */
public class Test {
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.tryLock();
        lock.lock();
    }
}
