package Java8.DevoxxAndOracleDevelopers.CompletableFutureThePromisesOfJava;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CreatingPipelineAndCompletingTheSame {
    public static int handle(Throwable throwable){
        System.out.println("ERROR: "+throwable);
        throw new RuntimeException("This is beyond repair");
    }
    // Pass a future and then do some operations in it
    public static void process(CompletableFuture<Integer> integerCompletableFuture){
        integerCompletableFuture
                .exceptionally(throwable -> handle(throwable))
                .thenApply(data->data*2)
                .thenApply(data->data+1)
                .thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> future=new CompletableFuture<>();
        future.completeOnTimeout(500,3, TimeUnit.SECONDS); // Java9 implementation
        future.orTimeout(3,TimeUnit.SECONDS); // Java9 implementation
        sleep(3000);
        process(future);
        future.complete(2);
        //future.completeExceptionally(new RuntimeException("something went wrong")); // To get an error
        sleep(5000);
    }

    public static boolean sleep(int millis){
        try {
            Thread.sleep(millis);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
}
