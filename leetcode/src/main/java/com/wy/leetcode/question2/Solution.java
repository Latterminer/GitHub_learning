package com.wy.leetcode.question2;

/**
 * @author wy
 * @date 2019-06-19
 * @description
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int currBit =  (l1.val + l2.val) % 10;
        int carryBit = (l1.val + l2.val) / 10;
        ListNode root = new ListNode(currBit);
        ListNode currNode = root;
        ListNode point1 = l1;
        ListNode point2 = l2;
        while (point1 != null && point2 != null) {
            currBit = (point1.val + point2.val) % 10;
            carryBit = (point1.val + point2.val + carryBit) / 10;
            currNode.next = new ListNode(currBit);
            point1 = point1.next;
            point2 = point2.next;
            currNode = currNode.next;
        }
        while (point1 != null) {
            currNode.next = point1;
            point1 = point1.next;
            currNode = currNode.next;
        }
        while (point2 != null) {
            currNode.next = point2;
            point2 = point2.next;
        }
        return root;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}