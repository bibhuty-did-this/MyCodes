package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CatalanNumber{
	public static void main(String...strings) throws IOException{
		PrintWriter out=new PrintWriter(System.out);
		int n=Integer.parseInt(new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine()).nextToken());
		int[] catalanNumber=new int[n+1];
		catalanNumber[0]=1;
		
		// Its all about knowing the formula of Catalan Number, rest is simple DP
		for(int i=1;i<=n;++i){
			for(int j=0;j<=i-1;++j){
				catalanNumber[i]+=catalanNumber[j]*catalanNumber[i-1-j];
			}
		}
		
		out.print(catalanNumber[n]);
		out.close();
	}
}