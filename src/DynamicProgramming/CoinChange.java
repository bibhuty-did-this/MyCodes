package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CoinChange{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer in = new StringTokenizer(br.readLine());

		int testCases = Integer.parseInt(in.nextToken());
		while(testCases-->0){
			in = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(in.nextToken());
			in = new StringTokenizer(br.readLine());
			int[] change=new int[n];
			for(int i = 0 ; i < n ; ++i)change[i] = Integer.parseInt(in.nextToken());
			in = new StringTokenizer(br.readLine());
			int coin = Integer.parseInt(in.nextToken());
			int[] dp = new int[coin+1];
			/*

			-- This solution gives all the combination of different permutations also

			for(int i = 1; i <= coin; ++i){
				for(int j = 0; j < n; ++j){
					if(i - change[j]==0)
						dp[i] += 1;
					else if(i - change[j] > 0 && dp[i - change[j]]>0)
						dp[i] += dp[i-change[j]];
					else continue;
				}
			}
			*/
			dp[0]=1;
			for(int i=0;i<n;++i){
				for(int j=change[i];j<=coin;++j)
					dp[j]+=dp[j-change[i]];
			}
			out.println(coinChange(change,n,coin));

		}

		out.close();
	}
	public static int coinChange(int change[],int n,int amount){
		int[][] dp=new int[amount+1][n];
		for(int i=0;i<n;++i)
			dp[0][i]=1;

		for(int i=1;i<=amount;++i){
			for(int j=0;j<n;++j){
				int includingChange=i-change[j]>=0?dp[i-change[j]][j]:0;
				int excludingChange=j>0?dp[i][j-1]:0;
				dp[i][j]=includingChange+excludingChange;
			}
		}
		return dp[amount][n-1];
	}
}
