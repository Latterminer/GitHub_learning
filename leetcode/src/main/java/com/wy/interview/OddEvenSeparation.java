package com.wy.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OddEvenSeparation {
    public static ArrayList<Integer> resort(ArrayList<Integer> array) {
        ArrayList<Integer> result = new ArrayList<Integer>(10);
        int i = 0;
        int j = array.size() - 1;
        for (int num : array) {
            if (num % 2 != 0) {
                result.set(i++, num);
            }
        }
        Collections.reverse(array);
        for (int num : array) {
            if (num % 2 == 0) {
                result.set(j--, num);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ArrayList result = OddEvenSeparation.resort(array);
        System.out.println(result);

    }
}
