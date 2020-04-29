package com.wy.grammar;

/**
 * @author wy
 * @date 2020/4/26
 * @description
 */
class Base {
    public Base(){
        System.out.print("Base gouzhao");
    }
    private static Base testExecutionOrder =new Base();
    static{
        System.out.print("static");
    }
    {
        System.out.print("A1");
    }
}
public class TestExecutionOrder extends Base {
    public TestExecutionOrder(){
        System.out.print("TestExecutionOrder");
    }
    public static void main(String[] args) {
        System.out.println("0000");
        TestExecutionOrder b=new TestExecutionOrder();
    }
}
