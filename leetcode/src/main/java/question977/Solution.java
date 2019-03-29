package question977;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * @author wangyong
 * @date 2019/3/30
 * @description
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        int length = A.length;
        //保存结果
        int[] result = new int[length];
        int i = 0;
        int j = length - 1;
        //结果从尾部开始赋值
        int k = length - 1;
        while (j >= i) {
            if (Math.abs(A[j]) > Math.abs(A[i])) {
                result[k--] = A[j] * A[j];
                j--;
            } else {
                result[k--] = A[i] * A[i];
                i++;
            }
        }
        return result;
    }
}
