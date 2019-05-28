package com.wy.grammar;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MultiThreadTest implements Runnable {
    public void run() {
        System.out.println("Runnable.");
    }
}

class MultiThreadTest1 implements Callable<String>{
    public String call() throws Exception {
        return "Callable.";
    }

    public static void main(String[] args) {
        MultiThreadTest1 multiThreadTest1 = new MultiThreadTest1();
        FutureTask<String> futureTask = new FutureTask<String>(multiThreadTest1);
        Thread thread = new Thread(futureTask);
        thread.start();

    }
}

class MultiTreadTest2 extends Thread{

}
