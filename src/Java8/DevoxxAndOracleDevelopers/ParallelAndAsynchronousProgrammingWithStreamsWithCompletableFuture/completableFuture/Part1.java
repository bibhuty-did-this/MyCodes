package Java8.DevoxxAndOracleDevelopers.ParallelAndAsynchronousProgrammingWithStreamsWithCompletableFuture.completableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

// Before thread of execution
public class Part1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // the word thenAccept because `then` for after future resolves(thennable) & `Accept` as its a consumer
        getARandomNumber()
            .thenAccept(System.out::println)
            .thenRun(()-> System.out.println("This never dies"))
            .thenRun(()-> System.out.println("This never dies really"));

        // get
        // it is a bad idea as `get` is a blocking operation and it is better to forget
        // it is a blocking call and it kind of defeats the purpose of asynchronous call
        System.out.println("Got it");
        CompletableFuture<Integer> getFuture=create();
        System.out.println(getFuture.get());
        System.out.println("After `getFuture` run this.");

        // getNow
        // impatient call
        // don't bother it, rather forget it
        System.out.println("Got it");
        CompletableFuture<Integer> getNowFuture=create();
        System.out.println(getNowFuture.getNow(0));
        System.out.println("After `getNowFuture` run this.");

        System.out.println("In main thread -- "+Thread.currentThread());
        CompletableFuture<Integer> future=get2Async();
        sleep(100);
        future.thenAccept(Part1::printIt);


        // Famous or popular functional interfaces
        // - Supplier<T> T get
        // - Predicate<T> boolean test(T)
        // - Function<T,R> R apply(T)
        // - Consumer<T> void accept(T)
    }

    public static CompletableFuture<Integer> getARandomNumber(){
        return CompletableFuture.supplyAsync(()->new Random().nextInt(10));
    }

    public static CompletableFuture<Integer> create(){
        return CompletableFuture.supplyAsync(()->compute());
    }

    public static CompletableFuture<Integer> get2Async(){
        return CompletableFuture.supplyAsync(()->get2());
    }

    private static int compute() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2;
    }
    private static int get2() {
        System.out.println("get2 --- "+Thread.currentThread());
        return 2;
    }

    private static void printIt(int data){
        System.out.println("printIt --- "+Thread.currentThread());
        System.out.println(data);
    }
}
