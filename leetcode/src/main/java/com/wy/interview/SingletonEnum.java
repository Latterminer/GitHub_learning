package com.wy.interview;

public enum SingletonEnum {
    INSTANCE;

    public static SingletonEnum getInstance(){
        return SingletonEnum.INSTANCE;
    }
    public void showMessage() {
        System.out.println("Hello World!");
    }


    public static void main(String[] args) {
        SingletonEnum singletonEnumInstance = SingletonEnum.getInstance();
        singletonEnumInstance.showMessage();
    }
}
