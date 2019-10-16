package Java8.DevoxxAndOracleDevelopers.ParallelAndAsynchronousProgrammingWithStreamsWithCompletableFuture.completableFuture;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

// Before dealing with exceptions
public class Part4 {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        // Breaking the pipeline won't give you correct result unless and until
        // you are collecting the chunks of completable future and using them
        // again and again
        future
            .thenApply(data->data*2)
            .thenApply(data->data+1)
            .thenAccept(System.out::println);

        System.out.println("Built the pipeline");

        sleep(1000);

        future.complete(2);
    }
}
