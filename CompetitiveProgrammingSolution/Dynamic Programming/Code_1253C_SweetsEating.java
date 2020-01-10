import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_1253C_SweetsEating {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(reader.readLine());
        int n=Integer.parseInt(in.nextToken()),m=Integer.parseInt(in.nextToken());
        int[] a=new int[n];
        in=new StringTokenizer(reader.readLine());
        for(int i=0;i<n;++i)a[i]=Integer.parseInt(in.nextToken());
        Arrays.sort(a);
        long[] sum=new long[n];
        sum[0]=a[0];
        for(int i=1;i<n;++i)sum[i]=sum[i-1]+a[i];
        long[] penalty=new long[n+1];
        for(int k=1;k<=n;++k){
            if(k<m){
                penalty[k]=penalty[k-1]+a[k-1];
            }else{
                penalty[k]=sum[k-1]+penalty[k-m];
            }
        }
        for(int i=1;i<=n;++i)
            System.out.print(penalty[i]+" ");
        out.close();
    }
}
