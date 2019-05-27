package question908;

/**
 * @author wangyong
 * @date 2019/5/26
 * @description
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 */
public class Solution {
    /**
     * 当数组的差值小于等于2K时，对A[i]进行操作后的差值为0，
     * 如果数组的差值大于2k，对A[i]进行操作后的差值为原差值减去2k
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeI(int[] A, int K) {
        int min = A[0];
        int max = A[0];
        for (int value : A) {
            if (value <= min) {
                min = value;
            }
            if (value >= max) {
                max = value;
            }
        }
        int diff = max - min;
        K <<= 1;
        if (diff <= K) {
            return 0;
        } else {
            return diff - K;
        }
    }
}
