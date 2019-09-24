package Java8.DevoxxAndOracleDevelopers.GetATasteOfLambdasAndGetAddicted2Streams.codes;

import java.util.Arrays;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // external iterator
        for(int i=0;i<numbers.size();++i){
            System.out.print(numbers.get(i)+" ");
        }
        System.out.println();

        for(int i:numbers){
            System.out.print(i+" ");
        }

        System.out.println();

        // internal iterator
        // Java 8 has type inference, finally, but only for lambda expression
        numbers.stream()
                .map(Sample::mutate) // static method
                .map(String::toString) // instance method
                .forEach(new Sample()::print); // parameter as an argument

        System.out.println();

        // two parameter as arguments
        System.out.println("Sum of all the numbers is "+
                numbers.stream()
                        .reduce(0,Integer::sum)
        );;

        System.out.println();

        // two parameters, one as target and another as argument
        numbers.stream()
                .map(String::valueOf)
                .reduce("",String::concat);
    }

    private static String mutate(Integer integer) {
        return integer.toString()+" ";
    }

    private void print(String s){
        System.out.print(s);
    }


}
