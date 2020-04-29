package com.wy.leetcode.question19;

import java.util.List;

/**
 * @author wy
 * @date 2020/4/23
 * @description 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 注意这个哑结点的作用，当长度为1，n=1时可以避免空指针
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 这个解法有错误
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, Integer n) {
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return head;
    }
}
