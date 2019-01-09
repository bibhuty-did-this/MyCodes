package PassByReference;

public class PassByValueAndPassByReference{
	public static void main(String args[]){
		/*
		int number=25;
		System.out.println("Before 'display' function is called number is "+number);
		display(number);
		System.out.println("After 'display' function is called number is "+number);
		*/
		/*
		int value[]={1,2,3,4,5};
		System.out.println("Before calling the function the array is");
		for(int values:value)
			System.out.print(values+" ");
		display(value);
		System.out.println("After calling the function the array is");
		for(int values:value)
			System.out.print(values+" ");
		System.out.println();
		*/
		String s1="Bibhuti",s2="Panda";
		System.out.println("Before swapping the strings "+s1+" "+s2);
		swap(s1,s2);
		System.out.println("After swapping the strings "+s1+" "+s2);
	}

	private static void swap(String s1,String s2){
	}

	/**
		When we use primitive type along with String also then java typically acts as a pass
		 by value as it simply copies the original value of the parameter to another memory
		location and simply uses it for the operation.
	*/
	public static void display(int num){
		System.out.println("Before modification the number is "+num);
		num=100;
		System.out.println("After modification the number is "+num);
	}
	
	/**
		When we pass non-primitive data type as method then it is passed by 
		reference. 
	*/
	public static void display(int[] values){
		System.out.println("\nInside the function and before changing the array");
		for(int value:values)
			System.out.print(value+" ");
		int n=values.length;
		for(int i=0;i<n;++i)
			values[i]*=-1;
		System.out.println("\nInside the function and after changing the array");
		for(int value:values)
			System.out.print(value+" ");
		
		//It'll not have any effect on the final result because when we do it another
		//memory location is allocated to it which will not change the original memory location
		values=new int[n];
		System.out.println();
	}
}