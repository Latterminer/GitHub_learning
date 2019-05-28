package com.wy.jianzhi_offer;

import java.util.ArrayDeque;
import java.util.Queue;

public class BitTreeDepth {
    public int getTreeDepth(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = getTreeDepth(node.left);
        int right = getTreeDepth(node.right);
        return 1 + Math.max(left, right);
    }

    public int getWidth(TreeNode node){
        if (node == null)
            return 0;
        int maxWidth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        int len = queue.size();
        while (true){
            if (len == 0){
                break;
            }
            while (len > 0){
                TreeNode tn = queue.poll();
                len--;
                if (tn.left != null){
                    queue.add(tn.left);
                }
                if (tn.right != null){
                    queue.add(tn.right);
                }
            }
            len = queue.size();
            maxWidth = Math.max(maxWidth, len);
        }
        return maxWidth;
    }
}
