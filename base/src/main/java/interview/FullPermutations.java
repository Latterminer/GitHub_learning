package interview;

import java.util.Arrays;

public class FullPermutations {
    /**
     * 字符串全排列
     * @param str
     * @param index
     */
    public static void getStringFull(StringBuffer str, int index){
        if (index == str.length()){
            System.out.println(str.toString());
        }else {
            for (int i = index; i < str.length(); i++){
                char temp = str.charAt(index);
                str.setCharAt(index, str.charAt(i));
                str.setCharAt(i, temp);

                getStringFull(str, index +1);

                temp = str.charAt(index);
                str.setCharAt(index, str.charAt(i));
                str.setCharAt(i, temp);
            }
        }
    }

    /**
     * 数字全排列
     * @param array
     * @param index
     */
    public static void getFullPermutations(int[] array, int index) {
        if (index == array.length) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = index; i < array.length; i++) {
                swap(array, i, index);
                getFullPermutations(array, index + 1);
                swap(array, i, index);
            }
        }
    }

    public static void swap(int[] array, int index_1, int index_2) {
        int temp = array[index_1];
        array[index_1] = array[index_2];
        array[index_2] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
//        int[] array = {1};
        getFullPermutations(array, 0);
    }
}