package com.wy.grammar;

/**
 * @author wy
 * @date 2020/5/19
 * @description
 */
public interface DemoInterface1 {
    void print();

    default void play() {
        System.out.println("play1");
    }
}
