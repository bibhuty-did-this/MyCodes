import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Code_607A_ChainReaction {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer in=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(in.nextToken());
	    int[] ab=new int[1000001];
	    for(int i=0;i<n;++i){
		    in=new StringTokenizer(br.readLine());
		    ab[Integer.parseInt(in.nextToken())]=Integer.parseInt(in.nextToken());
	    }
        int[] activated=new int[1000001];
        int[] destroyed=new int[1000001];

        // base case
        activated[0]=ab[0]!=0?1:0;

        int max=activated[0];

        for(int i=1;i<=1000000;++i){
        	if(ab[i]==0){
        		activated[i]=activated[i-1];
        		destroyed[i]=destroyed[i-1];
	        }else{
        		int x=i-ab[i];
        		if(x<0){
        			activated[i]=1;
        			destroyed[i]=activated[i-1];
		        }else{
        			if(ab[x]==0){
        				activated[i]=1+activated[x];
        				destroyed[i]=activated[i-1];
			        }else{
        				activated[i]=1+destroyed[x];
        				destroyed[i]=activated[i-1];
			        }
		        }
	        }
	        max=Math.max(max,activated[i]);
        }
		out.println(n-max);
        out.close();
    }
}
