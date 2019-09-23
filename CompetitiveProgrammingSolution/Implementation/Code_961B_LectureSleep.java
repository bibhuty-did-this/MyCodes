package _current_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Code_961B_LectureSleep{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(in.nextToken()),k=Integer.parseInt(in.nextToken());
		int[] a=new int[n];
		in=new StringTokenizer(br.readLine());
		for(int i=0;i<n;++i)
			a[i]=Integer.parseInt(in.nextToken());
		int[] t=new int[n];
		in=new StringTokenizer(br.readLine());
		for(int i=0;i<n;++i)
			t[i]=Integer.parseInt(in.nextToken());
		int[] interval=new int[n-k+1];
		for(int i=0;i<k;++i)
			interval[0]+=(t[i]==0?a[i]:0);
		int max=interval[0];
		for(int i=1;i<interval.length;++i){
			interval[i]=(interval[i-1]-(t[i-1]==0?a[i-1]:0)+(t[k+(i-1)]==0?a[k+(i-1)]:0));
			max=max(max,interval[i]);
		}
		int sum=0;
		for(int i=0;i<n;++i)
			sum+=(t[i]==1?a[i]:0);
		out.println(sum+max);
		out.close();
	}
}
