package Java8.ConsumerPredicateSupplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo{
/*
public class ConsumerDemo implements Consumer<Integer> {
    @Override
    public void accept(Integer integer) {
        System.out.println("The integer inside ConsumerDemo - accept is "+integer);
    }
    */

    public static void main(String[] args) {
        Consumer<Integer> consumer= integer -> System.out.println("The integer inside ConsumerDemo - accept is " + integer);
        consumer.accept(69);

        List<Integer> integers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        integers.stream().forEach(consumer);
    }
}
