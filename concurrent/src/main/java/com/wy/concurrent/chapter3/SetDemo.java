package com.wy.concurrent.chapter3;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
//        String[] temp = new String[3];
//        temp[1] = "adb";
//        System.out.println(String.join(".", temp));

//        LocalDate start = LocalDate.parse("2019-01-20");
//        LocalDate end = LocalDate.parse("2019-01-20");
//        System.out.println(start.format(DateTimeFormatter.ofPattern("yyyy")));
//        System.out.println(start.until(end, ChronoUnit.DAYS));

//        LocalDateTime start = LocalDateTime.parse("2019-01-01 10:20:20", DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
//        LocalDateTime end = LocalDateTime.parse("2019-01-20 10:20:20", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(end.until(start, ChronoUnit.MINUTES));

        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(1);

        HashSet<HashSet<Integer>> result = new HashSet<>();
        result.add(set1);
        result.add(set2);

        System.out.println(result);

        List<Integer> list = new ArrayList<>();



    }


}
