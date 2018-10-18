package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UglyNumbers{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int n=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		
		// Array to store all the ugly number
		int[] uglyNumber=new int[n+1];
		
		// By convention first ugly number is always 1
		uglyNumber[0]=1;
		
		// Index to find the suitable multiple of 2,3,5 respectively
		// all currently pointing to the first index at the beginning 
		int i2,i3,i5;
		i2=i3=i5=0;
		
		// For each index the ugly number is a multiple of one of its multiple 
		// only, so inorder to find the convenient multiple we just need to find
		// the minimum multiple among all the possible multiple at the same step
		for(int i=1;i<=n;++i){
			int multipleOf2=uglyNumber[i2]*2;
			int multipleOf3=uglyNumber[i3]*3;
			int multipleOf5=uglyNumber[i5]*5;
			
			uglyNumber[i]=min(multipleOf2,multipleOf3,multipleOf5);
			
			if(multipleOf2==uglyNumber[i]) ++i2;
			if(multipleOf3==uglyNumber[i]) ++i3;
			if(multipleOf5==uglyNumber[i]) ++i5;	
		}
		
		// Print the ugly number
		out.print(uglyNumber[n]);
		
		out.close();
	}
	public static int min(int a,int b,int c){
		return Math.min(a,Math.min(b,c));
	}
}
