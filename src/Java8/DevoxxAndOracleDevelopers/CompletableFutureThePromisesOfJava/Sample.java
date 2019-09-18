package Java8.DevoxxAndOracleDevelopers.CompletableFutureThePromisesOfJava;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class Sample {

    public static ForkJoinPool forkJoinPool=new ForkJoinPool(10);

    public static int compute(){
        System.out.println("Thread where compute method runs is "+Thread.currentThread().getName());
        return new Random().nextInt();
    }

    public static void printIt(int value){
        // Note: It can run in either of main thread or commonPool
        System.out.println("Thread where printIt method runs is "+Thread.currentThread().getName());
        System.out.println(value);
    }

    public static CompletableFuture<Integer> create(){
        System.out.println("Thread where create method runs is "+Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(()->compute(),forkJoinPool);
    }

    public static boolean sleep(int millis){
        try {
            Thread.sleep(millis);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Thread running inside main is "+Thread.currentThread().getName());
        CompletableFuture<Integer> createFuture=create();
        sleep(1000);

        createFuture
                .thenApply(data->data*0) // Just like map
                .thenApply(data->data+1)
                .thenAccept(data-> printIt(data)) // Just like for each
                .thenRun(()-> System.out.println("All done"))
                .thenRun(()-> System.out.println("Not really"))
                .thenRun(()-> System.out.println("Keep running"));

        sleep(1000);
    }
}
