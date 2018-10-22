package _current_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class LongestPalindromicSubsequence{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());

		int testCases=Integer.parseInt(in.nextToken());
		while(testCases-->0){
			String string=new StringTokenizer(br.readLine()).nextToken();
			out.println(LPS(string,0,string.length()));
		}

		out.close();
	}

	public static int LPS(String s,int start,int end){

		int length=s.length();
		int[][] dp=new int[length+1][length+1];

		for(int i=1;i<=length;++i){
			for(int j=1;j<=i;++j){
				dp[i][j]=s.charAt(i-1)==s.charAt(j-1)?2+dp[i-1][j-1]:max(dp[i][j-1],dp[i-1][j]);
			}
		}
		return dp[length][length];
	}

	public static int LPS_Recursive(String s,int start,int end){

		// Base case 1: If there is only one character then by default
		// it'll match so we need to return 1
		if(start==end)return 1;


		// Base case 2: If there are only 2 characters and they match then
		// we need to return 2
		if(start+1==end && s.charAt(start)==s.charAt(end))return 2;

		// If the 2 characters from the beginning and the end match then
		// the length of the longest palindromic subsequence will be sum
		// of the maximum longest palindromic subsequence without the matched
		// character added with 2(for including the current case)
		if(s.charAt(start)==s.charAt(end))
			return LPS_Recursive(s,start+1,end-1)+2;

		// If none of the character match then there could be 2 cases:
		// 1. It may match to the previous character from the en
		// 2. The next character may match to the end character
		// We need to take the maximum of both the cases to obtain the answer
		return max(LPS_Recursive(s,start+1,end),LPS_Recursive(s,start,end-1));
	}
}
