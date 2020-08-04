package com.wy.leetcode.question1202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wy
 * @date 2020/5/26
 * @description
 */
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();

        DSU dsu = new DSU(100000);
        //构造下标集合
        for (List<Integer> list : pairs) {
            dsu.union(list.get(0), list.get(1));
        }
        //每个下标集合有1个leader，用leader作为key(唯一)，下标集合List作为value
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //从小到大遍历，使得List<Integer>中的值是有序的(事后不用再排序了)
        for (int i = 0; i < len; ++i) {
            int key = dsu.find(i);
            map.computeIfAbsent(key, unused -> new ArrayList<>()).add(i);
        }

        StringBuilder res = new StringBuilder(s);
        //遍历所有每个下标集合，进行字符局部排序
        for (List<Integer> idxList : map.values()) {
            if (idxList.size() > 1) {
                sort(res, idxList);
            }
        }

        return res.toString();
    }

    /**
     * 根据下标集合进行局部排序
     */
    private void sort(StringBuilder res, List<Integer> idxList) {
        int len = idxList.size();
        char[] array = new char[len];
        //根据下标集合构建字符集合
        for (int i = 0; i < len; ++i) {
            array[i] = res.charAt(idxList.get(i));
        }
        //将字符集合排序
        Arrays.sort(array);
        //将字符按序“插入”回StringBuilder
        for (int i = 0; i < len; ++i) {
            res.setCharAt(idxList.get(i), array[i]);
        }
    }
    static class DSU {
        int[] parent;

        public DSU(int len) {
            parent = new int[len];
            for (int i = 0; i < len; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            return parent[x] != x ? parent[x] = find(parent[x]) : x;
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> pair1 = new ArrayList<>();
        pair1.add(0);
        pair1.add(3);
        pairs.add(pair1);
        List<Integer> pair2 = new ArrayList<>();
        pair2.add(1);
        pair2.add(2);
        pairs.add(pair2);
        final String s1 = solution.smallestStringWithSwaps(s, pairs);
        System.out.println(s1);
    }
}



