import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Code_533A_KyoyaAndColoredBalls {
    public static void main(String[] args) throws IOException {
        int[][] nCr=new int[1001][1001];
        int MOD=1000000007;
        for(int n=0;n<=1000;++n) {
            for (int r = 0; r <= n; ++r) {
                nCr[n][r] = (r == 0 || r == n ? 1 : (nCr[n - 1][r - 1] + nCr[n - 1][r]) % MOD);
            }
        }
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(in.nextToken());
        long result=1;
        int total=0;
        // Put stuffs in the gaps obtained by color with lower index than previous
        // one. Also include the permutation of the gaps.
        for(int i=1;i<=t;++i){
            in=new StringTokenizer(br.readLine());
            int color=Integer.parseInt(in.nextToken());
            // Permutation of the previous gaps * total number of current combinations = new Permutation
            result=(result*nCr[total+color-1][color-1])%MOD;
            total+=color;
        }
        out.println(result);
        out.close();
    }
}
