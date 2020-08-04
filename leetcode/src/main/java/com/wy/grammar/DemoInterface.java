package com.wy.grammar;

/**
 * @author wy
 * @date 2020/5/18
 * @description
 */
public interface DemoInterface {
    @Override
    String toString();

    default void play() {
        System.out.println("play");
    }

}
