package com.wy.concurrent.chapter3;

/**
 * @author wy
 * @date 2019-05-28
 * @description
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        ReaderThread readerThread = new ReaderThread();
        readerThread.start();
        number=10;
        ready=true;
    }
}
