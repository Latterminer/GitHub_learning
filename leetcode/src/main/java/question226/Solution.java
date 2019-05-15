package question226;

import java.util.Stack;

/**
 * @author wangyong
 * @date 2019/5/15
 * @description
 */
public class Solution {
    /**
     * 使用递归
     * @param root 根节点
     * @return  根节点
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    /**
     * 使用栈
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            TreeNode treeNode = temp.left;
            temp.left = temp.right;
            temp.right = treeNode;
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return root;
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
