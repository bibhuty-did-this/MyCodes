package Threading._07_ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    // Thread Safe
    private static BlockingQueue<Integer> queue=new ArrayBlockingQueue(10);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(() -> {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2=new Thread(()->{
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void producer() throws InterruptedException {
        Random random=new Random();
        while(true){
            queue.put(random.nextInt(100));
        }
    }

    private static void consumer() throws InterruptedException {
        Random random=new Random();
        while(true){
            Thread.sleep(400);
            if(random.nextInt(10)==0){
                Integer value=queue.take();

                System.out.println("Taken value: "+value+" and Queue size: "+queue.size());
            }
        }
    }
}


