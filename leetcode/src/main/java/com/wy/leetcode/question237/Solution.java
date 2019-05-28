package com.wy.leetcode.question237;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * @author wangyong
 * @date 2019/3/30
 * @description
 */
public class Solution {
    public void deleteNode(ListNode<Integer> node) {
        //判断边界条件
        if (node == null) {
            return;
        }
        //只需要把被删除的元素的下一个元素的值，赋到被删除的元素，然后把被删除元素的next指针，指到node.next.next
        ListNode<Integer> next = node.getNext();
        node.setNext(next.getNext());
        node.setValue(next.getValue());
    }
}
