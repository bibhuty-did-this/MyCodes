import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Code_2B_TheLeastRoundWay {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(reader.readLine());

        int n=Integer.parseInt(in.nextToken());
        int[][][] matrix=new int[n][n][2];
        int[][][] zeroes=new int[n][n][2];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                in=new StringTokenizer(reader.readLine());
                int num=Integer.parseInt(in.nextToken());
                int twos=0;
                int fives=0;
                while (num%2==0){
                    num/=2;
                    ++twos;
                }
                while (num%5==0){
                    num/=5;
                    ++fives;
                }
                matrix[i][j][0]=twos;
                matrix[i][j][1]=fives;

                zeroes[i][j][0]=Integer.MAX_VALUE;
                zeroes[i][j][0]=Integer.MAX_VALUE;
            }
        }

        String[][] path=new String[n][n];

        zeroes[0][0][0]=matrix[0][0][0];
        zeroes[0][0][1]=matrix[0][0][1];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(i-1>=0){
                    
                }
                if(j-1>=0){

                }
            }
        }

        out.close();
    }
}
