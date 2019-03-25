package interview;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: 求数组中每个元素的右边比它大的元素
 * @Author: wy
 * @CreateDate: 2019/1/26 13:03
 * @Version: 1.0
 */

public class ArrayProblem {
    public static void solution(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];
        stack.push(0);
        for (int i = 1; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                result[stack.pop()] = array[i];
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] array = {5, 9, 3, 0, 4, 5, 6, 9};
        solution(array);
    }
}
