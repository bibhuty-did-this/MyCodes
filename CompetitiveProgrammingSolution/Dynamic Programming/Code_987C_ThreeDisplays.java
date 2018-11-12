import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


import static java.lang.Math.min;

public class Code_987C_ThreeDisplays{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(in.nextToken());
		in=new StringTokenizer(br.readLine());
		long[] s=new long[n];
		for(int i=0;i<n;++i)s[i]=Long.parseLong(in.nextToken());
		in=new StringTokenizer(br.readLine());
		long[][] cost=new long[n][3];
		for(int i=0;i<n;++i){
			cost[i][0]=Long.parseLong(in.nextToken());
			cost[i][1]=Long.MAX_VALUE;
			cost[i][2]=Long.MAX_VALUE;
		}

		// b -- before
		for(int b=1;b<=2;++b)
			for(int j=0;j<n;++j)
				for(int k=0;k<j;++k)
					if(s[k]<s[j] && cost[k][b-1]!=Long.MAX_VALUE)
						cost[j][b]=min(cost[j][b],cost[j][0]+cost[k][b-1]);
		long ans=Long.MAX_VALUE;
		for(int i=0;i<n;++i)
			ans=min(ans,cost[i][2]);
		out.print(ans==Long.MAX_VALUE?-1:ans);
		out.close();
	}
}
