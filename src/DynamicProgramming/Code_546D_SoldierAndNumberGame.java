package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Code_546D_SoldierAndNumberGame{
	public static void main(String[] args) throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());

		long[] primeCount=new long[5000005];
		long[] sumCount=new long[5000005];
		outer:
		for(int i=2;i<=5000000;++i){
			if(i%2==0){
				primeCount[i]=1+primeCount[i/2];
				sumCount[i]=primeCount[i]+sumCount[i-1];
			}else {
				int limit=(int)Math.sqrt(i);
				int num=i;
				for(int j=3;j<=limit;j+=2){
					if(num%j==0){
						primeCount[i]=1+primeCount[i/j];
						sumCount[i]=primeCount[i]+sumCount[i-1];
						continue outer;
					}
				}
				primeCount[i]=1;
				sumCount[i]=primeCount[i]+sumCount[i-1];
			}
		}
		int t=Integer.parseInt(in.nextToken());
		while(t-->0){
			in=new StringTokenizer(br.readLine());
			out.println(sumCount[Integer.parseInt(in.nextToken())]-sumCount[Integer.parseInt(in.nextToken())]);
		}
		out.close();
	}
}
