package question852;

/**
 * @author wangyong
 * @date 2019/5/17
 * @description
 * 我们把符合下列属性的数组 A 称作山脉：
 * <p>
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,0]
 * 输出：1
 */
public class Solution {
    /**
     * 二分查找
     *
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0;
        int hi = A.length - 1;
        while (hi > lo) {
            int mid = (hi + lo) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] < A[mid + 1]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
        /**
         int i = 0;
         for (; i < A.length-1; i++) {
         if (A[i] > A[i + 1]) {
         return i;
         }
         }
         return i;
         */
    }
}
