package com.wy.leetcode.question94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangyong
 * @date 2019/5/6
 * @description
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Solution94 {
    /**
     * 如果root不为空，我们一直压入root，并且更新root=root.left，这样left会一直压栈操作。
     * 当我们发现left为空的时候，我们就要将结果压入result，接着访问right，然后回到第一步
     * 直到len(stack)==0，我们就结束了。
     * @param root root
     * @return result
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode temp = root;
        treeNodeStack.push(temp);
        while (!treeNodeStack.isEmpty() || temp !=null) {
            if (temp != null) {
                treeNodeStack.push(temp);
                temp = temp.left;
            } else {
                TreeNode top = treeNodeStack.pop();
                result.add(top.val);
                temp = temp.right;
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}