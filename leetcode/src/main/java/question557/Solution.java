package question557;

import java.util.Arrays;

/**
 * @author wangyong
 * @date 2019/5/26
 * @description
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder reversedStr = sb.reverse();
        String[] strings = reversedStr.toString().split(" ");
        int len = strings.length;
        for (int i = 0; i < len/2; i++) {
            String temp = strings[i];
            strings[i] = strings[len - 1 - i];
            strings[len - 1 - i] = temp;
        }
        return String.join(" ", strings);
    }
}
