import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Code_1042B_Vitamins {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(in.nextToken());

        int A=Integer.MAX_VALUE,B=A,C=A,AB=A,BC=A,CA=A,ABC=A;
        while (n-->0){
            in=new StringTokenizer(br.readLine());
            int price=Integer.parseInt(in.nextToken());
            String vitamin=in.nextToken();
            if(vitamin.contains("A")){
                A=min(A,price);
            }
            if(vitamin.contains("B")){
                B=min(B,price);
            }
            if(vitamin.contains("C")){
                C=min(C,price);
            }
            if(vitamin.contains("A") && vitamin.contains("B")){
                AB=min(AB,price);
            }
            if(vitamin.contains("C") && vitamin.contains("B")){
                BC=min(BC,price);
            }
            if(vitamin.contains("A") && vitamin.contains("C")){
                CA=min(CA,price);
            }
            if(vitamin.contains("A") && vitamin.contains("B") && vitamin.contains("C")){
                ABC=min(ABC,price);
            }
        }
        if(A!=Integer.MAX_VALUE && B!=Integer.MAX_VALUE && C!=Integer.MAX_VALUE){
            int min=A+B+C;
            if(AB!=Integer.MAX_VALUE)min=min(min,AB+C);
            if(BC!=Integer.MAX_VALUE)min=min(min,A+BC);
            if(CA!=Integer.MAX_VALUE)min=min(min,CA+B);
            if(ABC!=Integer.MAX_VALUE)min=min(min,ABC);
            out.println(min);
        }else
            out.println(-1);

        out.close();
    }
}
