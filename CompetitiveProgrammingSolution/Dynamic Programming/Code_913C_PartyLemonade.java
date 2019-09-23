import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Code_913C_PartyLemonade{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(in.nextToken());
		long L=Long.parseLong(in.nextToken());
		long[] c=new long[n];
		in=new StringTokenizer(br.readLine());
		for(int i=0;i<n;++i)
			c[i]=Long.parseLong(in.nextToken());
		for(int i=1;i<n;++i){
			if(c[i]>2*c[i-1])
				c[i]=c[i-1]*2;
		}
		long l=L;
		long cost=0;
		long ans=Long.MAX_VALUE;
		for(int i=n-1;i>=0 && l>0;--i){
			long cap=pow(2,i);
			cost+=(l/cap)*c[i];
			ans=min(ans,cost+(l%cap==0?0:c[i]));
			l%=cap;
		}
		out.println(ans);
		out.close();

	}
	static long pow(long x,long n){
		if(n==0)
			return 1;
		else if(n%2==0)
			return pow(x*x,n/2);
		else return x*pow(x*x,n/2);
	}
}
