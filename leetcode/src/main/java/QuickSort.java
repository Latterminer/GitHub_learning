import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
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

            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[lo];
        array[lo] = array[i];
        array[i] = temp;

        sort(array, lo, i - 1);
        sort(array, i + 1, hi);
    }

    public static void exchange(Integer a, Integer b){
        Integer temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
//        int[] array = {12, 23, 3, 34, 4, 1, 2, 13};
//        System.out.println(Arrays.toString(array));
//        sort(array, 0, array.length - 1);
//        System.out.println(Arrays.toString(array));
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        exchange(a, b);
        System.out.println(a);
        System.out.println(b);
    }
}
