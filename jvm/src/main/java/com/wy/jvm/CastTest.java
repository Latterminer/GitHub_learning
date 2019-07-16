package com.wy.jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wy
 * @date 2019-07-14
 * @description
 */
public class CastTest {
    public static void main(String[] args) {
//        List<String> stringList = new ArrayList<String>();
//        stringList.add("wang");
//        stringList.add("yong");
//        //注意toArray()的参数一定是一个元素为0的数组
//        String[] strings = stringList.toArray(new String[0]);

        String[] str = new String[] { "yang", "hao" };
        List list = Arrays.asList(str);
        System.out.println(list);
        str[0] = "changed";
        System.out.println(list);
//        使用Arrays.asList的时候不能对list结果进行修改
//        list.add("fad");
    }
}
