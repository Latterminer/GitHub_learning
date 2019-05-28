package com.wy.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author: wy
 * @CreateDate: 2018/11/11 23:48
 * @Version: 1.0
 */
public class MinTwoSum {
    public void swapToMinusDiff(int[] a, int[] b) {
        int sumA = sum(a);
        int sumB = sum(b);
        if (sumA == sumB)
            return;
        if (sumA < sumB) {
            int[] temp = a;
            a = b;
            b = temp;
        }
        int curDiff = Math.abs(sumA - sumB);  // 一次交换后的差值
        int oldDiff = Math.abs(sumA - sumB);  //
        int pA = -1;
        int pB = -1;
        boolean shift = true;
        int lenA = a.length;//the length of a and b should be the same
        int lenB = b.length;
        while (shift && curDiff > 0) {
            shift = false;
            curDiff = Math.abs(sum(a) - sum(b));
            if (oldDiff == 0)
                break;
            for (int i = 0; i < lenA; i++) {
                for (int j = 0; j < lenB; j++) {
                    int temp = a[i] - b[j];
                    int newDiff = Math.abs(curDiff - 2 * temp);
                    if (newDiff < curDiff && newDiff < oldDiff) {
                        shift = true;
                        oldDiff = newDiff;
                        pA = i;
                        pB = j;
                    }
                }
            }
            if (shift) {
                int temp = a[pA];
                a[pA] = b[pB];
                b[pB] = temp;
            }
        }
        System.out.println("the min diff is " + oldDiff);
    }

    public int sum(int[] a) {
        int sum = 0;
        for (int each : a) {
            sum += each;
        }
        return sum;
    }

    public static void main(String[] args) {
        MinTwoSum minTwoSum = new MinTwoSum();

        Scanner input = new Scanner(System.in);
        int arrayALength = input.nextInt();
        int[] arrayA = new int[arrayALength];
        for (int i = 0; i < arrayALength; i++)
            arrayA[i] = input.nextInt();

        int arrayBLength = input.nextInt();
        int[] arrayB = new int[arrayBLength];
        for (int i = 0; i < arrayBLength; i++)
            arrayB[i] = input.nextInt();
        minTwoSum.swapToMinusDiff(arrayA, arrayB);
        System.out.println(Arrays.toString(arrayA));
        System.out.println(Arrays.toString(arrayB));
    }
}
