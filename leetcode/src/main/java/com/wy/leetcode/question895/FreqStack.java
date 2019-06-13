package com.wy.leetcode.question895;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyong
 * @date 2019/6/12
 * @description
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 *
 * FreqStack 有两个函数：
 *
 * push(int x)，将整数 x 推入栈中。
 * pop()，它移除并返回栈中出现最频繁的元素。
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]
 * 解释：
 * 执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：
 *
 * pop() -> 返回 5，因为 5 是出现频率最高的。
 * 栈变成 [5,7,5,7,4]。
 *
 * pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。
 * 栈变成 [5,7,5,4]。
 *
 * pop() -> 返回 5 。
 * 栈变成 [5,7,4]。
 *
 * pop() -> 返回 4 。
 * 栈变成 [5,7]。
 *  
 *
 * 提示：
 *
 * 对 FreqStack.push(int x) 的调用中 0 <= x <= 10^9。
 * 如果栈的元素数目为零，则保证不会调用  FreqStack.pop()。
 * 单个测试样例中，对 FreqStack.push 的总调用次数不会超过 10000。
 * 单个测试样例中，对 FreqStack.pop 的总调用次数不会超过 10000。
 * 所有测试样例中，对 FreqStack.push 和 FreqStack.pop 的总调用次数不会超过 150000。
 */
public class FreqStack {
    private List<Integer> stack;
    private int max;
    private HashMap<Integer, Integer> numCountMap;
    private Integer maxFreqNum;
    public FreqStack() {
        this.stack = new LinkedList<>();
        this.max = 0;
        this.numCountMap = new LinkedHashMap<>();
    }

    public void push(int x) {
        this.stack.add(x);
        int count;
        if (numCountMap.containsKey(x)) {
            count = numCountMap.get(x);
            numCountMap.put(x, ++count);
        } else {
            numCountMap.put(x, 1);
            count = 1;
        }

        if (count >= max) {
            max = count;
            maxFreqNum = x;
        }
    }

    public int pop() {
        int result = maxFreqNum;
        stack.remove(stack.lastIndexOf(maxFreqNum));
        Integer integer = numCountMap.get(maxFreqNum);
        numCountMap.replace(maxFreqNum, integer - 1);
        max--;
        numCountMap.forEach((k,v)->{
            if (v > max) {
                max=v;
                maxFreqNum = k;
            } else if (v == max) {
                maxFreqNum = stack.lastIndexOf(maxFreqNum) > stack.lastIndexOf(k) ? maxFreqNum : k;
            }});
        return result;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(1);
        freqStack.push(0);
        freqStack.push(0);
        freqStack.push(1);
        freqStack.push(5);
        freqStack.push(4);
        freqStack.push(1);
        freqStack.push(5);
        freqStack.push(1);
        freqStack.push(6);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
