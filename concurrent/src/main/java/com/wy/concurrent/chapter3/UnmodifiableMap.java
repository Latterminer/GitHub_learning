package com.wy.concurrent.chapter3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2019-05-30
 * @description
 */
public class UnmodifiableMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("adb", "123");
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);
        System.out.println(unmodifiableMap);
        map.put("asd", "456");
        System.out.println(unmodifiableMap);
    }
}
