import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Code_870C_MaximumSplitting {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(br.readLine());
        int q=Integer.parseInt(in.nextToken());
        while (q-->0){
            in=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(in.nextToken());
            if(n%2==0 && n!=2){
                if(n%4==0)
                    out.println(n/4);
                else
                    out.println((n-6)/4+1);
            }else{
                if(n==1 || n==2 || n==3 || n==5 || n==7 || n==11)
                    out.println(-1);
                else{
                    n-=9;
                    if(n%4==0)
                        out.println(n/4 + 1);
                    else out.println((n-6)/4 + 2);
                }
            }
        }
        out.close();
    }
}
