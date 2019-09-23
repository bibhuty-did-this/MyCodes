package DynamicProgramming;

import static java.lang.Math.max;
public class RodCuttingProblem{
	public static int rodCuttingProblem(int price[]){
		int n=price.length;
		int[] dp=new int[n+1];
		// For each length find the optimal length of all
		// the lengths below it
		for(int length=1;length<=n;++length)
			for(int bLength=1;bLength<=length;++bLength)
				dp[length]=max(dp[length],price[bLength-1]+dp[length-bLength]);
		return dp[n];
	}
	public static void main(String[] args){
		int price[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(rodCuttingProblem(price));
	}
	public static int _rodCuttingProblem_(int price[],int n){
		// If no length is remaining then return zero cost
		if(n<=0)return 0;

		// Variable to store the result
		int result=Integer.MIN_VALUE;

		// For all the possible cuts of the remaining rod find the
		// maximum obtainable value and then return the final result
		// Also as the index starts from 0 so the length remaining of the
		// rod could be given as (n-1)-i
		for(int i=0;i<n;++i)
			result=max(result,price[i]+_rodCuttingProblem_(price,n-1-i));
		return result;
	}
}
