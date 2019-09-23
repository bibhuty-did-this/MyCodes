package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MatrixChainMultiplication{

	static int matrixChainMultiplication(int matrix[]){
		int n=matrix.length; //length of the matrix

		/*
			It is the table for memorization for overlapping sub-problem property.
			Also, minimumCost[i][j] stands for minimum cost for multiplication of
			the matrix chain starting from matrix A[i] and ending at A[j] where,
			'i' starts from 1 and the max value of j is 'n-1' as there are only
			'n-1' matrices and also always i<j;
		 */
		int[][] minimumCost=new int[n][n];

		/*
			The index starts from 1 because the dimension of a matrix
			is 2X2 and for matrix A[i] the dim(A[i])=matrix[i-1]*matrix[i]
		 */
		for(int i=1;i<n;++i)
			minimumCost[i][i]=0;

		/*
			Here 'l' defines total permissible matrix to be taken in the
			iteration. 'l' traverses from 2 to n-1 because there are only
			n-1 matrices(not n matrices)
		 */
		for(int l=2;l<n;++l){
			/*
				Here 'i' starts from the first matrix and traverses up to that
				matrix where total of 'l' elements are present in continuation
				after the matrix including the current matrix. So, total of
				'l-1' matrices are permissible after a given matrix. So total
				number of such matrix possible is n-l((n-1)-(l-1))
			 */
			for(int i=1;i<=n-l;++i){
				/*
					As for permissible length 'l' you can traverse only maximum of
					'l' elements including the current matrix, therefore maximum index
					of the matrix permissible after matrix 'i' is 'j' which is given
					as 'i + (l-1)'. Note: -1 is there because we are including the current
					matrix.
				 */
				int j=i+l-1;

				/*
					The aim of the loop is to make all possible partitions into 2 halves
					for the group of matrix and find the minimum possible chain for the
					multiplication purpose.

					Also it is to be noted that 'i' is traversing from 'i' to 'j-1' not
					'j' because if it'll traverse from 'i' to 'j' then we'll cover the case
					which will provide out-of-bound exception.

					'k': It is the variable which tells around which matrix we are partitioning
				 */
				minimumCost[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;++k){
					int costOfCurrentPartition=minimumCost[i][k]+minimumCost[k+1][j]+matrix[i-1]*matrix[k]*matrix[j];
					minimumCost[i][j]=Math.min(minimumCost[i][j],costOfCurrentPartition);
				}
			}
		}
		return minimumCost[1][n-1];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int testCases=Integer.parseInt(in.nextToken());
		while(testCases-->0){
			int n=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			int[] matrix=new int[n];
			in=new StringTokenizer(br.readLine());
			for(int i=0;i<n;++i)
				matrix[i]=Integer.parseInt(in.nextToken());
			out.println(matrixChainMultiplication(matrix));
		}

		out.close();
	}

	//It will take exponential time to be solved as many sub-problems are overlapping
	static int matrixChainMultiplication(int matrix[],int startBlock,int endBlock){

		//Impossible case for a matrix
		if(startBlock==endBlock)
			return 0;

		int minimum=Integer.MAX_VALUE;

		/**
		 * Break the matrix into 2 parts in all possible way and recursively
		 * compute the solutions to all the parts and return the minimum from it.
		 */
		for(int _startBlock_=startBlock;_startBlock_<endBlock;++_startBlock_){
			int newEndBlock=_startBlock_;
			int newStartBlock=_startBlock_+1;
			int count=matrixChainMultiplication(matrix,startBlock,newEndBlock)+
					  matrixChainMultiplication(matrix,newStartBlock,endBlock)+
					  matrix[startBlock-1]*matrix[newEndBlock]*matrix[endBlock];

			if(minimum>count)
				minimum=count;
		}

		//Return minimum count
		return minimum;
	}
}
