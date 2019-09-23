package Java8.DefogTech.ExecutorServiceImplementation._02_TypeOfPools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _04_UsingScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService service= Executors.newScheduledThreadPool(10);

        // Delay task after 2 seconds
        service.schedule(new ExecuteOnce(),2, TimeUnit.SECONDS);

        // Task to run repeatedly after 2 sec
        service.scheduleAtFixedRate(new ExecuteAtFixedRate(),3,2,TimeUnit.SECONDS);

        // Task to run repeatedly after 2 sec after previous task completes
        service.scheduleWithFixedDelay(new ExecuteAtFixedDelay(),3,2,TimeUnit.SECONDS);

    }
    static class ExecuteOnce implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread Name Of Task for ExecuteOnce: "+Thread.currentThread().getName());
        }
    }
    static class ExecuteAtFixedRate implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread Name Of Task for ExecuteAtFixedRate: "+Thread.currentThread().getName());
        }
    }
    static class ExecuteAtFixedDelay implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread Name Of Task for ExecuteAtFixedDelay: "+Thread.currentThread().getName());
        }
    }
}
