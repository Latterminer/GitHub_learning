package com.wy.grammar;

/**
 * @author wy
 * @date 2020/3/23
 * @description
 */
public class OuterClass {

    private static Integer outerStaticProperty;

    private Integer outerClassProperty;
    private InnerClass InnerClass;

    static class InnerStaticClass {
        private Integer innerClassProperty1 = OuterClass.outerStaticProperty;
    }

    class InnerClass {
        private Integer innerClassProperty2 = OuterClass.this.outerClassProperty;
    }


    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        final InnerClass innerClass = outerClass.new InnerClass();
        OuterClass.InnerStaticClass innerStaticClass = new OuterClass.InnerStaticClass();
    }
}
