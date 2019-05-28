package com.wy.interview;

public class MonotonicSequence {
    public static int getMaxArray(int[] array) {
        int max_length = 1;
        int flag = 1;
        int start = 0;
        int end = 0;
        int currentStart = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                flag++;
                if (flag > max_length) {
                    max_length = flag;
                    start = currentStart;
                    end = i + 1;
                }
            } else {
                flag = 1;
                currentStart = i + 1;
            }
        }
        output(array, start, end);
        System.out.println();
        return max_length;
    }

    public static void output(int[] array, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(array[i]);
            System.out.print(',');
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 3, 5, 6, 1};
        int result = getMaxArray(array);
        System.out.println(result);
    }
}
