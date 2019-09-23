package Java8.DefogTech.ExecutorServiceImplementation._02_TypeOfPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _02_UsingFixedThreadPool {
    public static void main(String[] args) {
        // Creation of thread pool
        ExecutorService service= Executors.newFixedThreadPool(4);

        for(int i=0;i<10;++i){
            service.execute(new Task());
        }

        System.out.println("Thread Name: "+Thread.currentThread().getName());
        service.shutdown();
    }
    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread Name Of Task: "+Thread.currentThread().getName());
        }
    }
}
