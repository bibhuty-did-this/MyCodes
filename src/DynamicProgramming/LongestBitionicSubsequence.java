package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class LongestBitionicSubsequence{
	public static int longestBitionicSubsequence(int array[]){
		int n=array.length;
		int[] lis=new int[n];
		Arrays.fill(lis,1);
		for(int i=1;i<n;++i)
			for(int j=0;j<i;++j)
				if(array[i]>array[j])
					lis[i]=max(lis[i],1+lis[j]);
		int[] lds=new int[n];
		Arrays.fill(lds,1);
		for(int i=n-2;i>=0;--i)
			for(int j=n-1;j>i;--j)
				if(array[i]>array[j])
					lds[i]=max(lds[i],1+lds[j]);
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<n;++i)
			ans=max(ans,lis[i]+lds[i]-1);
		return ans;
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
			out.println(longestBitionicSubsequence(array));
		}
		out.close();
	}
}
