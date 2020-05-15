package com.wy.leetcode.question55;

/**
 * @author wy
 * @date 2020/5/13
 * @description
 */
public class Solution {
    /**
     * 贪心算法
     * 思路整理：
     * 每一步所能到达的最远位置为：当前位置+当前的最大跳跃值，i+nums[i]
     * 如果i的值已经超过了所能到达的最大位置，说明这个节点是到达不了的，直接返回false
     */
    public boolean canJump(int[] nums) {
        // 记录当前可以到达的最远位置
        int reach = 0;
        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            if (i > reach) {
//                return false;
//            }
//            reach = Math.max(i + nums[i], reach);
//        }
//        return true;
//        简化循环
        for (int i = 0; i <= reach && reach < len-1; i++) {
            reach = Math.max(i + nums[i], reach);
        }
        return reach >= len - 1;
    }

    class Solution1 {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            if(len == 1){
                return nums[0];
            }
            int max = nums[0];
            int st=0,l=0,r=0;
            while(st<len){
                int i=st,count=0;
                for(;i<len;i++){
                    if(nums[i] == 0){
                        if(max < 0){
                            max = 0;
                        }
                        break;
                    }
                    if(nums[i] < 0){
                        if(count == 0){
                            l=i;
                            r=i;
                        }else{
                            r=i;
                        }
                        count++;
                    }
                }
                if(count%2 != 0){
                    int sum = nums[st];
                    for(int j=st+1;j<r;j++){
                        sum = sum * nums[j];
                    }
                    if(sum > max)max = sum;
                    if(l+1<len){
                        sum = nums[l+1];
                        for(int j=l+2;j<i;j++){
                            sum = sum * nums[j];
                        }
                        if(sum > max)max = sum;
                    }
                }else{
                    int sum = nums[st];
                    for(int j=st+1;j<i;j++){
                        sum = sum * nums[j];
                    }
                    if(sum > max)max = sum;
                }
                st = i + 1;
            }

            return max;
        }
    }
}
