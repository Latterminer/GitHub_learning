package question965;

import java.util.Stack;

/**
 * @author wangyong
 * @date 2019/5/26
 * @description
 */
public class Solution {
    /**
     * 自己的解法
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        int value = root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.val == value) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 别人的解法
     * @param root
     * @return
     */
    public boolean isUnivalTree1(TreeNode root) {
        int x=root.val;
        return help(x,root);
    }
    public boolean help(int x,TreeNode root)
    {
        if(root==null)
            return true;

        return help(x,root.right)&&root.val==x&&help(x,root.left);

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