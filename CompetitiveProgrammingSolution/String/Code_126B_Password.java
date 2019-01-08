import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Code_126B_Password {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(br.readLine());
        String password=in.nextToken();

        int n=password.length();
        int[] lps=new int[n];

        int len=0,i=1;
        while (i<n){
            if(password.charAt(i)==password.charAt(len)) {
                lps[i++] = ++len;
            }else{
                if(len!=0)
                    len=lps[len-1];
                else lps[i++]=len;
            }
        }
        int length=lps[n-1];
        if (length != 0) {
            for(int j=1;j<n-1;++j) {
                if (lps[j] == length && length!=0) {
                    out.println(password.substring(0, length));
                    out.close();
                    return;
                }
            }
            length=lps[length-1];
            if(length!=0){
                for(int j=1;j<n-1;++j) {
                    if (lps[j] == length && length!=0) {
                        out.println(password.substring(0, length));
                        out.close();
                        return;
                    }
                }
            }
        }
        out.println("Just a legend");
        out.close();
    }
}
