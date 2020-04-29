package com.wy.leetcode.temp;

/**
 * @author wy
 * @date 2020/4/19
 * @description
 */
class Solution {
//    public static boolean canJump(int[] nums) {
//        Boolean ans = false;
//        getAns(nums,ans,nums.length-1);
//
//        return ans;
//    }
//
//    public static void getAns(int[] nums, Boolean ans, int des){
//        if(des == 0){
//            if(nums[des] > 0)ans = true;
//            return;
//        }
//        for(int i=des-1; i>=0; i--){
//            if(nums[i] >= (des-i)){
//                getAns(nums,ans,i);
//            }
//            if(ans)break;
//        }
//    }

    static class NestClass {
        private boolean b = false;

        public void setB(boolean b) {
            this.b = b;
        }
    }

    public static void changeBool(NestClass b) {
        b.setB(true);
    }

    public static void main(String[] args) {
        NestClass nestClass = new NestClass();
        changeBool(nestClass);
        System.out.println(nestClass);
    }
}
