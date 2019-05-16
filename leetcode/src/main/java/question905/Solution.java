package question905;

import java.util.Arrays;

/**
 * @author wangyong
 * @date 2019/5/16
 * @description
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
public class Solution {
    public static int[] sortArrayByParity(int[] A) {
        int lo = 0;
        int hi = A.length-1;
        while (hi > lo) {
            while (hi > lo && A[lo] % 2 == 0) {
                lo++;
            }
            while (hi > lo && A[hi] % 2 != 0) {
                hi--;
            }
            int temp= A[lo];
            A[lo] = A[hi];
            A[hi] = temp;
            /*
            加上下面两句话可以节省1ms，每一次交换都减少了一次比较
             */
            lo++;
            hi--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(A)));
    }
}
