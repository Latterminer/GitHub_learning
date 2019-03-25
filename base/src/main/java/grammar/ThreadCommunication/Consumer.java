package grammar.ThreadCommunication;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(getName() + "consumer");
            try {
                Thread.sleep(100);
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer done!");
        }
    }
}
