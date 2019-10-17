package Java8.DevoxxAndOracleDevelopers.ParallelAndAsynchronousProgrammingWithStreamsWithCompletableFuture.completableFuture;

import java.util.concurrent.CompletableFuture;

public class Part6 {
    public static CompletableFuture<Integer> create(int number){
        return CompletableFuture.supplyAsync(()->number);
    }
    public static void main(String[] args) {
        create(2)
            .thenCombine(create(3),Integer::sum)
            .thenAccept(System.out::println);

        create(2)
                //.thenApply(Part6::increment) // returns a completable future, so then accept won't work
                .thenCompose(Part6::increment) // right way to deal with functions returning completable future
                .thenAccept(System.out::println);
    }

    public static CompletableFuture<Integer> increment(int num){
        return CompletableFuture.supplyAsync(()->num+1);
    }
}
