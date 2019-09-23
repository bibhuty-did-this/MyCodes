package Java8.DefogTech.ExecutorServiceImplementation._03_ConstructorAndLifeCycleMethods;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LifeCycleOfThreads {
    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service= Executors.newCachedThreadPool();
        for(int i=0;i<1000;++i){
            service.execute(new Task());
        }

        // initiate shutdown
        service.shutdown();

        // will throw RejectionExecutionException
        // service.execute(new Task());

        // will return true, since shutdown has begun
        service.isShutdown();

        // will return true if all tasks are completed including queued ones
        service.isTerminated();

        // block until all the tasks are completed or if timeout occurs
        service.awaitTermination(10, TimeUnit.SECONDS);

        // will shutdown instantly and will return all the queued tasks and execution not initiated
        // and complete the other running tasks
        List<Runnable> runnableList=service.shutdownNow();
    }
}
