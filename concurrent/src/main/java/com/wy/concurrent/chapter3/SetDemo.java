package com.wy.concurrent.chapter3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2019-05-30
 * @description
 */
public class SetDemo {
    public static void main(String[] args) {
        /*
        用来创建一个线程安全的set，用的是装饰器模式，HashSet外面包了线程安全层
         */
        Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet<String>());
    }
}
