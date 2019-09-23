package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;
public class KadanesAlgorithm{
	public static int kadanesAlgorithm(int[] array){
		int n=array.length;
		int currentMax=array[0];
		int cumulativeMax=array[0];
		for(int i=1;i<n;++i){
			currentMax=max(currentMax+array[i],array[i]);
			cumulativeMax=max(cumulativeMax,currentMax);
		}
		return cumulativeMax;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int testCases=Integer.parseInt(in.nextToken());
		while(testCases-->0){
			in=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(in.nextToken());
			int[] a=new int[n];
			in=new StringTokenizer(br.readLine());
			for(int i=0;i<n;++i)
				a[i]=Integer.parseInt(in.nextToken());
			out.println(kadanesAlgorithm(a));
		}
		out.close();
	}
}
