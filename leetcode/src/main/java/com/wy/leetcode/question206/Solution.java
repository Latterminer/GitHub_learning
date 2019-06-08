package com.wy.leetcode.question206;

import java.util.List;

/**
 * @author wangyong
 * @date 2019/6/7
 * @description 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 迭代法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //保存上个变量，在链表head时pre应该为null
        ListNode pre = null;
        //保存当前节点的next，因为在把当前节点指向他的上一个节点时，需要保存下一个节点，否则会丢失链表信息
        ListNode next;
        while (head != null) {
            //保存当前节点的next
            next = head.next;
            //把当前节点的next指向上一个节点
            head.next = pre;
            //保存当前节点，作为下一个节点的上一节点
            pre = head;
            //移动到下一个节点
            head = next;
        }
        return pre;
    }

    /**
     * 递归法 https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}