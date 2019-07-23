package com.wy.jvm.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2019-07-21
 * @description
 */
public class HashMapIteratorTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(16);
        map.put("a", "1");
        map.forEach((k, v) -> System.out.println(v));
    }
}
