package Java8.lambda.example8;

public class ThisReferenceExample{
	public static void main(String[] args){
		ThisReferenceExample thisReferenceExample=new ThisReferenceExample();
		thisReferenceExample.doProcess(11,new Process(){
			@Override
			public void process(int i){
				System.out.println("Value of i is "+i);
				// Here passing this doesn't shows an error because
				// `this` refers to the reference of anonymous inner
				// class. It overrides the `this` reference of the outer
				// class.
				System.out.println("Inside anonymous inner class "+this);
			}

			@Override
			public String toString(){
				return "\nThis is anonymous inner class";
			}
		});

		thisReferenceExample.doProcess(12,i -> {
			System.out.println("Value of i is "+i);

			// In case of lambda it doesn't touch the instance of
			// `this` reference. The `this` reference is same as
			// it would be that of outside lambda.
			// System.out.println(this); // Throw an error
		});

		thisReferenceExample.execute();
	}
	public void doProcess(int i,Process p){
		p.process(i);
	}

	public void execute(){
		doProcess(10,i -> {
			System.out.println("Inside execute");
			System.out.println("Value of i is "+i);
			System.out.println(this);
		});
	}

	@Override
	public String toString(){
		return "Main reference class";
	}
}
interface Process{
	void process(int i);
}