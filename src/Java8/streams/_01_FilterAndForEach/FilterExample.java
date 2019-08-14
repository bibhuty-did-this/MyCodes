package Java8.streams._01_FilterAndForEach;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static void main(String[] args) {
        List<String> names= Arrays.asList(
          "Bibhuti","Bhusan","Bonty","Name"
        );
        names.forEach(name-> System.out.println(name));
        System.out.println("\nFiltering with streams");
        names
                .stream()
                .filter(FilterExample::startsWithB) // Predicate
                .forEach(System.out::println); // Consumer
    }

    private static boolean startsWithB(String name) {
        return name.startsWith("B");
    }
}
