package com.wy.leetcode.question899;

import java.util.Arrays;

/**
 * @author wy
 * @date 2019-06-13
 * @description
 *
 * 给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。
 *
 * 在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。
 *
 * 返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "cba", K = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * 示例 2：
 *
 * 输入：S = "baaca", K = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 *  
 *
 * 提示：
 *
 * 1 <= K <= S.length <= 1000
 * S 只由小写字母组成。
 */
public class Solution {
    /**
     * 思路： 当K==1时， 需要对所有的情况进行遍历
     *       当K>1时，对S按照字典顺序排序
     *
     * 证明: sketch_like 说的"K > 1 时， 可以生成当前字符串的任意序列"：
     *
     * 记循环S[0]为操作(1)，循环S[1]为操作(2) ，依次执行如下变换：
     *
     * (1) * N次将原S[N]移动到[0]位，
     * (2) * M次使S[N]位于原S[(N+M+1)%len(S)]之前，
     * 再执行 (1) * X次，以正好将原S[0]重新移动到[0]位。
     * 由于M是任意的，因此这样一次变换可以将任意的S[N]移动到任意位置而保持其他元素相对位置不变。反复执行以上变换就可以将S变换成任意顺序。特别的，利用以上变换进行插入排序时，可以直接得到一个生成目标字符串的操作序列。
     *
     * @param S
     * @param K
     * @return
     */
    public static String orderlyQueue(String S, int K) {
        String min = S;
        if (K == 1) {
            String sb = S;
            for (int i = 0; i < S.length(); i++) {
                int compare = min.compareTo(sb);
                if (compare > 0) {
                    min = sb;
                }
                sb = sb.substring(1) + sb.charAt(0);
            }
        } else {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            min = String.valueOf(chars);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(orderlyQueue("cba", 1));
    }
}
