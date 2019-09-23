package Java8.DefogTech.ExecutorServiceImplementation._02_TypeOfPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _03_UsingCachedThreadPool {
    public static void main(String[] args) {

        // For short lived operations
        ExecutorService service= Executors.newCachedThreadPool();
        for(int i=0;i<10;++i){
            service.execute(new Task());
        }
    }
    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread Name Of Task: "+Thread.currentThread().getName());
        }
    }
}
