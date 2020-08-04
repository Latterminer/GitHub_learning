package com.wy.jvm.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2020/5/6
 * @description
 */
public class DumpTest {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        try {
            int i = 0;
            while (true) {
                stringList.add(String.valueOf(i++));
            }
        } catch (OutOfMemoryError error) {
            System.out.println("捉到没");
        }
    }
}
