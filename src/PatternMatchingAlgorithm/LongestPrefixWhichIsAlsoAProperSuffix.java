package PatternMatchingAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongestPrefixWhichIsAlsoAProperSuffix{
	public static int longestPrefixWhichIsAlsoAProperSuffix(String s){
		int n=s.length();
		int[] lps=new int[n];
		lps[0]=0;
		int i=1,len=0;
		while(i<n){
			if(s.charAt(i)==s.charAt(len)){
				++len;
				lps[i]=len;
				++i;
			}else{
				if(len!=0){
					len=lps[len-1];
				}else{
					lps[i]=len;
					++i;
				}
			}
		}
		return lps[n-1];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int testCase=Integer.parseInt(in.nextToken());
		while(testCase-->0){
			in=new StringTokenizer(br.readLine());
			String s=in.nextToken();
			out.println(longestPrefixWhichIsAlsoAProperSuffix(s));
		}
		out.close();
	}
}
