package com.wy.interview; /**
 * @Description:
 * @Author: wy
 * @CreateDate: 2018/11/9 19:47
 * @Version: 1.0
 */

import java.util.*;

public class CalcCharNum {
    public static void main(String[] args) {
        String str = "'asdfsffjdjkfjkldsjflksjdkfjlsjfdlsjflsjdflsjdlfjsldjfkdjflsf";
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        char[] strArray = str.toCharArray();
        for (char ch : strArray){
            if (result.containsKey(ch)) {
                Integer old = result.get(ch);
                result.put(ch, ++old);
            }
            else {
                result.put(ch, 1);
            }
        }
        System.out.println(result);
    }
}
