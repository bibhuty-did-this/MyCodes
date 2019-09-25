package Java8.DevoxxAndOracleDevelopers.GetATasteOfLambdasAndGetAddicted2Streams.codes;

import java.util.Arrays;
import java.util.List;

public class LambdaSample {
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
                .map(LambdaSample::mutate) // static method
                .map(String::toString) // instance method
                .forEach(new LambdaSample()::print); // parameter as an argument

        System.out.println();

        // two parameter as arguments
        System.out.println("Sum of all the numbers is "+
                numbers.stream()
                        .reduce(0,Integer::sum)
        );;

        // two parameters, one as target and another as argument
        numbers.stream()
                .map(String::valueOf)
                .reduce("",String::concat);

        // function composition
        //      - composition in series of operations
        //      - also called pipeline
        /*
        imperative(not declarative) way in unclean to do the same, you have to go back
        and forth again and again, but here it is concise, more readable and clean
         */
        System.out.println("Given a collection, double the even numbers and find sum: "+
                        numbers.stream()
                                .filter(LambdaSample::isEven)
                                .mapToInt(LambdaSample::compute)
                                .sum()
                );

        // Parallelizing streams
        TimeIt.code(() ->
                 numbers.stream()
                        .filter(LambdaSample::isEven)
                        .mapToInt(LambdaSample::compute)
                        .sum()
        );
        TimeIt.code(() ->
                numbers.parallelStream()
                        .filter(LambdaSample::isEven)
                        .mapToInt(LambdaSample::compute)
                        .sum()
        );
    }

    private static String mutate(Integer integer) {
        return integer.toString()+" ";
    }

    private void print(String s){
        System.out.print(s);
    }

    public static int compute(int number){
        return number*2;
    }

    private static boolean isEven(int num){
        return num%2==0;
    }

}

class TimeIt{
    public static void code(Runnable block){
        long start=System.nanoTime();
        try {
            block.run();
        }finally {
            long end=System.nanoTime();
            System.out.println("Time taken by the program to execute is "+(end-start)/1.0e9);
        }
    }
}