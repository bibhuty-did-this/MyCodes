import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Code_1215B_TheNumberOfProducts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(reader.readLine());
        int n=Integer.parseInt(in.nextToken());
        int[] a=new int[n];
        in=new StringTokenizer(reader.readLine());
        for(int i=0;i<n;++i) a[i] = Integer.parseInt(in.nextToken()) > 0 ? 1 : -1;
        long positiveInclusion=a[0]==1?1:0;
        long negativeInclusion=positiveInclusion==1?0:1;
        long positivePairs=positiveInclusion;
        long negativePairs=negativeInclusion;
        for(int i=1;i<n;++i){
            if(a[i]==1){
                positiveInclusion++;
            }else{
                long temp=negativeInclusion;
                negativeInclusion=positiveInclusion+1;
                positiveInclusion=temp;
            }
            positivePairs+=positiveInclusion;
            negativePairs+=negativeInclusion;
        }
        System.out.print(negativePairs+" "+positivePairs);
        out.close();
    }
}