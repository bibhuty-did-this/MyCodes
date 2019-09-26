package Java8.DevoxxAndOracleDevelopers.GetATasteOfLambdasAndGetAddicted2Streams.codes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PropertiesOfStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,1,2,3,4,5);

        System.out.println(
                "The property of this stream:\n" +
                        " - sized\n" +
                        " - ordered\n" +
                        " - non-distinct\n" +
                        " - non-sorted"
        );
        numbers.stream()
                .filter(num->num%2==0)
                .forEach(PropertiesOfStreamExample::printIt);

        System.out.println(
                "\n\nThe property of this stream which is(changed on runtime):\n" +
                        " - sized\n" +
                        " - ordered\n" +
                        " - distinct\n" +
                        " - non-sorted"
        );
        numbers.stream()
                .filter(num->num%2==0)
                .distinct()
                .forEach(PropertiesOfStreamExample::printIt);

        System.out.println(
                "\n\nThe property of this stream which is(changed on runtime):\n" +
                        " - sized\n" +
                        " - ordered\n" +
                        " - non-distinct\n" +
                        " - sorted"
        );
        numbers.stream()
                .filter(num->num%2==0)
                .sorted()
                .forEach(PropertiesOfStreamExample::printIt);


        // Infinite stream
        System.out.println("\n\nInfinite stream:\n"+
                Stream.iterate(100,num->num+1)
        );

        // Given a number k, and a count n, find the total of the double of n
        // even numbers starting with k, where sqrt of each number is greater than 20
        int k=121;
        int n=51;
        System.out.println("\nCompute above shit: \n"+
                    compute(k,n)
                );
    }

    public static void printIt(int num){
        System.out.print(num+" ");
    }

    public static int compute(int k,int n){

        return Stream.iterate(k,e->e+1) // unbounded, lazy
                .filter(e->e%2==0) // unbounded, lazy
                .filter(e->Math.sqrt(e)>20) // unbounded, lazy
                .mapToInt(e->e*2) // unbounded, lazy
                .limit(n) // bounded, lazy
                .sum();
        /*
        int result=0;
        int index=k;
        int count=0;
        while (count<n) {
            if (index % 2 == 0 && Math.sqrt(index) > 20) {
                result += index * 2;
                ++count;
            }
            ++index;
        }
        return result;
        */
    }
}
