package com.wy.leetcode.question811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyong
 * @date 2019/6/4
 * @description
 */
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return result;
        }
        Map<String, Integer> dict = new HashMap<>();
        for (String ele : cpdomains) {
            String[] numName = ele.split(" ");
            int num = Integer.valueOf(numName[0]);
            String name = numName[1];

            if (!dict.containsKey(name)) {
                dict.put(name, num);
            } else {
                Integer oldValue = dict.get(name);
                Integer newValue = oldValue + num;
                dict.replace(name, newValue);
            }

            String[] domains = name.split("\\.");

            if (!dict.containsKey(domains[1]+domains[2])) {
                dict.put(domains[1]+domains[2], num);
            } else {
                Integer oldValue = dict.get(domains[1]+domains[2]);
                Integer newValue = oldValue + num;
                dict.replace(domains[1]+domains[2], newValue);
            }

            if (!dict.containsKey(domains[2])) {
                dict.put(domains[2], num);
            } else {
                Integer oldValue = dict.get(domains[2]);
                Integer newValue = oldValue + num;
                dict.replace(domains[2], newValue);
            }

        }
        dict.forEach((key, value) -> result.add(value + " " + key));
        return result;
    }
}
