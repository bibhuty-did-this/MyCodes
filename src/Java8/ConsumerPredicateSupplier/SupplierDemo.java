package Java8.ConsumerPredicateSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {
/*public class SupplierDemo implements Supplier<String> {
    @Override
    public String get() {
        return "Hello SupplierDemo";
    }*/

    public static void main(String[] args) {
        Supplier<String> helloSupplier= () -> "Hello SupplierDemo";
        System.out.println(helloSupplier.get());

        List<Integer> integers= new ArrayList<>();

        integers.stream().map(String::valueOf).findAny().orElseGet(helloSupplier);

    }
}
