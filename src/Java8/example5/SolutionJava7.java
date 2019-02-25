package Java8.example5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SolutionJava7{
	public static void main(String[] args){
		List<Person> people=Arrays.asList(
				new Person("Charles","Dickens",45),
				new Person("Lewis","Caroll",42),
				new Person("Thomas","Carlyle",52),
				new Person("Charlotte","Bronte",45),
				new Person("Matthew","Arnold",39)
		);
		// Sort list by last name
		Collections.sort(people,new Comparator<Person>(){
			@Override
			public int compare(Person o1,Person o2){
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});

		// Printing all the elements in the list
		printAllPerson(people);

		// Create a method that prints the person whose name starts with 'C'
		System.out.println("Printing all the person with name starting with 'C'");
		printAllPersonsWithFirstNameStartingWithC(people);
	}

	private static void printAllPersonsWithFirstNameStartingWithC(List<Person> people){
		for(Person p:people)
			if(p.getFirstName().startsWith("C"))
				System.out.print(p);
	}

	private static void printAllPerson(List<Person> people){
		System.out.println(people);
	}
}