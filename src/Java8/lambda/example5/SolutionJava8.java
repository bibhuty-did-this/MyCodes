package Java8.lambda.example5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SolutionJava8{
	public static void main(String[] args){
		List<Person> people=Arrays.asList(
				new Person("Charles","Dickens",45),
				new Person("Lewis","Caroll",42),
				new Person("Thomas","Carlyle",52),
				new Person("Charlotte","Bronte",45),
				new Person("Matthew","Arnold",39)
		);
		// Sort list by last name
		// Collections.sort(people,((o1,o2) -> o1.getLastName().compareTo(o2.getLastName())));
		Collections.sort(people,(Comparator.comparing(Person::getLastName)));


		// Printing all the elements in the list
		System.out.println("Printing the list of all the persons");
		performConditionally(people,p->true,System.out::println); // (p)->methdo(p)

		// Create a method that prints the person whose name starts with 'C'
		System.out.println("\nPrinting all the person with name starting with 'C'");
		performConditionally(people,p->p.getFirstName().startsWith("C"),p->System.out.println(p.getFirstName()));
	}

	private static void performConditionally(List<Person> people,Predicate<Person> condition,Consumer<Person> consumer){
		for(Person p:people)
			if(condition.test(p))
				consumer.accept(p);
	}
}