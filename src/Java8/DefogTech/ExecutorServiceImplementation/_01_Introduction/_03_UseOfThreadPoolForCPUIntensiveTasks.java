package Java8.DefogTech.ExecutorServiceImplementation._01_Introduction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _03_UseOfThreadPoolForCPUIntensiveTasks {
    public static void main(String[] args) {
        // Creation of thread pool
        /**
         * In case of CPU intensive tasks only at a time number of
         * thread which can run concurrently is the number of processor it
         * have, so better to make a thread pool of that size.
         */
        int cores=Runtime.getRuntime().availableProcessors();
        ExecutorService service= Executors.newFixedThreadPool(cores);

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
