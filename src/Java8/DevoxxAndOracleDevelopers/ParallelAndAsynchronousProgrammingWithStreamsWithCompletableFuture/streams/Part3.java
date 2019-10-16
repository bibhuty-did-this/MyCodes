package Java8.DevoxxAndOracleDevelopers.ParallelAndAsynchronousProgrammingWithStreamsWithCompletableFuture.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class Part3 {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        System.out.println("Number of cores in this machine is "+Runtime.getRuntime().availableProcessors());
        System.out.println(ForkJoinPool.commonPool());

        // When you run it and observe properly it runs in batches of parallel
        // threads, which gives us rough idea about how they work
        numbers
            .parallelStream()
            .map(Part3::transform)
            .forEach(num->{});

        // configuring programmatically number of threads
        process(numbers.stream().map(Part3::transform));
    }

    private static void process(Stream<Integer> stream){
        stream.forEach(num->{});
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
