import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Code_998B_Cutting{

	static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(in.nextToken()),B=Integer.parseInt(in.nextToken());
		in=new StringTokenizer(br.readLine());
		int[] a=new int[n];
		ArrayList<Integer> costs=new ArrayList<>();
		int balance=0;
		for(int i=0;i<n;++i){
			a[i]=Integer.parseInt(in.nextToken());
			if(balance==0 && i!=0)
				costs.add(Math.abs(a[i]-a[i-1]));
			if(a[i]%2==0)++balance;
			else --balance;
		}
		int size=costs.size();
		int[] cost=new int[size];
		for(int i=0;i<size;++i)
			cost[i]=costs.get(i);

		dp=new int[size+1][B+1];
		for(int i=0;i<=size;++i)
			for(int j=0;j<=B;++j)
				dp[i][j]=-1;

		out.println(solve(0,size,cost,B));
		out.close();
	}
	public static int solve(int i,int n,int[] cost,int B){
		if(dp[i][B]==-1){
			if(i>=n || B==0)
				dp[i][B]=0;
			else if(cost[i]>B)
				dp[i][B]=solve(i+1,n,cost,B);
			else
				dp[i][B]=max(solve(i+1,n,cost,B),1+solve(i+1,n,cost,B-cost[i]));
		}
		return dp[i][B];
	}
}
