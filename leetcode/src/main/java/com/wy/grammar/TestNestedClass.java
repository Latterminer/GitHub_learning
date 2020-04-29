package com.wy.grammar;

/**
 * @author wy
 * @date 2020/3/23
 * @description
 */
public class TestNestedClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        final OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    }
}
