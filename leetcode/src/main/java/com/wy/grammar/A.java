package com.wy.grammar;

/**
 * @author wy
 * @date 2020/7/1
 * @description
 */
public class A {
}

class B extends A {
    public static void main(String[] args) {
        A[] fdf = new A[1];
        fdf[0] = new B();
    }
}
