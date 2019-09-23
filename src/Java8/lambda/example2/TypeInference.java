package Java8.lambda.example2;

public class TypeInference{
	public static void main(String[] args){

		// The compiler basically takes the lambda expression and searches
		// for the similar kind of expression in that interface and tries
		// to match it, this is called type inference in lambdas.
		// This matching is done in both parameter level and also the return
		// type level, which in turn helps us not defining stuffs like int,
		// char, etc. etc. while writing a lambda expression.
		StringLength stringLength=s->s.length();
		System.out.println(stringLength.getLength("Hello World"));

		printStringLength(s->s.length());
	}

	public static void printStringLength(StringLength stringLength){
		System.out.println(stringLength.getLength("Hello World"));
	}


	interface StringLength{
		int getLength(String s);
	}
}
