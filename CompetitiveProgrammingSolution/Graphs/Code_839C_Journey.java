import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Code_839C_Journey {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(reader.readLine());
        int n=Integer.parseInt(in.nextToken());
        if(n==1){
            System.out.println(0);
            return;
        }
        Map<Integer, List<Integer>> path=new HashMap<>();
        for(int i=1;i<n;++i){
            in=new StringTokenizer(reader.readLine());
            int u=Integer.parseInt(in.nextToken()),v=Integer.parseInt(in.nextToken());
            path.putIfAbsent(u,new ArrayList<>());
            path.putIfAbsent(v,new ArrayList<>());
            List<Integer> uPaths=path.get(u);
            List<Integer> vPaths=path.get(v);
            uPaths.add(v);
            vPaths.add(u);
        }
        boolean isVisited[]=new boolean[n+1];
        isVisited[1]=true;
        System.out.println(expectedValue(1,path,isVisited,1));
        out.close();
    }

    private static float expectedValue(int city,Map<Integer, List<Integer>> path, boolean[] isVisited,float prob) {
        List<Integer> to = path.get(city);
        List<Integer> notVisited = to.stream().filter(i -> !isVisited[i]).collect(Collectors.toList());
        float aggregate=0f;
        notVisited.forEach(toCity-> isVisited[toCity]=true);
        int paths = notVisited.size();
        if(paths==0)return aggregate;
        float recentExpectation = prob / (float) paths;
//        System.out.println("Paths - "+paths+" Prob - "+prob+" recentExpectation "+recentExpectation);
        for (int toCity : notVisited) {
//            System.out.println("From "+city+" to "+toCity);
            aggregate += expectedValue(toCity, path, isVisited, recentExpectation);
        }
//        System.out.println(city+" -- "+aggregate+recentExpectation*paths);
        return aggregate+recentExpectation*paths;
    }
}
