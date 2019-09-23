package _current_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Code_118D_CaesarsLegion{
	static final int MOD=(int)1e8;
	static int[][][][] memory; // for 4-D DP solution
	static int[][][] store; // for 3-D DP solution
	static int K1,K2,n1,n2;
	static int dp(int n1,int n2,int k1,int k2){
		// Correct solution exists if and only if at last all the
		// soldiers could be arranged
		if(n1+n2==0)
			return 1;

		// If the solution is previously computed then return the solution
		if(memory[n1][n2][k1][k2]!=-1)
			return memory[n1][n2][k1][k2];

		// Find the possibility of solution when a horsemen or a footmen
		// is taken accordingly
		int go1=0,go2=0;

		// If footmen are available(n1) and we can take them(k1)
		// Reset the value of horsemen K2
		if(n1>0 && k1>0)
			go1=dp(n1-1,n2,k1-1,K2);
		// If horsemen are available(n2) and we can take them(k2)
		// Reset the value of footmen K1
		if(n2>0 && k2>0)
			go2=dp(n1,n2-1,K1,k2-1);

		// Not necessary always returns a positive integer
		// Can return 0 if we can't satisfy the condition
		return memory[n1][n2][k1][k2]=(go1%MOD+go2%MOD)%MOD;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		n1=Integer.parseInt(in.nextToken());
		n2=Integer.parseInt(in.nextToken());
		K1=Integer.parseInt(in.nextToken());
		K2=Integer.parseInt(in.nextToken());

		// 4-D DP
		memory = new int[n1 + 1][n2 + 1][K1 + 1][K2 + 1];
		for(int i = 0; i <= n1; ++i)
			for(int j = 0; j <= n2; ++j)
				for(int k = 0; k <= K1; ++k)
					Arrays.fill(memory[i][j][k], -1);
		//out.println(dp(n1,n2,K1,K2));

		// 3-D DP
		store= new int[n1+1][n2+1][2];
		for(int i = 0; i < n1+1; i++) {
			for(int j = 0; j < n2+1; j++) {
				store[i][j][0] = store[i][j][1] = -1;
			}
		}
		out.println((solve(n1,n2,0)+solve(n1,n2,1))%MOD);
		out.close();
	}
	// turn is 0 if footmen is taken
	// turn is 1 if horsemen is taken
	static int solve(int x,int y,int turn){

		// If we are in no position to take any footmen then
		// we need to have less than K2 horsemen to have a valid sequence
		if(x==0)
			return y>K2?0:1;

		// If we are in no position to take any horsemen then
		// we need to have less than K1 footmen to have a valid sequence
		if(y==0)
			return x>K1?0:1;

		// If we have the precomputed result then simply return the result
		if(store[x][y][turn]!=-1)
			return store[x][y][turn]%MOD;

		// If it is the turn of the footmen then take all the possibility
		// of footmen and following all possible horsemen after them and take
		// all the valid solutions(in case of else condition reverse horsemen
		// by footmen and vice-versa)
		int ways=0;
		if(turn==0){
			for(int i=1;i<=min(x,K1);++i){
				ways+=solve(x-i,y,1);
				ways%=MOD;
			}
		}else{
			for(int i=1;i<=min(y,K2);++i){
				ways+=solve(x,y-i,0);
				ways%=MOD;
			}

		}
		return store[x][y][turn]=ways%MOD;
	}
}
