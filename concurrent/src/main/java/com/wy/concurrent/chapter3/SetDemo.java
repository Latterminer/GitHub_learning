package com.wy.concurrent.chapter3;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wy
 * @date 2019-05-30
 * @description
 */
public class SetDemo {
    public static void main(String[] args) {
//        /*
//        用来创建一个线程安全的set，用的是装饰器模式，HashSet外面包了线程安全层
//         */
//        Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet<String>());
//        SafePoint p = new SafePoint(5, 6);
//        ArrayList<Integer> nums = new ArrayList<Integer>();
//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        System.out.println(nums instanceof List);
//        System.out.println(nums.getClass().isInstance(nums));
//        List<Integer> list = Collections.synchronizedList(nums);
//        SimpleDateFormat dateFormat = new SimpleDateFormat();
//
//        Vector<Integer> nums1 = new Vector<Integer>();
//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(10);
//        map.putIfAbsent("123", 123);
//        Deque<String> deque = new LinkedList<>();
//        deque.add("adb");
        String[] temp = new String[3];
        temp[1] = "adb";
        System.out.println(String.join(".", temp));
    }
}
