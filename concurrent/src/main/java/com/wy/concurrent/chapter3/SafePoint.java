package com.wy.concurrent.chapter3;

/**
 * @author wy
 * @date 2019-05-30
 * @description
 */
public class SafePoint {
    private int x;
    private int y;

    private SafePoint(SafePoint p) {
        this(p.x, p.y);
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        SafePoint p = new SafePoint(5, 6);
        System.out.println(p.y);
    }
}
