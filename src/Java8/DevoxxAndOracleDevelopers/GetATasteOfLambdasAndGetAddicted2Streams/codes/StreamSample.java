package Java8.DevoxxAndOracleDevelopers.GetATasteOfLambdasAndGetAddicted2Streams.codes;

import Java8.DevoxxAndOracleDevelopers.ProgrammmingWithStreams.example.Gender;
import Java8.DevoxxAndOracleDevelopers.ProgrammmingWithStreams.example.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamSample {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Examples to reduce
        System.out.println(
                numbers.stream()
                        .filter(number->number%2==0)
                        .map(number->number*2.0)
                        .reduce(0.0,(carry,number)->carry+number)
        );

        System.out.println(
                numbers.stream()
                        .filter(number->number%2==0)
                        .mapToDouble(number->number*2.0)
                        .sum()
        );

        // collect example
        List<Integer> devilsWork=new ArrayList<>();
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .forEach(number->devilsWork.add(number));
        System.out.println("mutability is OK, sharing is nice, shared mutability is devil's work: "+devilsWork);

        // to list
        List<Integer> integerList = numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .collect(Collectors.toList());
        System.out.println(integerList);

        // to map
        List<Person> people=createPeople();
        Map<String, Person> peopleMap = people.stream()
                .collect(Collectors.toMap(
                        person -> person.getName() + ":" + person.getAge(),
                        person -> person
                ));

        // grouping by
        System.out.println("Grouping by names and getting the exact data without any changes: "+
                    people
                        .stream()
                        .collect(Collectors.groupingBy(Person::getName))
        );

        System.out.println(
                    people
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getName,
                                        Collectors.mapping(Person::getAge,Collectors.toList())
                                ))
        );

    }
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
}
