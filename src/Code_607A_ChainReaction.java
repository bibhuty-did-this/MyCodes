import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Code_607A_ChainReaction {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(in.nextToken());
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;++i){
            in=new StringTokenizer(br.readLine());
            a[i]=Integer.parseInt(in.nextToken());
            b[i]=Integer.parseInt(in.nextToken());
        }


        out.close();
    }
}
