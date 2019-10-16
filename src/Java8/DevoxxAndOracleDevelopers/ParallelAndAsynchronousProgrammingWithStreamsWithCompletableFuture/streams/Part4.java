package Java8.DevoxxAndOracleDevelopers.ParallelAndAsynchronousProgrammingWithStreamsWithCompletableFuture.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Part4 {
    public static void main(String[] args) throws InterruptedException{
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        // configuring programmatically number of threads
        process(numbers.parallelStream().map(Part4::transform));

    }

    private static void process(Stream<Integer> stream) throws InterruptedException{
        ForkJoinPool threadPool=new ForkJoinPool(100);

        // terminal operation is running in another pool so the entire
        // stream will run on the thread pool where the terminal operation
        // is running.
        threadPool.submit(()->stream.forEach(num->{}));
        threadPool.shutdown();
        threadPool.awaitTermination(10, TimeUnit.SECONDS);
    }

    private static int transform(int integer) {
        System.out.println(integer+" -- "+Thread.currentThread());
        sleep(1000);
        return integer*1;
    }

    private static void sleep(int i) {
        try{
            Thread.sleep(1000);
        }catch (Exception ex){}
    }
}
