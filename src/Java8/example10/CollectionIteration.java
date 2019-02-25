package Java8.example10;

import java.util.Arrays;
import java.util.List;

public class CollectionIteration{
	public static void main(String[] args){
		List<Person> people=Arrays.asList(
				new Person("Charles","Dickens",45),
				new Person("Lewis","Caroll",42),
				new Person("Thomas","Carlyle",52),
				new Person("Charlotte","Bronte",45),
				new Person("Matthew","Arnold",39)
		);
		System.out.println("Printing all the elements using lambda");
		people.forEach(person ->System.out.print(person));

		System.out.println("\nPrinting all the elements using method reference");
		people.forEach(System.out::print);

	}
}
