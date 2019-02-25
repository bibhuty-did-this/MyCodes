import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

	public static void main(String args[])  throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int numberOfDays = Integer.parseInt(in.nextToken());
		Deque<String> deque=new ArrayDeque<>();
		int FAT=0,CARB=0,FIBER=0;
		in=new StringTokenizer(br.readLine());
		for (int i = 0; i < numberOfDays; i++) {
			String ingredientId = in.nextToken();
			if(ingredientId.startsWith("FAT"))++FAT;
			else if(ingredientId.startsWith("CARB"))++CARB;
			else if(ingredientId.startsWith("FIBER"))++FIBER;
			deque.add(ingredientId);
			if(deque.size()==1 || deque.size()==2 || (deque.size()==3 && (CARB==1 && FAT==1 && FIBER==1)))
				out.print("-");
			else if(deque.size()==3){
				FAT=0;
				CARB=0;
				FIBER=0;
				out.print(deque.pollFirst()+":"+deque.pollFirst()+":"+deque.pollFirst());
			}else if(deque.size()==4){
				String first=deque.pollFirst();
				String second=deque.pollFirst();
				String third=deque.pollFirst();
				String fourth=deque.pollFirst();
				String vitamin=null;
				if(fourth.startsWith("FAT"))vitamin="FAT";
				else if(fourth.startsWith("CARB"))vitamin="CARB";
				else if(fourth.startsWith("FIBER"))vitamin="FIBER";
				if(first.startsWith(vitamin) || second.startsWith(vitamin)){
					out.print(first+":"+second+":"+fourth);
					FAT=0;
					CARB=0;
					FIBER=0;
					deque.addFirst(third);
					if(third.startsWith("FAT"))++FAT;
					else if(third.startsWith("CARB"))++CARB;
					else if(third.startsWith("FIBER"))++FIBER;
				}else if(third.startsWith(vitamin)){
					out.print(first+":"+third+":"+fourth);
					FAT=0;
					CARB=0;
					FIBER=0;
					deque.addFirst(second);
					if(second.startsWith("FAT"))++FAT;
					else if(second.startsWith("CARB"))++CARB;
					else if(second.startsWith("FIBER"))++FIBER;
				}
			}
		}
		out.close();
	}
}
