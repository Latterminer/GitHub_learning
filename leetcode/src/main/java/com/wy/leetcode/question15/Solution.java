package com.wy.leetcode.question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wy
 * @date 2019-06-10
 * @description
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Solution {
    /**
     * 1、可以通过O（n3）来实现，三次循环遍历
     * 2、通过排序与双指针的方式来查找，但是需要注意的是去重
     * @param nums 数组
     * @return 符合条件的组合
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        //如果排序后的第一个元素和最后一个元素符号相同则肯定不存在
        if (len > 0 && nums[0] <= 0 && nums[len - 1] >= 0) {
            for (int i = 0; i < len; i++) {
                //如果左边的元素大于0，则后面的元素肯定不存在符合条件的
                int left = i;
                if (nums[left] > 0) {
                    break;
                }
                //选择元素去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                /*
                先确定左元素，然后找第二个元素和第三个元素，利用双指针
                 */
                int mid = i + 1;
                int right = len - 1;
                while (right > mid) {
                    if (nums[left] + nums[mid] + nums[right] == 0) {
                        result.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                        //当找到后要把指针移动到下一个元素，同时要考虑去重
                        while (right > mid && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                        while (mid < right && nums[mid] == nums[mid + 1]) {
                            mid++;
                        }
                        mid++;
                    } else if (nums[left] + nums[mid] + nums[right] > 0) {
                        //右指针去重
                        while (right > mid && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else {
                        //左指针去重
                        while (mid < right && nums[mid] == nums[mid + 1]) {
                            mid++;
                        }
                        mid++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(array));
    }
}
