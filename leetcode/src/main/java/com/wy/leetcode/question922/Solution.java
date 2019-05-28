package com.wy.leetcode.question922;

/**
 * @author wy
 * @date 2019-05-28
 * @description 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class Solution {
    /**
     * 注意指针的范围
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        //偶数索引
        int idxEven = 0;
        //奇数索引
        int idxOdd = 1;
        while (idxEven < len && idxOdd < len) {
            while (idxEven < len && A[idxEven] % 2 == 0) {
                idxEven = idxEven + 2;
            }
            while (idxOdd < len && A[idxOdd] % 2 == 1) {
                idxOdd = idxOdd + 2;
            }
            if (idxEven < len && idxOdd < len) {
                int temp = A[idxEven];
                A[idxEven] = A[idxOdd];
                A[idxOdd] = temp;
            }
        }
        return A;
    }

    public int[] sortArrayByParityII1(int[] A) {
        int odd = 0;
        int even = 0;
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 > 0) {
                result[2 * odd + 1] = A[i];
                odd++;
            } else {
                result[2 * even] = A[i];
                even++;
            }
        }
        return result;
    }
}
