package Java8.DevoxxAndOracleDevelopers.ParallelAndAsynchronousProgrammingWithStreamsWithCompletableFuture.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

// Before creating pipe, then completing
public class Part3 {
    public static void main(String[] args) {
        create()
                .thenApply(Part3::doubleIt) // like map
                .thenAccept(Part3::printIt) // like forEach
                .thenRun(()-> System.out.println("Everything went well"));
    }

    private static int doubleIt(int integer) {
        return 2*integer;
    }

    public static CompletableFuture<Integer> create(){
        ForkJoinPool pool=new ForkJoinPool(10);
        return CompletableFuture.supplyAsync(()-> compute(),pool);
    }
    private static int compute() {
        return 2;
    }
    private static void printIt(int data){
        System.out.println(data);
    }
}
