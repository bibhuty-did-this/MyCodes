package Java8.DevoxxAndOracleDevelopers.ParallelAndAsynchronousProgrammingWithStreamsWithCompletableFuture;

import java.util.Arrays;
import java.util.List;

// Before formula to decide number of threads
public class Part2 {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // parallel and filter
        numbers
            .parallelStream()
            .filter(Part2::checkIfEven)
            .forEachOrdered(num->{});

        // parallel and reduce
        /**
         * Note: Many operation start concurrently with 0, that's how it achieves
         *       that's why it mess up with non-zero value
         *
         * Note: Reduce doesn't take an initial value, it takes an identity value
         *       (like 0 for + and 1 in *)
         */
        System.out.println(
                numbers
                    .parallelStream()
                    .reduce(10,(total,carry) -> getSum(total,carry))
        );
    }

    private static int getSum(int total, int carry) {
        System.out.println("getSum: total = "+total+", carry = "+carry+", total+carry = "+(total+carry)+" -- "+Thread.currentThread());
        return total+carry;
    }

    private static boolean checkIfEven(int integer) {
        System.out.println("checkIfEven: "+integer+" -- "+Thread.currentThread());
        sleep(1000);
        return integer%2==0;
    }
    private static void sleep(int i) {
        try{
            Thread.sleep(1000);
        }catch (Exception ex){}
    }
}
