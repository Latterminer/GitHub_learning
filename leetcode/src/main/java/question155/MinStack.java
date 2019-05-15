package question155;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyong
 * @date 2019/4/25
 * @description
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    private List<Integer> stack = new LinkedList<Integer>();
    /*
    注意初始值要为最大值
     */
    private int min= Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int x) {
        stack.add(x);
        if (min > x) {
            min = x;
        }
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        /*
        可以进行一下判断后再排序
         */
        min = Integer.MAX_VALUE;
        for (Integer item : stack) {
            if (item < min) {
                min = item;
            }
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min;
    }
}
