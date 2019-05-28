package com.wy.leetcode.question590;

import java.util.*;

/**
 * @author wangyong
 * @date 2019/5/17
 * @description 给定一个 N 叉树，返回其节点值的后序遍历。
 * 例如，给定一个 3叉树 :
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Solution {
    /**
     * 非递归做法，思路总结：后序遍历的顺序为：左，右，根；反过来的顺序为：根，右，左；
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                node.children.stream().filter(it -> !Objects.isNull(it)).forEach(stack::push);
            }
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 递归做法
     *
     * @param root
     * @return
     */
    public List<Integer> postOrder1(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.children != null && root.children.size() > 0) {
            for (Node node : root.children) {
                result.addAll(postOrder1(node));
            }
        }
        result.add(root.val);
        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}