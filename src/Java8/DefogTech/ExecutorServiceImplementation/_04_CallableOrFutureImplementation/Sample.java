package Java8.DefogTech.ExecutorServiceImplementation._04_CallableOrFutureImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Sample {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(10);

        // Future is the placeholder for some value which will arrive
        List<Future<Integer>> futures=new ArrayList<>();
        for(int i=0;i<100;++i){
            // service.submit() also accepts Runnable
            futures.add(service.submit(new Task()));
        }

        // blocking operation(the main thread will be blocked until the future is ready)
        futures.stream().forEach(future-> {
            try {
                System.out.println("Current future integer value is "+future.get(1,TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }finally {
                // Cancel the task(won't work if the thread has already started if the value is false
                // and will try to interrupt the task when it is true)
                future.cancel(true);

                // Returns true if task  was cancelled
                future.isCancelled();

                // Returns true if the task is completed(successful or failure)
                future.isDone();


            }
        });

        System.out.println("Main thread is unblocked");
        service.shutdown();
    }
    static class Task implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return new Random().nextInt();
        }
    }
}
