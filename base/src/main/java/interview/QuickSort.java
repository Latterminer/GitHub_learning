package interview;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int i = lo;
        int j = hi;
        int key = array[lo];
        while (i < j) {
            while (i < j && array[j] > key) {
                j--;
            }
            while (i < j && array[i] <= key) {
                i++;
            }
            swap(array, i, j);
        }
        swap(array, lo, i);
        quickSort(array, lo, i - 1);
        quickSort(array, i + 1, hi);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 7, 4, 5, 3, 9, 0};
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length -1);
        System.out.println(Arrays.toString(a));

    }
}
