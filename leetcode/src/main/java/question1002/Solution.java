package question1002;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyong
 * @date 2019/5/26
 * @description 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        int[] left = map(A[0]);
        for (int i = 1; i<A.length;i++) {
            left = reduce(left, map(A[i]));
        }
        List<String> result = new LinkedList<>();
        for (int index = 0; index < left.length; index++) {
            while (left[index]-- > 0) {
                result.add((char) ('a' + index) + "");
            }
        }
        return result;
    }

    /**
     * 对每一个字符串，统计其每个字符出现的个数
     *
     * @param string
     * @return
     */
    public int[] map(String string) {
        int[] dict = new int[26];
        for (char c : string.toCharArray()) {
            dict[c - 'a']++;
        }
        return dict;
    }

    /**
     * 每两个字符串做对比，比较每个字符出现的次数，保留小的那个
     * @param left
     * @param right
     * @return
     */
    public int[] reduce(int[] left, int[] right) {
        int[] result = new int[26];
        for (int i = 0; i < 26; i++) {
            result[i]= Math.min(left[i], right[i]);
        }
        return result;
    }
}
