package com.wy.grammar;

import java.util.Comparator;
import java.util.TreeSet;

public class TreesetDemo {
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 6, 2, 3, 2, 9};
        TreeSet<Integer> treeset = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i< array.length; i++){
            treeset.add(array[i]);
        }
        treeset.forEach(System.out::println);
    }
}
