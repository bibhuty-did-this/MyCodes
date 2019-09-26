package Java8.DevoxxAndOracleDevelopers.GetATasteOfLambdasAndGetAddicted2Streams.codes;

import java.util.ArrayList;
import java.util.List;

public class EfficiencyOfStreamsExample {

    public static void insertNumbers(List<Integer> numbers){
        for(int i=1;i<=20;++i)numbers.add(i);
    }

    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();
        insertNumbers(numbers);

        // given an ordered list find the double of first even number greater than 3
        int result=0;
        for(int number:numbers){
            if(number>3 && number%2==0){
                result=number*2;
                break;
            }
        }
        System.out.println("Result from imperative style: "+result);
        System.out.println("Result from functional or declarative type without terminal operation: "+
            numbers
                .stream()
                .filter(EfficiencyOfStreamsExample::isGreaterThan3)
                .filter(EfficiencyOfStreamsExample::isEven)
                .map(EfficiencyOfStreamsExample::doubleIt)
                //.findFirst()
        );
        System.out.println("Result from functional or declarative type(lazy evaluation): "+
            numbers
                .stream()
                .filter(EfficiencyOfStreamsExample::isGreaterThan3)
                .filter(EfficiencyOfStreamsExample::isEven)
                .map(EfficiencyOfStreamsExample::doubleIt)
                .findFirst()
        );
    }

    private static int doubleIt(int integer) {
        System.out.println("doubleIt: "+integer);
        return integer*2;
    }

    private static boolean isEven(int integer) {
        System.out.println("isEven: "+integer);
        return integer%2==0;
    }

    private static boolean isGreaterThan3(int integer) {
        System.out.println("isGreaterThan3: "+integer);
        return integer>3;
    }
}
