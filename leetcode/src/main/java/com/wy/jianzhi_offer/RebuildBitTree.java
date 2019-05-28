package com.wy.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

public class RebuildBitTree {
    Map<Integer, Integer> InOrderIndex = new HashMap<>();
    public TreeNode rebuildTree(Integer[] preOrder, Integer[] inOrder){
        for (int i =0; i < inOrder.length; i++){
            this.InOrderIndex.put(inOrder[i], i);
        }
        return rebuildTreeCore(preOrder, 0, preOrder.length, 0);
    }
    // inOrderStart为中序遍历的起始点，由它计算子树的长度
    private TreeNode rebuildTreeCore(Integer[] preOrder, int start, int end, int inOrderStart){
        if (end < start){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[start]);
        // 得出中序遍历的根结点的索引
        int inOrderRootIndex = InOrderIndex.get(root.data);
        // 由中序遍历得到左子树的长度
        int leftTreeLength = inOrderRootIndex - inOrderStart;
        //
        root.left = rebuildTreeCore(preOrder, start+1, start + leftTreeLength, inOrderStart);
        root.right = rebuildTreeCore(preOrder, start + leftTreeLength + 1, end, inOrderRootIndex + 1);
        return root;
    }
}

class TreeNode{
    public TreeNode left = null;
    public TreeNode right = null;
    public int data;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(TreeNode left, TreeNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}
