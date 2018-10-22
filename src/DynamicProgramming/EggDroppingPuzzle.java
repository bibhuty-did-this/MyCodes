package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class EggDroppingPuzzle{

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		
		int testCases=Integer.parseInt(in.nextToken());
		
		while(testCases-->0){
			in=new StringTokenizer(br.readLine());
			int eggs=Integer.parseInt(in.nextToken()),floors=Integer.parseInt(in.nextToken());
			out.println(eggDrop(floors,eggs));
		}
		
		out.close();
	}

	public static int eggDrop(int floors,int eggs){
		int[][] floors_eggs=new int[floors+1][eggs+1];


		// If there are 1 or 0 floors then we will need
		// 1 or 0 attempts respectively to check whether
		// the egg will break or not in worst case
		for(int i=1;i<=eggs;++i){
			floors_eggs[1][i]=1;
			floors_eggs[0][i]=0;

		}


		// If there's one egg, then in the worst case we
		// have to check each and every floor to know that
		// whether the egg is going to break or not
		for(int i=1;i<=floors;++i){
			floors_eggs[i][1]=i;
		}

		/**
		 * Start increasing number of eggs from 2 to the number of
		 * actual eggs present.
		 *
		 * For each eggs try the optimal result for each and every
		 * floor so as it can be used for the case for when egg breaks.
		 *
		 * For each and every floor if the egg doesn't break then the
		 * optimal solution is already calculated using the previous
		 * iterations.
		 */
		for(int i=2;i<=eggs;++i){
			for(int j=2;j<=floors;++j){
				floors_eggs[j][i]=Integer.MAX_VALUE;
				for(int k=1;k<=j;++k){
					int eggBreaks=floors_eggs[k-1][i-1];
					int noEggBreaks=floors_eggs[j-k][i];
					int result=1+max(eggBreaks,noEggBreaks);
					floors_eggs[j][i]=min(result,floors_eggs[j][i]);
				}
			}
		}

		return floors_eggs[floors][eggs];
	}

	public static int EggDropping(int floors,int eggs){
		if(floors==0 || floors==1) return floors;

		if(eggs==1) return floors;

		int minTrails=Integer.MAX_VALUE;
		for(int floor=1;floor<=floors;++floor){
			int result=max(EggDropping(floor-1,eggs-1),EggDropping(floors-floor,eggs));
			minTrails=min(minTrails,result);
		}

		return minTrails+1;
	}
}
