package Java8.DefogTech.ExecutorServiceImplementation._01_Introduction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _04_UseOfThreadPoolForIOIntensiveTasks {
    public static void main(String[] args) {
        // Creation of thread pool
        /**
         * When the operation is IO intensive then it is recommended to have a
         * thread pool of good size because, it'll wait anyway before completing
         * an operation.
         */
        ExecutorService service= Executors.newFixedThreadPool(100);

        for(int i=0;i<10;++i){
            service.execute(new _02_UsingThreadPoolToRunThreads.Task());
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
