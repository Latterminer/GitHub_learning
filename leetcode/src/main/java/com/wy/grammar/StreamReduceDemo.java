package com.wy.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * @author wy
 * @date 2020/4/9
 * @description
 */
public class StreamReduceDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int a = 2;
        int b = 3;
        a++;
        list.add(1);
        list.add(2);
        list.add(3);
        final Optional<Integer> reduce = list.stream().reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });
    }
}
