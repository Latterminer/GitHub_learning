package com.wy.leetcode.question237;

/**
 * @author wangyong
 * @date 2019/3/30
 * @description
 */
public class ListNode<T> {
    /**
     * next point
     */
    private ListNode next;
    /**
     * value
     */
    private T value;

    public ListNode(T value) {
        this.value = value;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }
}
