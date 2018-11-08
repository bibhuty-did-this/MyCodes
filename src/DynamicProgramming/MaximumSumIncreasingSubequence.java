package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class MaximumSumIncreasingSubequence{
	// For each and every point find the value of all the maximum
	// increasing sum for points before it
	public static int maximumSumIncreasingSubsequence(int array[]){
		int n=array.length;
		int[] dp=new int[n];
		for(int i=0;i<n;++i)
			dp[i]=array[i];
		for(int i=1;i<n;++i)
			for(int j=0;j<i;++j)
				if(array[j]<array[i])
					dp[i]=max(dp[i],array[i]+dp[j]);


		int result=0;
		for(int i=0;i<n;++i)
			result=max(result,dp[i]);
		return result;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int testCases=Integer.parseInt(in.nextToken());
		while(testCases-->0){
			in=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(in.nextToken());
			int[] array=new int[n];
			in=new StringTokenizer(br.readLine());
			for(int i=0;i<n;++i)
				array[i]=Integer.parseInt(in.nextToken());
			out.println(maximumSumIncreasingSubsequence(array));
		}
		out.close();
	}

}
