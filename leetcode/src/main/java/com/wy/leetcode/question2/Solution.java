package com.wy.leetcode.question2;

/**
 * @author wy
 * @date 2019-06-19
 * @description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int currBit = (l1.val + l2.val) % 10;
        int carryBit = (l1.val + l2.val) / 10;
        ListNode root = new ListNode(currBit);
        ListNode currNode = root;
        ListNode point1 = l1.next;
        ListNode point2 = l2.next;
        while (point1 != null && point2 != null) {
            currBit = (point1.val + point2.val + carryBit) % 10;
            carryBit = (point1.val + point2.val + carryBit) / 10;
            currNode.next = new ListNode(currBit);
            point1 = point1.next;
            point2 = point2.next;
            currNode = currNode.next;
        }
        /*
        当两个链表的长度不一样时
         */
        ListNode temp;
        if (point1 != null) {
            temp = point1;
        } else {
            temp = point2;
        }
        while (temp != null) {
            currBit = (temp.val + carryBit) % 10;
            carryBit = (temp.val + carryBit) / 10;
            currNode.next = new ListNode(currBit);
            temp = temp.next;
            currNode = currNode.next;
        }

        if (carryBit != 0) {
            currNode.next = new ListNode(carryBit);
        }
        return root;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode curr = l3;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = x + y + carry;
            int num = sum % 10;
            if(sum > num) {
                carry = 1;
            }else{
                carry = 0;
            }
            curr.next = new ListNode(num);
            curr = curr.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry > 0) {
            curr.next = new ListNode(1);
        }
        return l3.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}