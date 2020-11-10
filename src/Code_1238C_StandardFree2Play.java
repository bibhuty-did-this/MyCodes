import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Code_1238C_StandardFree2Play {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(reader.readLine());

        int q=Integer.parseInt(in.nextToken());
        while (q-- > 0){
            in=new StringTokenizer(reader.readLine());
            int h=Integer.parseInt(in.nextToken()),n=Integer.parseInt(in.nextToken());
            int[] p=new int[n];
            in=new StringTokenizer(reader.readLine());
            for(int i=0;i<n;++i)p[i]=Integer.parseInt(in.nextToken());


        }
        out.flush();
        out.close();
    }
}
