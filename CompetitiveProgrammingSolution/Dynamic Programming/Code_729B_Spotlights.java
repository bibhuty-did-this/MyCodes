import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Code_729B_Spotlights {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(reader.readLine());
        int n=Integer.parseInt(in.nextToken()),m=Integer.parseInt(in.nextToken());
        int[][] stage=new int[n][m];
        for(int i=0;i<n;++i){
            in=new StringTokenizer(reader.readLine());
            for(int j=0;j<m;++j){
                stage[i][j]=Integer.parseInt(in.nextToken());
            }
        }
        int[][][] position=new int[n][m][4];// 0-l,1-r,2-u,3-d
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j){
                if(stage[i][j]==1)continue;
                position[i][j][0]=1+(j==0?0:position[i][j-1][0]);
            }
        }
        for(int i=0;i<n;++i) {
            for(int j=m-1;j>=0;--j){
                if(stage[i][j]==1)continue;
                position[i][j][1]=1+(j==m-1?0:position[i][j+1][1]);
            }
        }
        for(int j=0;j<m;++j){
            for(int i=0;i<n;++i){
                if(stage[i][j]==1)continue;
                position[i][j][2]=1+(i==0?0:position[i-1][j][2]);
            }
        }
        for(int j=0;j<m;++j){
            for(int i=n-1;i>=0;--i){
                if(stage[i][j]==1)continue;
                position[i][j][3]=1+(i==n-1?0:position[i+1][j][3]);
            }
        }
        /*for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                for(int k=0;k<=3;++k){
                    System.out.print(k+"->"+position[i][j][k]+" ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }*/
        int total=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(stage[i][j]==1){
                    int currentCount=0;
                    if(j>0)currentCount+=position[i][j-1][0];
                    if(j<m-1)currentCount+=position[i][j+1][1];
                    if(i>0)currentCount+=position[i-1][j][2];
                    if(i<n-1)currentCount+=position[i+1][j][3];
                    // System.out.println(i+" "+j+" "+currentCount);
                    total+=currentCount;
                }
            }
        }
        System.out.println(total);
        out.close();
    }
}
