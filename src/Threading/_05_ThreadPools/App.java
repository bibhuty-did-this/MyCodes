package Threading._05_ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(2);

        for(int i=1;i<=5;++i){
            executor.submit(new Processor(i));
        }

        // It'll wait until all the thread remaining in the thread pool to get their
        // work done then it'll shutdown.
        executor.shutdown();

        System.out.println("All tasks submitted.");

        // Wait for this much time before shutdown
        executor.awaitTermination(5, TimeUnit.MILLISECONDS);

        System.out.println("All tasks complted. ");
    }
}

class Processor implements Runnable{

    private int id;

    public Processor(int id){
        this.id=id;
    }

    @Override
    public void run() {
        System.out.println("Starting "+id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed "+id);
    }
}
