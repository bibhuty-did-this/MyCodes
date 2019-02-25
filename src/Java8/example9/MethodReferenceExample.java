package Java8.example9;

public class MethodReferenceExample{
	public static void main(String[] args){
		// ()->printMessage()
		// (p)->printMessage(p)
		// This 2 structures can be replaced with method reference
		Thread thread=new Thread(MethodReferenceExample::printMessage);
		thread.start();
	}
	public static void printMessage(){
		System.out.println("Hello");
	}



}
