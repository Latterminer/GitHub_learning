package grammar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {
    public void synFunctionTest(){
        synchronized (this){
            for (int i = 0; i < 10; i++){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        final SynchronizedTest synchronizedTest = new SynchronizedTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(synchronizedTest::synFunctionTest);
        executorService.execute(synchronizedTest::synFunctionTest);
        executorService.shutdown();
    }
}
