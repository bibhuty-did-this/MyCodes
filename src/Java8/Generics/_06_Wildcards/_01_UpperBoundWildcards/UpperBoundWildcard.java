package Java8.Generics._06_Wildcards._01_UpperBoundWildcards;

import java.util.Arrays;
import java.util.List;

public class UpperBoundWildcard {
    public static double sumOfList(List<? extends Number> list){
        return list.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));

        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));
    }
}
