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

            String[] domains = name.split("\\.");
            int len = domains.length;
            String domain = "";
            for (int i = len - 1; i >= 0; i--) {
                if (i == len - 1) {
                    domain = domains[i];
                } else {
                    domain = domains[i] + "." + domain;
                }

                if (!dict.containsKey(domain)) {
                    dict.put(domain, num);
                } else {
                    Integer oldValue = dict.get(domain);
                    Integer newValue = oldValue + num;
                    dict.replace(domain, newValue);
                }
            }

        }
        dict.forEach((key, value) -> result.add(value + " " + key));
        return result;
    }

    public List<String> subdomainVisits1(String[] cpdomains) {
        HashMap<String, Integer> visitCountMap = new HashMap<>();
        for (String s : cpdomains) {
            String[] splited = s.split(" ");
            int count = Integer.valueOf(splited[0]);
            String domain = splited[1];
            while (true) {
                visitCountMap.put(domain, visitCountMap.getOrDefault(domain, 0) + count);

                int commaPos = domain.indexOf(".");
                if (commaPos != -1) {
                    domain = domain.substring(commaPos + 1);
                } else {
                    break;
                }
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (String key : visitCountMap.keySet()) {
            result.add(visitCountMap.get(key) + " " + key);
        }
        return result;
    }
}
