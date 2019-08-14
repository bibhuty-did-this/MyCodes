package Threading._06_CountdownLatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(3);
        ExecutorService executor= Executors.newFixedThreadPool(2);
        for (int i=0;i<3;++i){
            executor.submit(new Processor(latch));
        }

        // It waits until the countdown latch is counted down to zero
        latch.await();
        executor.shutdown();

        System.out.println("Completed");
    }
}

class Processor implements Runnable{
    private CountDownLatch latch; // thread safe, so don't need to use synchronized
    public Processor(CountDownLatch latch){
        this.latch=latch;
    }
    @Override
    public void run() {
        System.out.println("Started...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch.countDown();

        System.out.println("Latch value counted down");
    }
}
