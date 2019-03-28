package question220;

import java.util.TreeSet;

/**
 * @author wangyong
 * @description 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，
 * 并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * <p>
 * [-1,2147483647]
 * 1
 * 2147483647
 * @date 2019-03-21
 */
public class Solution {
    /**
     * 超出时限的方法
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((long) nums[j] - (long) nums[i]) <= t && Math.abs(j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate0(int[] nums, int k, int t) {
        // 对输入进行检验
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        //
        TreeSet<Long> treeSet = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {

            // 找出集合比当前元素+t之后小的最大值（可以等于）
            final Long floor = treeSet.floor((long) nums[i] + t);
            // 找出集合比当前元素-t之后大的最小值（可以等于）
            final Long ceil = treeSet.ceiling((long) nums[i] - t);

            if ((floor != null && floor >= (long) nums[i]) ||
                    (ceil != null && ceil <= (long) nums[i])) {
                return true;
            }

            treeSet.add((long) nums[i]);
            //因为元素的坐标差不能超过k，所以在treeSet中最多只能有k个元素
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 时间最优
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if(k <= 0) {
            return false;
        }
        int i = 0;
        int j = 1;
        int len = nums.length;
        while(i < len-1){
            if(i != j && Math.abs((long)nums[j] - nums[i]) <= t) {
                return true;
            }
            if(i + k ==j || j == len-1){
                i++;
                if(t!=0) {
                    j = i+1;
                }
            }else{
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2147483647};

        System.out.println(containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }
}
