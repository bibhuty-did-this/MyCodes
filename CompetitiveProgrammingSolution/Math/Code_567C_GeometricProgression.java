import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Code_567C_GeometricProgression{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(in.nextToken()),k=Integer.parseInt(in.nextToken());
		in=new StringTokenizer(br.readLine());
		long[] a=new long[n];
		HashMap<Long,Long> L=new HashMap<>();
		HashMap<Long,Long> R=new HashMap<>();
		for(int i=0;i<n;++i){
			a[i]=Long.parseLong(in.nextToken());
			L.put(a[i],0l);
			R.put(a[i],0l);
		}
		for(int i=0;i<n;++i)
			R.put(a[i],1+R.get(a[i]));


		long ans=0;
		for(int i=0;i<n;++i){
			R.put(a[i],R.get(a[i])-1l);
			if(a[i]%k==0){
				if(L.containsKey(a[i]/k) && R.containsKey(a[i]*k)){
					ans+=(L.get(a[i]/k)*R.get(a[i]*k));
				}
			}
			L.put(a[i],L.get(a[i])+1l);
		}
		out.println(ans);
		out.close();
	}
}
