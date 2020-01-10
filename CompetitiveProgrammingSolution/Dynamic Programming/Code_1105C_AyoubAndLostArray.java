import java.io.PrintWriter;
import java.util.Scanner;

public class Code_1105C_AyoubAndLostArray {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int n=in.nextInt();
        long l=in.nextLong(),r=in.nextLong();
        long MOD= (long) (1e9+7);
        int[] count=new int[3];
        if(l<=r) count[(int) (l % 3)] = (int) (r - l) / 3 + 1;
        if(l+1<=r) count[(int)((l+1)%3)] = (int)(r-(l+1))/3+1;
        if(l+2<=r) count[(int)((l+2)%3)] = (int)(r-(l+2))/3+1;
        long[][] dp=new long[n][3];
        dp[0][0]=count[0];
        dp[0][1]=count[1];
        dp[0][2]=count[2];
        for(int i=1;i<n;++i){
            dp[i][0]=dp[i-1][0]%MOD*count[0]%MOD+dp[i-1][1]%MOD*count[2]%MOD+dp[i-1][2]%MOD*count[1]%MOD;
            dp[i][1]=dp[i-1][0]%MOD*count[1]%MOD+dp[i-1][1]%MOD*count[0]%MOD+dp[i-1][2]%MOD*count[2]%MOD;
            dp[i][2]=dp[i-1][0]%MOD*count[2]%MOD+dp[i-1][1]%MOD*count[1]%MOD+dp[i-1][2]%MOD*count[0]%MOD;
        }
        System.out.println(dp[n-1][0]%MOD);
        out.close();
    }
}
