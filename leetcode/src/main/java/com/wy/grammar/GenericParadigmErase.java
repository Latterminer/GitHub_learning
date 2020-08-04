package com.wy.grammar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2020/5/19
 * @description 泛型擦除  https://www.ibm.com/developerworks/cn/java/java-language-type-erasure/index.html
 */
public class GenericParadigmErase {

    private static int num = 1;

    public int count(List<? extends Person> personList) {
        return personList.size();
    }

    public static void setNum(int num) {
        GenericParadigmErase.num = num;
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person());
        personList.add(new Person());
        GenericParadigmErase genericParadigmErase = new GenericParadigmErase();
        System.out.println(genericParadigmErase.count(personList));

        List<Man> manList = new ArrayList<>();
        manList.add(new Man());
        manList.add(new Man());
        System.out.println(genericParadigmErase.count(manList));

        List list = new ArrayList();
        List<Integer> integerList = list;
        List<String> strings = new ArrayList<>();
        List list1 = new ArrayList<Double>();

    }
}

class Person {

}

class Man extends Person {

}
