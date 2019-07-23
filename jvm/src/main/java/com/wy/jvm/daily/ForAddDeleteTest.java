package com.wy.jvm.daily;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wy
 * @date 2019-07-21
 * @description
 */
public class ForAddDeleteTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }
        //不能使用for循环在遍历过程中删除或添加元素
//        for (String item : list) {
//            if ("2".equals(item)) {
//                list.remove(item);
//            }
//        }
        System.out.println(list);
    }
}

