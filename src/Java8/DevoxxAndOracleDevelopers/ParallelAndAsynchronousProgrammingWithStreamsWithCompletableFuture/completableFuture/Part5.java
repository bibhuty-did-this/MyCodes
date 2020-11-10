package Java8.DevoxxAndOracleDevelopers.ParallelAndAsynchronousProgrammingWithStreamsWithCompletableFuture.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

// Before combine, compose
public class Part5 {
    public static void main(String[] args) throws InterruptedException {

        // how exceptions could be handled
        create()
            .thenApply(Part5::doubleIt)
            .exceptionally(Part5::handleExceptionWithRecovery)
            .thenAccept(System.out::println)
            .exceptionally(Part5::handleException);


        // completeExceptionally, not that great although
        CompletableFuture<Integer> future = new CompletableFuture<>();
        future
            .thenApply(data->data*2)
            .exceptionally(Part5::handleExceptionWithRecovery)
            .thenApply(data->data+1)
            .thenAccept(System.out::println);

        //future.completeOnTimeout(-10,2, TimeUnit.SECONDS); // Java9 feature

        //future.orTimeout(2,TimeUnit.SECONDS);

        sleep(3000);
        if(Math.random()>.5)
            future.completeExceptionally(new RuntimeException("Don't tell the boss"));
        else
            future.complete(2);
    }

    private static Integer handleExceptionWithRecovery(Throwable throwable) {
        System.out.println("ERROR: "+throwable);
        return -1;
    }

    private static Void handleException(Throwable throwable) {
        System.out.println("ERROR: "+throwable);
        throw new RuntimeException("It is beyond any recovery");
    }

    private static int doubleIt(int i) {
        return 2*i;
    }

    public static int compute(){
        throw new RuntimeException("Something went wrong");
        // return 2;
    }
    public static CompletableFuture<Integer> create(){
        return CompletableFuture.supplyAsync(()->compute());
    }
}
