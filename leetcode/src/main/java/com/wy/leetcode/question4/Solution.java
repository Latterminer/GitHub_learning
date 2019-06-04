package com.wy.leetcode.question4;

/**
 * @author wy
 * @date 2019-06-01
 * @description
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        len1 = nums1.length;
        len2 = nums2.length;
        int half = (len1 + len2 + 1) / 2;
        int lo = 0;
        int hi = len1;

        while (hi >= lo) {
            int mid = (hi + lo) / 2;
            int index = half - mid;
            if (mid > lo && nums1[mid - 1] > nums2[index]) {
                //mid 太大
                hi = mid - 1;
            } else if (mid < hi && nums1[mid] < nums2[index - 1]) {
                //mid 太小
                lo = mid + 1;
            } else {
                int maxLeft = 0;
                if (mid == 0) {
                    maxLeft = nums2[index - 1];
                } else if (index == 0) {
                    maxLeft = nums1[mid - 1];
                } else {
                    maxLeft = Math.max(nums1[mid - 1], nums2[index - 1]);
                }
                if ((len1 + len2) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (mid == len1) {
                    minRight = nums2[index];
                } else if (index == len2) {
                    minRight = nums1[mid];
                } else {
                    minRight = Math.min(nums2[index], nums1[mid]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
