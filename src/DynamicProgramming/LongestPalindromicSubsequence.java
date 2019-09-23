package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class LongestPalindromicSubsequence{

	public static int longestPalindromicSubsequence(String s){
		int n=s.length();
		int[][] dp=new int[n][n];
		for(int i=0;i<n;++i)
			dp[i][i]=1;
		for(int c=2;c<=n;++c){
			for(int i=0;i<n-c+1;++i){
				int j=i+c-1;
				if(s.charAt(i)==s.charAt(j) && c==2)
					dp[i][j]=2;
				else if(s.charAt(i)==s.charAt(j))
					dp[i][j]=2+dp[i+1][j-1];
				else
					dp[i][j]=max(dp[i][j-1],dp[i+1][j]);
			}
		}
		return dp[0][n-1];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int testCases=Integer.parseInt(in.nextToken());
		while(testCases-->0){
			in=new StringTokenizer(br.readLine());
			String s=in.nextToken().trim();
			//out.println(s);
			//out.println(_longestPalindromicSubsequence_(s,0,s.length()-1));
			out.println(longestPalindromicSubsequence(s));
		}
		out.close();
	}
	public static int _longestPalindromicSubsequence_(String s,int start,int end){

		// If the start and end points are at the same character it is a palindrome
		if(start==end)
			return 1;
		// If the starting character is just the previous one of the end and they
		// match then we have a palindrome of length 2
		if(s.charAt(start)==s.charAt(end) && start+1==end)
			return 2;
		// If both the start and the end characters match then we need to find the
		// maximum palindrome by including the start and the end character
		if(s.charAt(start)==s.charAt(end))
			return 2+_longestPalindromicSubsequence_(s,start+1,end-1);

		// If none of the character match then it is better to find all the possible
		// subsequence.
		return max(_longestPalindromicSubsequence_(s,start+1,end),
				   _longestPalindromicSubsequence_(s,start,end-1));
	}
}
