package Java8.DevoxxAndOracleDevelopers.GetATasteOfLambdasAndGetAddicted2Streams.codes;

import Java8.DevoxxAndOracleDevelopers.ProgrammmingWithStreams.example.Gender;
import Java8.DevoxxAndOracleDevelopers.ProgrammmingWithStreams.example.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EfficiencyOfStreamsExample {
    public static List<Person> createPeople(){
        return Arrays.asList(
                new Person("Sara", Gender.FEMALE,20),
                new Person("Sara",Gender.FEMALE,22),
                new Person("Zara",Gender.FEMALE,22),
                new Person("Bob",Gender.MALE,20),
                new Person("Paula",Gender.FEMALE,32),
                new Person("Paul",Gender.MALE,32),
                new Person("Jack",Gender.MALE,22),
                new Person("Jack",Gender.MALE,32),
                new Person("Jack",Gender.TRANS,44),
                new Person("Jill",Gender.FEMALE,12),
                new Person("Jill",Gender.TRANS,17)
        );
    }

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
        System.out.println("Result from functional or declarative type: "+
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
