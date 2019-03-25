package jianzhi_offer;

import java.util.ArrayList;

public class DuplicateNum {
    public static ArrayList<Integer> duplicateNum(int[] array, int length){
        if (array == null || length == 0){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < length;  i++){
            while (array[i] != i){
                if (array[i] == array[array[i]]){
                    result.add(new Integer(array[i]));
                    break;
                }
                int temp = array[i];
                array[i] = array[temp];
                array[temp] = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,0,2,5,3};
        ArrayList result = DuplicateNum.duplicateNum(array, 7);
        System.out.println(result.toString());
    }
}
