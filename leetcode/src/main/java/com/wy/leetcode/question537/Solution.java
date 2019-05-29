package com.wy.leetcode.question537;

/**
 * @author wangyong
 * @date 2019/5/29
 * @description
 * 给定两个表示复数的字符串。
 *
 * 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 *
 * 示例 1:
 *
 * 输入: "1+1i", "1+1i"
 * 输出: "0+2i"
 * 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2:
 *
 * 输入: "1+-1i", "1+-1i"
 * 输出: "0+-2i"
 * 解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 * 注意:
 *
 * 输入字符串不包含额外的空格。
 * 输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。
 */
public class Solution {
    /**
     * 算法
     *
     * 两个复数的乘法可以依下述方法完成：
     *
     * (a+ib) \times (x+iy)=ax+i^2by+i(bx+ay)=ax-by+i(bx+ay)
     * (a+ib)×(x+iy)=ax+i
     * 2
     *  by+i(bx+ay)=ax−by+i(bx+ay)
     * @param a
     * @param b
     * @return
     */
    public static String complexNumberMultiply(String a, String b) {
        String[] factorsA = a.substring(0, a.length() - 1).split("\\+");
        String[] factorsB = b.substring(0, b.length() - 1).split("\\+");
        Integer realPartA = Integer.valueOf(factorsA[0]);
        Integer virtualPartA = Integer.valueOf(factorsA[1]);
        Integer realPartB = Integer.valueOf(factorsB[0]);
        Integer virtualPartB = Integer.valueOf(factorsB[1]);
        int realPartResult = realPartA * realPartB - virtualPartA * virtualPartB;
        int virtualPartResult = virtualPartA*realPartB + realPartA* virtualPartB;
        return realPartResult + "+" + virtualPartResult + "i";
    }

    public static void main(String[] args) {
        String a = "1+1i";
        String b = "1+1i";
        System.out.println(complexNumberMultiply(a, b));
    }
}
