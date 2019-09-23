package Java8.streams._06_PeekAndSkip;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<String> numbers=Stream.of("One","Two","Three")
                .filter(num->!num.equals("One"))
                .peek(System.out::println)
                .collect(Collectors.toList());

        IntStream.of(9,10,1,2,3,4,5,6,7)
                .skip(2)
                .filter(i->i>5)
                .forEach(System.out::println);
    }
}
