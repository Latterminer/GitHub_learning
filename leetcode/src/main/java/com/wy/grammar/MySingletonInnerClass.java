package com.wy.grammar;

/**
 * @author wy
 * @date 2020/4/14
 * @description
 */
public class MySingletonInnerClass {
    private static class MySingletonHolder {
        private static final MySingletonInnerClass instance = new MySingletonInnerClass();
    }

    private MySingletonInnerClass() {

    }

    public static MySingletonInnerClass getInstance() {
        return MySingletonHolder.instance;
    }
}
