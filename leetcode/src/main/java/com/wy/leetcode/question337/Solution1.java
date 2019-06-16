package com.wy.leetcode.question337;

/**
 * @author wangyong
 * @date 2019/6/13
 * @description
 */
class Solution1 {
    /**
     * 动态规划
     * 思路：
     * 定义一个数组res,长度为2,res[0]表示不抢该节点可获得最大值,res[1]表示抢劫该节点可获得最大值
     * 方法helper(r)意为：在以r为根节点的树中,返回抢劫根节点与不抢劫根节点可获得的最大值
     * 执行用时 2ms
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {

        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode r) {
        //边界条件，r为null时，跳出
        if (r == null) {
            return new int[2];
        }
        //对于以r.left为根的树，计算抢劫根节点(r.left)与不抢劫根节点可获得最大金额.
        // left[0]则为不抢r.lrft可获得的最大金额,left[1]则为抢劫r.left可获得的最大金额  以下right[] 分析同理
        int[] left = helper(r.left);
        int[] right = helper(r.right);
        int[] res = new int[2];
        //计算不抢劫当前根节点可获得的最大金额(那么其左右子树可以随便抢)
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //计算若抢劫根节点可获得的最大金额(此时,其左右子树的根节点不能被抢)
        res[1] = r.val + left[0] + right[0];
        return res;
    }
}