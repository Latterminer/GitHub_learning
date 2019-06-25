package com.wy.grammar;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("a");

        Vector<String> vector = new Vector<String>();
        vector.add("b");
        System.out.println(vector.indexOf(0));

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("c");
        System.out.println(arrayList.indexOf(0));

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("d");
        System.out.println(linkedList.contains("d"));

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("K1", "V1");
        map.put("K2", "V2");
        map.put("K3", "V3");

        map.remove("K1");
        System.out.println(map.toString());

    }
}
