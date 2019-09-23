package Java8.DevoxxAndOracleDevelopers.CompletableFutureThePromisesOfJava;

import java.util.concurrent.CompletableFuture;

public class CombiningFutures {

    public static CompletableFuture<Integer> create(int n){
        return CompletableFuture.supplyAsync(()->n);
    }

    public static void main(String[] args) {
        create(2)
                .thenCombine(create(3),(a,b)->a+b)
                .thenAccept(System.out::println);
    }
}
