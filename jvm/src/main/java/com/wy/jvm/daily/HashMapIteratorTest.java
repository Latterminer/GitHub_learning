package com.wy.jvm.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wy
 * @date 2019-07-21
 * @description
 */
public class HashMapIteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        final List<String> collect = list.stream().limit(3).collect(Collectors.toList());
        System.out.println(collect.toString());
    }
}
