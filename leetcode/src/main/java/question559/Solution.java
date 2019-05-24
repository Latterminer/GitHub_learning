package question559;

import java.util.*;

/**
 * @author wangyong
 * @date 2019/5/25
 * @description 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class Solution {
    /**
     * 自己的解法，有点慢
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children != null) {
            Set<Integer> childDeepths = new LinkedHashSet<>();
            for (Node node : root.children) {
                childDeepths.add(maxDepth(node));
            }
            int maxChild = childDeepths.isEmpty()?0: Collections.max(childDeepths);
            return 1 + maxChild;
        } else {
            return 1;
        }
    }

    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        int result = 1;
        if (!root.children.isEmpty()) {
            for (Node node : root.children) {
                int depth = maxDepth1(node);
                if (depth+1 > result) {
                    result = depth+1;
                }
            }
        }
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
};
