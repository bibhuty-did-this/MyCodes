package Java8.DevoxxAndOracleDevelopers.ParallelAndAsynchronousProgrammingWithStreamsWithCompletableFuture.streams;

import java.util.Arrays;
import java.util.List;

// Before consequence of using parallel
public class Part1 {
    public static void main(String[] args) {
        // Collection pipeline pattern
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(numbers);
        /**
         * - Imperative style has accidental complexity
         * - Functional style is has less complexity and is also easier to parallelize
         */
        System.out.println(
                "Double of all the even numbers are: "+
                numbers.stream().filter(Part1::isEven).mapToInt(Part1::doubleIt).sum()
        );

        /**
         * In imperative style the structure of sequential code is very different from
         * the structure of concurrent code.
         *
         * Using streams the structure of sequential code is identical to the structure
         * of concurrent code.
         */
        System.out.println("Parallel Stream: Method-1 ");
        numbers
            .parallelStream()
            .map(Part1::transform)
            .forEach(System.out::println);
        System.out.println("Parallel Stream: Method-2 ");
        numbers
            .stream()
            .parallel()
            .map(Part1::transform)
            .forEach(System.out::println);

        /**
         * When you use sequential and parallel together then the operation at last
         * (i.e. before the terminal operation and before it) will be effective
         */
        System.out.println("Parallel and sequential behaviour along with ordering behaviour: ");
        numbers
            .stream()
            .sequential() // it is of no use
            .map(Part1::transformWithInformationOfCurrentThread)
            .parallel() // last one dominates
            .forEachOrdered(Part1::printIt); // doesn't convert
    }

    private static int transformWithInformationOfCurrentThread(int integer) {
        sleep(1000);
        System.out.println("Inside transformWithInformationOfCurrentThread: Integer is "+integer+" running on thread "+Thread.currentThread());
        return integer;
    }
    private static void printIt(int integer) {
        System.out.println("Inside printIt: Integer is "+integer+" running on thread "+Thread.currentThread());
    }

    private static int transform(int integer) {
        sleep(1000);
        return integer*1;
    }

    private static void sleep(int i) {
        try{
            Thread.sleep(1000);
        }catch (Exception ex){}
    }

    private static int doubleIt(Integer num) {
        return num*2;
    }

    private static boolean isEven(Integer num) {
        return num%2==0;
    }
}
