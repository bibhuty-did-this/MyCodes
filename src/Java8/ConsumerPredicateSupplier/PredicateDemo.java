package Java8.ConsumerPredicateSupplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
/*public class PredicateDemo implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer instanceof Integer?true:false;
    }
    */

    public static void main(String[] args) {
        Predicate<Integer> isEven= integer -> integer%2==0;
        System.out.println(isEven.test(11));

        List<Integer> integers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        integers.stream().filter(isEven).forEach(System.out::println);

    }
}
