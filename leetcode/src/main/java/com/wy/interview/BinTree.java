package com.wy.interview;

import java.util.List;

public class BinTree {
    private BinTree lchild;
    private BinTree rchild;
    private BinTree root;
    private Object data;
    private List<BinTree> datas;

    public BinTree(BinTree lchild, BinTree rchild, Object data) {
        super();
        this.lchild = lchild;
        this.rchild = rchild;
        this.data = data;
    }

    public BinTree(Object data) {
        this(null, null, data);
    }

    public void createBinTree(Object[] array) {
        BinTree root = new BinTree(array[0]);
        for (int i = 0; i < array.length/2; i++){

        }
    }

    public void preorder(BinTree node) {
        if (node != null) {
            System.out.println(node.data);
            preorder(node.lchild);
            preorder(node.rchild);
        }
    }

    public void midorder(BinTree node) {
        if (node != null) {
            midorder(node.lchild);
            System.out.println(node.data);
            midorder(node.rchild);
        }
    }

    public void afterorder(BinTree node) {
        if (node != null) {
            afterorder(node.lchild);
            afterorder(node.rchild);
            System.out.println(node.data);
        }
    }

}
