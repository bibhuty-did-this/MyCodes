package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence{
	public static void main(String...strings){
		int array[]=new int[]{
				0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15
		};
		int[] length=new int[array.length];
		Arrays.fill(length,1);
		for(int i=0;i<array.length;++i)
			for(int j=0;j<i;++j)
				if(array[j]<array[i])
					length[i]=Math.max(length[i],length[j]+1);
		printMax(length);

	}
	public static void printMax(int array[]){
		int max=0;
		for(int num:array)max=Math.max(max,num);
		System.out.println(max);
	}
}

class LIS{
	static int max_length;


	//Utility function for the requirement
	public int _lis(int arr[],int n){

		if(n==1)return 1; //Boundary case

		int result; //to store the result from the iteration
		int maxEndingInThisIteration=1;//to store the max result of this iteration
		for(int i=1;i<n;++i){
			result=_lis(arr,i);//finding the result from the recursive iteration
			if(arr[i-1]<arr[n-1] && result+1>maxEndingInThisIteration) //finding if the criteria holds
				maxEndingInThisIteration=result+1;//if holds then try to find the max value of this iteration
		}

		max_length=Math.max(max_length,maxEndingInThisIteration);//find the max length of entire iteration

		return maxEndingInThisIteration;//return the max length of this iteration

	}

	//Main function for the requirement
	public int lis(int arr[],int n){
		max_length=1;
		_lis(arr,n);
		return max_length;
	}
}