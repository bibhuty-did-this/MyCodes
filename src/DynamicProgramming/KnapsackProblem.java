package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import static java.lang.Math.max;

public class KnapsackProblem{ 

	static int solveKnapsackProblem(int W,int weight[],int values[],int n){
		
		//memorization table
		int[][] dp=new int[n+1][W+1];
		
		/*
			For each weight you have 2 options either take that weight or 
			calculate the optimal solution without taking that weight. So,
			at each step first we see if we can take that weight. If we can 
			then we find the best among 2 solutions namely, the solution taking
			into consideration of the weight and the solution without taking into
			consideration of the weight.
		*/
		for(int i=0;i<=n;++i){
			for(int w=0;w<=W;++w){
				// If there is no item available or no space is there in knapsack then
				// nothing could be done
				if(i==0 || w==0)
					dp[i][w]=0;
				// If the given weight of the item can't be kept inside the knapsack then
				// it is better to discard the item and take whatever items are available
				// excluding that item
				else if(weight[i-1]>w)
					dp[i][w]=dp[i-1][w];
				// If we are including that item into the knapsack then one of the 2
				// cases could occur:
				//  1. We are taking that item: Take the value of the item and the
				//                              maximum value could be obtained excluding
				//                              that item & including all the item till that
				//								point
				//  2. We are not taking that item: Take the optimal value obtained till that item
				else
					dp[i][w]=max(dp[i-1][w],
							     values[i-1]+dp[i-1][w-weight[i-1]]);
			}
		}
		return dp[n][W];
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		
		int testCases=Integer.parseInt(in.nextToken());
		while(testCases-->0){
			int n=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			int W=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			int[] weight=new int[n];
			int[] values=new int[n];
			in=new StringTokenizer(br.readLine());
			for(int i=0;i<n;++i)
				values[i]=Integer.parseInt(in.nextToken());
			in=new StringTokenizer(br.readLine());
			for(int i=0;i<n;++i)
				weight[i]=Integer.parseInt(in.nextToken());
			
			out.println(solveKnapsackProblem(W,weight,values,n));
		}
		
		out.close();
	}
	
	static int _solveKnapsackProblem_(int W,int weight[],int values[],int n){
		// When we have no weight to consider or no elements to consider then 
		// we can't take any values
		if(W==0 || n==0)
			return 0;
		
		// If the weight of the knapsack we are taking is more than the capacity
		// then there is no way we can take that one with us, so we have to skip 
		// it and move forward.
		if(weight[n-1]>W)
			return _solveKnapsackProblem_(W,weight,values,n-1);
		// If there is a possiblity of taking those weights then there are 2 
		// possiblities, i) we are including that weight for the optimal solution; or
		// ii) we are calculating the optimal solution without including the weight.
		// The optimal solution will be the best of both the scenarios
		else 
			return  max(values[n-1]+_solveKnapsackProblem_(W-weight[n-1],weight,values,n-1),
							 _solveKnapsackProblem_(W,weight,values,n-1));
	} 
}