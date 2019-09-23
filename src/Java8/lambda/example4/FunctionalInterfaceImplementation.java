package Java8.lambda.example4;

public class FunctionalInterfaceImplementation{
	public static void main(String[] args){
		Interface interfac=s->System.out.println(s.length());
		interfac.print("Hello");
	}

	@FunctionalInterface
	interface Interface{
		public void print(String s);
	}
}
