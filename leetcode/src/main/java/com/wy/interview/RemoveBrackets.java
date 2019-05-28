package com.wy.interview;

import java.util.Stack;

public class RemoveBrackets {
    public static String removeKH(String str) {
        char[] array = str.toCharArray();
        Stack stack = new Stack();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push(array[i]);
            } else if (array[i] == ')') {
                if (stack.isEmpty()) {
                    return "ERROR";
                }
                stack.pop();
            } else {
                stringBuffer.append(array[i]);
            }
        }
        if(!stack.isEmpty()){
            return "ERROR";
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
//        String str = new String("fe(fef(fefe)fefe(fefe))fef))");
        String str = new String("fe(fe(((((f(fefe)fefe)fefe()fef()");
        String result = removeKH(str);
        System.out.println(result);
    }
}
