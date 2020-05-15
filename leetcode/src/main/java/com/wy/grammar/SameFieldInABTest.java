package com.wy.grammar;

/**
 * @author wy
 * @date 2020/5/10
 * @description
 */
public class SameFieldInABTest {

    static {
        i = 0;
//        System.out.println(i);
    }

    static int i = 0;

    static class A {
        public int a = 1;
    }

    static class B extends A {
        public int a = 2;
        public void out() {
            System.out.println(this.a);
            System.out.println(super.a);
        }
    }

    public static void main(String[] args) {
        B a = new B();
        a.out();
        System.out.println(a.a);
    }
}
