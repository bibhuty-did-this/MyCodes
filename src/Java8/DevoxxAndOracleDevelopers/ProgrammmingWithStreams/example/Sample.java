package Java8.DevoxxAndOracleDevelopers.ProgrammmingWithStreams.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {
    public static List<Person> createPeople(){
        return Arrays.asList(
                new Person("Sara",Gender.FEMALE,20),
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

    public static void main(String[] args) {
        List<Person> people=createPeople();

        // Get in uppercase, the names of all females older than 18
        List<String> namesOfFemalesGreaterThan18 =
                people.stream()
                .filter(person -> person.getAge()>=18 && Gender.FEMALE.equals(person.getGender()))
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("namesOfFemalesGreaterThan18: "+namesOfFemalesGreaterThan18);

        // Print all the males
        people.stream()
                .filter(person -> Gender.MALE.equals(person.getGender()))
                .map(person -> new Person(person.getName().toUpperCase(),person.getGender(),person.getAge()))
                .forEach(System.out::println);

        // Total age of everybody
        System.out.println("Sum of everyone's age is: "+
                people.stream()
                        .map(Person::getAge)
                        .reduce(0,(totalAge,currentAge)->totalAge+currentAge)
        );
        System.out.println("Sum of everyone's age is: "+
                people.stream()
                        .map(Person::getAge)
                        .reduce(0,Integer::sum)
        );
        System.out.println("Sum of everyone's age is: "+
                people.stream()
                        .mapToInt(Person::getAge)
                        .sum()
        );

        // Oldest person in the collection
        System.out.println("The eldest person in the group is having the age "+
                people.stream()
                        .max(Comparator.comparingInt(Person::getAge))
                        .get()
                        .getAge()
        );

        // Count the number of non-adults
        System.out.println("The number of non-adults in the group is "+
                people.stream()
                        .filter(person -> person.getAge()<18)
                        .count()
        );

        // List all the adult names in upper case
        List<String> namesOfAdults=people.stream()
                .filter(person -> person.getAge()>=18)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(
                        ()->new ArrayList<>(),
                        (list,name)->list.add(name),
                        (list1,list2)->list1.addAll(list2)
                        // similar to collect(Collector.toList())
                );
        System.out.println("Names of all the adults are "+namesOfAdults);

        // Map of person's name:age and person object
        Map<String,Person> personMap=people.stream()
                .collect(Collectors.toMap(
                        person->person.getName()+":"+person.getAge(),
                        person -> person
                ));
        System.out.println("personMap: "+personMap);

        // Map of person's details grouped by its names
        Map<String,List<Person>> groupedPersonMap=people.stream()
                .collect(Collectors.groupingBy(Person::getName));
        groupedPersonMap.forEach((k,v)-> System.out.println(k+" -- "+v));

        // Find the first person whose name is four letters but is older than 25(lazy evaluation)
        System.out.println("First person whose name is 4 letters and older than 25 is "+
                people.stream()
                        .filter(Sample::is4Letters)
                        .filter(person -> person.getAge()>25)
                        .findFirst()
                        .get()
                        .getName()
        );

        // Infinite streams
        Stream.iterate(1, e->e+1)
                .filter(e->e%2==0)
                .limit(10)
                .forEach(System.out::println);
    }

    public static boolean is4Letters(Person person){
        System.out.println("Calling for Person: "+person);
        return person.getName().length()==4;
    }

}
