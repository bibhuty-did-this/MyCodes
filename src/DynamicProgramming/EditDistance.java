package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EditDistance{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer in = new StringTokenizer(br.readLine());
		int testCases=Integer.parseInt(in.nextToken());

		while(testCases-- > 0){
			in = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(in.nextToken()), n2 = Integer.parseInt(in.nextToken());
			in = new StringTokenizer(br.readLine());
			String str1 = in.nextToken().toString(), str2 = in.nextToken().toString();
			out.println(editDistance(str1,str2,n1,n2));
		}

		out.close();
	}

	public static int editDistance(String str1,String str2){
		int n1=str1.length();
		int n2=str2.length();
		int[][] dp=new int[n1+1][n2+1];
		for(int i=0;i<=n1;++i){
			for(int j=0;j<=n2;++j){
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j]=i;
				else if(str1.charAt(i-1)==str2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]=1+min(dp[i-1][j-1], // Replacement of one character
							       dp[i-1][j],   // Deletion of one character
							       dp[i][j-1]);  // Insertion of a new character(Similar to deletion at the end of other string)
			}
		}
		return dp[n1][n2];
	}

	//This function takes exponential time to solve this problem
	public static int editDistance(String str1,String str2, int n1,int n2){
		if(n1==0)return n2;
		if(n2==0)return n1;
		if(str1.charAt(n1-1)==str2.charAt(n2-1))return editDistance(str1,str2,n1-1,n2-1);


		return 1+min(editDistance(str1,str2,n1,n2-1),       //Insert
					 editDistance(str1,str2,n1-1,n2),       //Remove
				     editDistance(str1,str2,n1-1,n2-1));//Replace
	}
	public static int min(int n1,int n2,int n3){
		return Math.min(Math.min(n1,n2),n3);
	}
}
