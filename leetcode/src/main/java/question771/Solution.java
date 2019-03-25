package question771;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wangyong
 * @date 2019/3/20
 * @description
 */
public class Solution {
    /**
     * 我的解法
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        HashSet<Character> jSet = new HashSet<>();
        for (char c: J.toCharArray()) {
            jSet.add(c);
        }

        for (char c: S.toCharArray()){
            if (jSet.contains(c)){
                result++;
            }
        }
        return result;
    }
}
