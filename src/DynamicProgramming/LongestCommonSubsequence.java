package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongestCommonSubsequence{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in;

		in=new StringTokenizer(br.readLine());
		int testCases=Integer.parseInt(in.nextToken());
		while (testCases-->0){
			in=new StringTokenizer(br.readLine());
			in=new StringTokenizer(br.readLine());
			String str1=new String(in.nextToken());
			in=new StringTokenizer(br.readLine());
			String str2=new String(in.nextToken());
			//debug(n,m,str1,str2);
			out.println(longestCommonSubsequence(str1,str2));
		}

		out.close();
	}
	public static void debug(Object...objects){
		for(Object object:objects)
			System.out.print(object.toString()+" ");
		System.out.println();
	}
	public static int longestCommonSubsequence(String str1,String str2){
		int max=0,n= str1.length(),m=str2.length();
		int[][] dp=new int[n+1][m+1];
		for(int i=1;i<=n;++i)
			for(int j=1;j<=m;++j)
				dp[i][j]=str1.charAt(i-1)==str2.charAt(j-1)?1+dp[i-1][j-1]:Math.max(dp[i-1][j],dp[i][j-1]);
		return dp[n][m];
	}
}

