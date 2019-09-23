import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Code_603A_AlternativeThinking{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(in.nextToken());
		in=new StringTokenizer(br.readLine());
		String s=in.nextToken();
		int res=1;
		for(int i=1;i<n;++i)
			if(s.charAt(i)!=s.charAt(i-1))
				++res;
		out.print(min(res+2,n));
		out.close();
	}
}
