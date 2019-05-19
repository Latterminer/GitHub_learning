package question500;

import java.util.*;

/**
 * @author wangyong
 * @date 2019/5/19
 * @description
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 *
 * 示例：
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * 用时最短的解法
 * private static final int[] REC = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
 *     public String[] findWords(final String[] words) {
 *         int idx=0;
 *         c:for(String word:words){
 *             char[] p = word.toCharArray();
 *             int id = p[0]-65>25 ? p[0]-97:p[0]-65;
 *             int A=REC[id];
 *             for(int i=1;i<p.length;i++){
 *                 int temp = p[i]-97<0 ? p[i]-65:p[i]-97;
 *                 if(REC[temp]!=A){continue c;}
 *             }
 *             words[idx++] = word;
 *         }
 *         return Arrays.copyOf(words,idx);
 *     }
 */
public class Solution {
    private Map<Character, Integer> dict = new HashMap<>(26);
    {
        dict.put('q', 1);
        dict.put('w', 1);
        dict.put('e', 1);
        dict.put('r', 1);
        dict.put('t', 1);
        dict.put('y', 1);
        dict.put('u', 1);
        dict.put('i', 1);
        dict.put('o', 1);
        dict.put('p', 1);
        dict.put('a', 2);
        dict.put('s', 2);
        dict.put('d', 2);
        dict.put('f', 2);
        dict.put('g', 2);
        dict.put('h', 2);
        dict.put('j', 2);
        dict.put('k', 2);
        dict.put('l', 2);
        dict.put('z', 3);
        dict.put('x', 3);
        dict.put('c', 3);
        dict.put('v', 3);
        dict.put('b', 3);
        dict.put('n', 3);
        dict.put('m', 3);
    }
    public String[] findWords(String[] words) {
        List<String> result = new LinkedList<>();
        for (String str : words) {
            String strLow = str.toLowerCase();
            int sum = 0;
            int len = str.length();
            for (char c : strLow.toCharArray()) {
                sum += dict.get(c);
            }
            if (sum == len * dict.get(strLow.charAt(0))) {
                result.add(str);
            }
        }
        return result.toArray(String[]::new);

//        String[] ret = new String[result.size()];
//        for (int i = 0; i < result.size(); i++) {
//            ret[i] = result.get(i);
//        }
//        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = new String[]{"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(solution.findWords(strings)));
    }
}
