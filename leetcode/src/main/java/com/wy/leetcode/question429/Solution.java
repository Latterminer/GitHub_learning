package com.wy.leetcode.question429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangyong
 * @date 2019/6/8
 * @description 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Node head = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> nextLayer = new ArrayList<>();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                nextLayer.addAll(node.children);
                layer.add(node.val);
            }
            result.add(layer);
            queue.addAll(nextLayer);

        }
        return result;
    }

    /**
     * 别人的方法，时间效率更高
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    public void dfs(Node root, int depth, List<List<Integer>> result){
        if(root != null){
            if(result.size() < depth + 1)
                result.add(depth, new ArrayList<Integer>());
            result.get(depth).add(root.val);
            depth++;
            for(Node child: root.children)
                dfs(child, depth, result);
        }
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
};