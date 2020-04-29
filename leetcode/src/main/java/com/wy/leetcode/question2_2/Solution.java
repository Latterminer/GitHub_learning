package com.wy.leetcode.question2_2;

/**
 * @author wy
 * @date 2020/3/24
 * @description
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;
        int carryBit = 0;
        while (l1 != null || l2 != null || carryBit !=0) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            // 当前位
            currentNode.next = new ListNode((num1 + num2 + carryBit) % 10);
            carryBit = (num1 + num2 + carryBit) / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        return dummyHead.next;

    }
}
