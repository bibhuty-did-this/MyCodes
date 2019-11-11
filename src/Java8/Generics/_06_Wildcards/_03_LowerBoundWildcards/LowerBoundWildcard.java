package Java8.Generics._06_Wildcards._03_LowerBoundWildcards;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LowerBoundWildcard {
    public static void addNumber(List<? super Integer> list){
        Stream.of(1,2,3,4,5,6,7,8,9).forEach(list::add);
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        addNumber(new ArrayList<>());
    }
}
