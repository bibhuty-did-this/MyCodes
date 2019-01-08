package PatternMatchingAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongestPrefixWhichIsAlsoAProperSuffix{
	public static int longestPrefixWhichIsAlsoAProperSuffix(String s){

		// Stores the length of the string
		int n=s.length();

		// It stores the length of the longest prefix till that point which is
		// also the suffix.
		int[] lps=new int[n];

		// Base Case: No prefix exist which is also a suffix if there is only
		//            a single string
		lps[0]=0;

		// Start from the first character of the given string
		int i=1;

		// By default there is no match, so length of the longest prefix which
		// is also the suffix is 0.
		int len=0;

		// Iterate over the entire string step by step starting from the character
		// with index 1
		while(i<n){

			// If you find a match store the length of the string matched till
			// point and go for the next character in both the pattern as well
			// as the original string
			if(s.charAt(i)==s.charAt(len)){
				++len;
				lps[i]=len;
				++i;
			}

			// If there is no match then find the length of the suffix
			// of previous's previous match and try to find a match to
			// the current point. In this way we are saving time by hopping
			// only to the required points where we can find the matches.
			// EX: abbabcabbabb(how to find the lps of the last character)
			else{
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
