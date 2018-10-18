package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BinomialCoefficient{

	static int MOD=1000000000+7;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int testCase=Integer.parseInt(in.nextToken());
		while(testCase-->0){
			in=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(in.nextToken()),k=Integer.parseInt(in.nextToken());
			out.println(binomialCoefficient(n,k));
		}
		out.close();
	}

	/**
	 * (n k)=(n-1 k-1)+(n-1 k)
	 * (n 0)=(n n)=1
	 */
	public static int binomialCoefficient(int n,int k){
		int[][] nCk=new int[n+1][k+1];
		for(int N=0;N<=n;++N)
			for(int K=0;K<=min(N,k);++K)
				nCk[N][K]=(K==0||N==K)?1:(nCk[N-1][K]%MOD+nCk[N-1][K-1]%MOD)%MOD;

		return nCk[n][k];
	}
	public static int min(int a,int b){
		return Math.min(a,b);
	}

	public static int binomialCoefficientWithPascalsTriangle(int n,int k){
		return 0;
	}
}

