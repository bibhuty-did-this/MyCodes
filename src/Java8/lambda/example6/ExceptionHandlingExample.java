package Java8.lambda.example6;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample{
	public static void main(String[] args){
		int[] someNumber={1,2,3,4,5};
		int key=0;
		process(someNumber,key,wrapperLambda((v,k)->System.out.println(v/k)));
	}

	private static void process(int[] someNumber,int key,BiConsumer<Integer,Integer> biConsumer){
		for(int i:someNumber){
			biConsumer.accept(i,key);
		}
	}
	private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer){
		return (v,k)->{
			try{
				consumer.accept(v,k);
			}catch(ArithmeticException ex){
				System.out.println("Exception caught in wrapper block");
			}
		};
	}
}
