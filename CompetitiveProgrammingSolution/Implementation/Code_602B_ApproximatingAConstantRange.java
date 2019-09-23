import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Code_602B_ApproximatingAConstantRange {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(in.nextToken());
        int[] a=new int[n];
        in=new StringTokenizer(br.readLine());
        for(int i=0;i<n;a[i++]=Integer.parseInt(in.nextToken()));
        int l=0,r=0;
        int length=1,largest=a[l],smallest=a[r];
        while (l<=r && r<n){
            largest=max(largest,a[r]);
            smallest=min(smallest,a[r]);
            if(largest-smallest<=1) {
                length = max(length, r - l + 1);
                ++r;
            }else{
                l=r-1;
                int value=a[l];
                while (l>0 && a[l-1]==value)--l;
                smallest=min(a[l],a[r]);
                largest=max(a[l],a[r]);
            }
        }

        out.println(length);
        out.close();
    }
}
