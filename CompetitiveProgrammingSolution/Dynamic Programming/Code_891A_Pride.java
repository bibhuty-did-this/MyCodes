import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;


public class Code_891A_Pride{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(in.nextToken());
		int[] a=new int[n];
		in=new StringTokenizer(br.readLine());
		int[][] dp=new int[n][n];
		int ones=0;
		for(int i=0;i<n;++i){
			a[i]=Integer.parseInt(in.nextToken());
			dp[i][i]=a[i];
			if(dp[i][i]==1)
				++ones;
		}
		if(ones==0){
			int min=Integer.MAX_VALUE;
			for(int i=0;i<n-1;++i){
				for(int j=i+1;j<n;++j){
					dp[i][j]=gcd(dp[i][j-1],a[j]);
					//out.println(((i==j)?dp[i][j]:dp[i][j-1])+" "+a[j]+" "+dp[i][j]);
					if(dp[i][j]==1){
						min=min(min,j-i);
					}
				}
			}
			out.println(min==Integer.MAX_VALUE?-1:n-1+min);
		}else{
			out.println(n-ones);
		}

		out.close();
	}
	public static int gcd(int a,int b){
		return b==0?a:gcd(b,a%b);
	}
}
