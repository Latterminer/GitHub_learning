package question179;

import java.util.Arrays;

/**
 * @author wy
 * @description 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * @date 2019-05-15
 */
public class Solution {
    /**
     * 只需对原数组中的元素进行一次排序即可，排序规则是：
     * <p>
     * 将原数组中的数均转换成字符串，如果s1 + s2大于s2 + s1（这里的比较大小是用字符串的比较规则比较大小），则s1排在s2的前面。
     *
     * @param array
     */

    private static void sort1(String[] array) {
        Arrays.sort(array, (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        });
    }

    public static String largestNumber(int[] nums) {
        String[] strings = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        sort1(strings);
        StringBuilder sb = new StringBuilder();
        for (String temp : strings) {
            sb.append(temp);
        }
        /*
        去掉字符串前面的0，方法一
         */
        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

         /*
        去掉字符串前面的0，方法二
         */
        String result = sb.toString().replaceAll("^(0+)", "");
        if (result.length() == 0) {
            result = "0";
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4704, 6306, 9385, 7536, 3462, 4798, 5422, 5529, 8070, 6241, 9094, 7846, 663, 6221, 216, 6758, 8353, 3650, 3836, 8183, 3516, 5909, 6744, 1548, 5712, 2281, 3664, 7100, 6698, 7321, 4980, 8937, 3163, 5784, 3298, 9890, 1090, 7605, 1380, 1147, 1495, 3699, 9448, 5208, 9456, 3846, 3567, 6856, 2000, 3575, 7205, 2697, 5972, 7471, 1763, 1143, 1417, 6038, 2313, 6554, 9026, 8107, 9827, 7982, 9685, 3905, 8939, 1048, 282, 7423, 6327, 2970, 4453, 5460, 3399, 9533, 914, 3932, 192, 3084, 6806, 273, 4283, 2060, 5682, 2, 2362, 4812, 7032, 810, 2465, 6511, 213, 2362, 3021, 2745, 3636, 6265, 1518, 8398};

        System.out.println(largestNumber(a));
    }
}
