package com.wy.leetcode.question283;

import java.util.Arrays;

/**
 * @author wangyong
 * @date 2019/6/19
 * @description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Solution {
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        while (j < len) {
            while (i < len && nums[i] != 0) {
                i++;
            }
            j = i;
            while (j < len && nums[j] == 0) {
                j++;
            }
            //j指向不后面第一个不为0的数
            if (j < len && i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    /**
     * 别人的解法
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        // 我的思路是碰到0，就把i+1赋值到i，记录0的数量
        // 最后把所有末尾的值全部赋值0

        // 边界条件
        if(nums.length < 1) {
            return;
        }

        // 初始化
        int slow = 0;

        // 根据是否为0进行赋值
        for(int i = 0 ; i<nums.length; i++){
            if(nums[i] != 0){
                nums[slow++] = nums[i];
            }
        }

        while(slow < nums.length){
            nums[slow++]=0;
        }

    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 0, 3, 12};
//        int[] nums = new int[]{1, 0};
        int[] nums = new int[]{1, 0, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
