package question144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangyong
 * @date 2019/5/9
 * @description
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Solution {
    /**
     * 1、首先将访问node1的right、访问node1的left和打印node.val压入栈中。
     * 2、然后弹出cout，我们就打印了node1.val。接着访问node1的left，我们发现node1的left是空，那么什么也不做。我们接着访问node1的right，同样的对于node1.right，我们要推入这样的三个指令go-2-R、go-2-L和cout，就变成了下面这个样子。
     * @param root 根节点
     * @return 前序遍历结果
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(temp);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
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
