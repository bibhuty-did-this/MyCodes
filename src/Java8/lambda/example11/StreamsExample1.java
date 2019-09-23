package Java8.lambda.example11;

import java.util.Arrays;
import java.util.List;

public class StreamsExample1{
	public static void main(String[] args){
		List<Person> people=Arrays.asList(
				new Person("Charles","Dickens",45),
				new Person("Lewis","Caroll",42),
				new Person("Thomas","Carlyle",52),
				new Person("Charlotte","Bronte",45),
				new Person("Matthew","Arnold",39)
		);

		// stream -- as of assembly line
		// parallelStream enable multiprocessing
		// stream has 3 parts:
		//      1. source(mostly a collection)
		//      2. operations needs to be performed(say `filter`)
		//      3. terminal operation(say `forEach`)
		people.stream()
				.filter(p->p.getLastName().startsWith("C")) // filter with this condition
				.forEach(p->System.out.println(p.getLastName())); // for each element of the stream after filtering loop


		long count=people.stream()
				.filter(p->p.getLastName().startsWith("C"))
				.count();
		System.out.println(count);
	}
}
