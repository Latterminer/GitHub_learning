package jianzhi_offer;
/**
 * @Description:    求最长回文子串
 * @Author:         wy
 * @CreateDate:     2019/1/7 7:24
 * @Version:        1.0
 */
public class MaxHuiWenString {
    private static int lo, maxLen;

    public static String getMaxHuiWenString(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return s.substring(lo, lo+maxLen);
    }

    private static void helper(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (end - start - 1 > maxLen) {
            maxLen = end - start - 1;
            lo = start + 1;
        }
    }

    public static void main(String[] args) {
        String s = "abccbad";

        System.out.println(getMaxHuiWenString(s));
    }
}
