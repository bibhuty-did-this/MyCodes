package Java8.DevoxxAndOracleDevelopers.ParallelAndAsynchronousProgrammingWithStreamsWithCompletableFuture.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

import static java.lang.Thread.sleep;

// Before async vs non-async
public class Part2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("In main thread -- "+Thread.currentThread());
        CompletableFuture<Integer> future= create();
        sleep(100);

        // no unnecessary thread switching instead work just in main thread
        // in case a delay is added that is more than 1000ms then the main is
        // not available during the operation, so it doesn't work
        future.thenAccept(Part2::printIt);

        System.out.println("here");
        sleep(1000);
    }
    public static CompletableFuture<Integer> create(){
        ForkJoinPool pool=new ForkJoinPool(10);
        return CompletableFuture.supplyAsync(()-> compute(),pool);
    }
    private static int compute() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("compute --- "+Thread.currentThread());
        return 2;
    }
    private static void printIt(int data){
        System.out.println("printIt --- "+Thread.currentThread());
        System.out.println(data);
    }
}
