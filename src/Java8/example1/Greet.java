package Java8.example1;

public class Greet{
	public void greet(){
		System.out.println("Hello World");
	}

	public void greet(Greeting greeting){
		greeting.perform();
	}

	public static void main(String[] args){

		// Creation of class to associate some behaviour with it
		Greet greet=new Greet();

		// It is thing and noun rather than action and verb
		// We can't do this in isolation, it needs to be associated with a class
		// as of functionality of Java 7 are concerned.
		greet.greet();


		// The thing containing the particular behaviour.
		// Here we have a class that implemented the interface and the logic is in the
		// class unlike what is found in a lambda expression.
		HelloWorldGreeting helloWorldGreeting=new HelloWorldGreeting();

		// Passing in the behaviour and execute the behaviour(using Java 7 functionality)
		// Here we are not exactly passing a behaviour rather we are passing a thing that
		// contains the behaviour.
		greet.greet(helloWorldGreeting);

		// Doing it the lambda way by passing the direct action(function which doesn't belong
		// to a class, kind of we do in a node.js way)
		// The best thing about lambda an action can be passed as a value
		// Also for lambda to work, our interface needs to contain a single method
		// or else the compiler will be confused what method to match it with
		// Also here we are directly calling a function in line which is assigned to the
		// function of the interface unlike a class, where we need to create a class,
		// implement an interface and call the class to implement the function of it
		Greeting greetingFunction=()->System.out.println("Hello World");
		greet.greet(greetingFunction);

		// lambda expression is in a way of writing anonymous inner class but it is
		// whole lot of a different thing when implementation is concerned.
		Greeting greeting=new Greeting(){
			@Override
			public void perform(){
				System.out.println("Hello World");
			}
		};
		greet.greet(greeting);
	}
}
/*
interface GreetingFunction{
	void greetingFunction();// could be any name say `foo`
}
*/