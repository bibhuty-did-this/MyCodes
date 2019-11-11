package Java8.Generics._06_Wildcards._02_UnboundedWildcards;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildcard {

    public static void printList(List<?> list){
        list.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        printList(Arrays.asList(1, 2, 3));
        printList(Arrays.asList("one", "two", "three"));
    }
}
