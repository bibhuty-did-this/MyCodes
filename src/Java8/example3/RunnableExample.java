package Java8.example3;

public class RunnableExample{
	public static void main(String[] args){
		Thread thread=new Thread(new Runnable(){
			@Override
			public void run(){
				System.out.println("Hello World");
			}
		});
		thread.run();

		Thread lambdaThread=new Thread(()->System.out.println("Lambda printed"));
		lambdaThread.run();
	}
}
