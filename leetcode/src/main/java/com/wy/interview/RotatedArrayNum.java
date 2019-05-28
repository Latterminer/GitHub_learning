package com.wy.interview;

/**
 * @Description: 查找旋转数组中的目标数，要求时间复杂度小于n
 * @Author: wy
 * @CreateDate: 2019/1/16 19:03
 * @Version: 1.0
 */
public class RotatedArrayNum {
    public static int find(int[] array, int target) {
        int left = 0;
        int right = array.length;
        while (right > left) {
            int mid = (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > array[left]) {   // 左边有序
                if (target > array[mid]) {
                    left = mid + 1;
                } else {
                    if (target > array[left]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
            } else {                          // 右边有序
                if (target > array[left]) {
                    right = mid - 1;
                } else {
                    if (target > array[mid]) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = {3,4,5,6,7,0,1,2};
        System.out.println(find(array, 5));
    }
}
