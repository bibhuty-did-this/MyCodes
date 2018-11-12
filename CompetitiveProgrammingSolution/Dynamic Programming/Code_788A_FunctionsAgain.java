import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.abs;

public class Code_788A_FunctionsAgain {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(in.nextToken());
		in=new StringTokenizer(br.readLine());
		long[] a=new long[n];
		long[] odd=new long[n-1];
		long[] even=new long[n-1];
		a[0]=Long.parseLong(in.nextToken());
		for(int i=1;i<n;++i) {
			a[i] = Long.parseLong(in.nextToken());
			odd[i-1]=abs(a[i]-a[i-1])*(i%2==1?1:-1);
			even[i-1]=-odd[i-1];
		}
		out.println(max(solve(odd),solve(even)));
		out.close();
	}
	public static long solve(long[] a){
		long max=a[0],currentMax=a[0],n=a.length;
		for(int i=1;i<n;++i){
			currentMax=max(currentMax+a[i],a[i]);
			max=max(max,currentMax);
		}
		return max;
	}

}