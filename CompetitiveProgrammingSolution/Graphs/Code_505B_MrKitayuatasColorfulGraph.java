import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Code_505B_MrKitayuatasColorfulGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(reader.readLine());
        int n=Integer.parseInt(in.nextToken()),m=Integer.parseInt(in.nextToken());
        int[][][] graph=new int[n][n][m];
        for(int i=0;i<m;++i){
            in=new StringTokenizer(reader.readLine());
            int x=Integer.parseInt(in.nextToken())-1,y=Integer.parseInt(in.nextToken())-1,c=Integer.parseInt(in.nextToken())-1;
            graph[x][y][c]=1;
            graph[y][x][c]=1;
        }
        in=new StringTokenizer(reader.readLine());
        int q=Integer.parseInt(in.nextToken());
        while(q-->0){
            in=new StringTokenizer(reader.readLine());
            int u=Integer.parseInt(in.nextToken())-1,v=Integer.parseInt(in.nextToken())-1;
            int total=0;
            for(int c=0;c<m;++c){
                boolean[] isVisited=new boolean[n];
                Queue<Integer> queue=new ArrayDeque<>();
                queue.add(u);
                while(!queue.isEmpty()){
                    int x=queue.poll();
                    isVisited[x]=true;
                    if(x==v){
                        ++total;
                        break;
                    }
                    for(int y=0;y<n;++y){
                        if(!isVisited[y] && graph[x][y][c]==1)queue.add(y);
                    }
                }
            }
            System.out.println(total);
        }
        out.close();
    }
}
