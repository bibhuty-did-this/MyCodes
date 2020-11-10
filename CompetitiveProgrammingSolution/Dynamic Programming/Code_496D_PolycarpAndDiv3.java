import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Code_496D_PolycarpAndDiv3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in=new StringTokenizer(reader.readLine());
        PrintWriter out=new PrintWriter(System.out);
        char[] input=in.nextToken().toCharArray();
        int n=input.length;
        int[] num=new int[n];
        int[] dp=new int[n+1];
        for(int i=0;i<n;++i)num[i]=(input[i]-'0')%3;
        for(int i=1;i<=n;++i){
            dp[i]=dp[i-1];
            if(num[i-1]%3==0)dp[i]=max(dp[i],dp[i-1]+1);
            else if(i-2>=0 && (num[i-1]+num[i-2])%3==0)dp[i]=max(dp[i],dp[i-2]+1);
            else if(i-3>=0 && (num[i-1]+num[i-2]+num[i-3])%3==0)dp[i]=max(dp[i],dp[i-3]+1);
        }
        out.println(dp[n]);
        out.flush();
        out.close();
    }
}
