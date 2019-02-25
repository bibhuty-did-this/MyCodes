package Java8.example7;

public class ClosureExample{
	public static void main(String[] args){
		int a=10;
		int b=20;
		doProcess(a,i->{
			// The compiler trusts us by assuming that the variable
			// `b` is effectively final but in case we change it,
			// it'll throw an error.

			// b=10; // Uncommenting it will throw an error
			System.out.println(i+b);
		});
	}
	public static void doProcess(int i,Process p){
		p.process(i);
	}

}
interface Process{
	void process(int i);
}