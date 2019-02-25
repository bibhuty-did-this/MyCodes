package Java.TypesOfClasses;

public class SingletonClass{

	public static void main(String[] args){
		// It'll call the same instance all the time
		Thread thread1=new Thread(new Runnable(){
			@Override
			public void run(){
				Singleton singleton1=Singleton.getInstance();
			}
		});
		Thread thread2=new Thread(new Runnable(){
			@Override
			public void run(){
				Singleton singleton2=Singleton.getInstance();
			}
		});
		thread1.start();

		thread2.start();

		// Best way of creating singleton instance
		SingletonBest singletonBest1=SingletonBest.INSTANCE;
		singletonBest1.i=1;
		singletonBest1.show();
		SingletonBest singletonBest2=SingletonBest.INSTANCE;
		singletonBest2.i=2;
		singletonBest1.show();
	}
}
class Singleton{
	/*
	static Singleton singleton=new Singleton(); // Eager initialization
	*/
	static Singleton singleton;
	// Can't create the object
	private Singleton(){
		System.out.println("Instance created");
	}

	// public static synchronized Singleton getInstance(){ // Reduce the performance by 100 folds
	public static Singleton getInstance(){

		// Lazy initialization
		if(singleton==null){
			// Double check locking singleton pattern
			synchronized(Singleton.class){
				if(singleton==null)
					singleton=new Singleton();
			}
		}
		return singleton;
	}
}
enum SingletonBest{
	INSTANCE;
	int i;
	public void show(){
		System.out.println(i);
	}
}