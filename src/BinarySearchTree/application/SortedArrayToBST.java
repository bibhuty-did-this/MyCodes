package BinarySearchTree.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Time complexity:O(n)
public class SortedArrayToBST{
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			left=right=null;
		}
	}

	static Node root;

	public static Node insert(Node node,int data){
		if(node==null)
			return new Node(data);
		else if(node.data>data)
			node.left=insert(node.left,data);
		else if(node.data<data)
			node.right=insert(node.right,data);
		return node;
	}

	public static void insert(int data){
		root=insert(root,data);
	}

	public static Node sortedArrayToBST(int array[],int start,int end){

		if(start>end)
			return null;

		int mid=(start+end)/2;
		Node node=new Node(array[mid]);
		node.left=sortedArrayToBST(array,start,mid-1);
		node.right=sortedArrayToBST(array,mid+1,end);
		return node;
	}

	public static void sortedArrayToBST(int array[]){
		root=sortedArrayToBST(array,0,array.length-1);
	}

	public static void preOrder(Node node){
		if(node==null)
			return;

		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int testCases=Integer.parseInt(in.nextToken());
		while(testCases-->0){
			in=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(in.nextToken());
			int[] array=new int[n];
			in=new StringTokenizer(br.readLine());
			for(int i=0;i<n;array[i++]=Integer.parseInt(in.nextToken()));
			sortedArrayToBST(array);
			preOrder(root);
			System.out.println();
		}
		out.close();

	}
}
