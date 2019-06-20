package com.wy.leetcode.question215;

import java.util.PriorityQueue;

/**
 * @author wangyong
 * @date 2019/6/19
 * @description 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * <p>
 * 实现方法： 1、直接排序，然后取出第K个数
 * 2、利用优先队列维护一个小根堆
 * 3、利用快排的思想
 */
public class Solution {
    /**
     * 通过维护一个小根堆来实现，利用优先队列来实现小根堆
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    /**
     * 利用快排
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = partition(nums, low, high);
            if (mid == k - 1) {
                return nums[mid];
            } else if (mid > k - 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int low, int high) {
        int left = low + 1, right = high;
        swap(nums, low, (low + high) / 2);
        int pivot = nums[low];
        while (left <= right) {
            while (left < high && nums[left] >= pivot) left++;
            while (nums[right] < pivot) right--;
            if (left < right) {
                swap(nums, left++, right--);
            } else {
                break;
            }
        }
        swap(nums, low, right);
        return right;
    }

    private void swap(int[] nums, int low, int i) {
        int x = nums[low];
        nums[low] = nums[i];
        nums[i] = x;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
    }
}
