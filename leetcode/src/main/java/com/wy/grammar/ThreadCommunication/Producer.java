package com.wy.grammar.ThreadCommunication;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
    private BlockingQueue<String> blockingDeque;

    public Producer(BlockingQueue<String> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        String[] strArr = new String[]{
                "java",
                "javaee",
                "mysql"
        };
        for (int i = 0; i < 999; i++){
            System.out.println(getName() + "producer");
            try {
                Thread.sleep(100);
                blockingDeque.put(strArr[i%3]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("producer done!" + strArr[i%3]);
        }
    }
}
