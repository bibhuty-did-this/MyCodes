package Heap.application;

public class CheckIfABinaryTreeIsHeap{

	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			left=right=null;
		}
	}

	static Node root;

	static boolean isHeapUtil(Node node){
		if(node.left==null && node.right==null)
			return true;

		if(node.left==null)
			return (node.right.data<=node.data) && isHeapUtil(node.right);

		if(node.right==null)
			return (node.left.data<=node.data) && isHeapUtil(node.left);

		return (node.right.data<=node.data) &&
				(node.left.data<=node.data) &&
				isHeapUtil(node.right) &&
				isHeapUtil(node.left);
	}

	static int countNodes(Node node){
		return node==null?0:1+countNodes(node.left)+countNodes(node.right);
	}

	static boolean isCompleteTree(Node node,int index,int numberOfNodes){

		if(node==null)
			return true;

		if(index>=numberOfNodes)
			return false;

		return isCompleteTree(node.left,2*index+1,numberOfNodes) &&
				isCompleteTree(node.right,2*index+2,numberOfNodes);
	}

	static boolean isHeap(){
		int numberOfNodes=countNodes(root);
		return isHeapUtil(root) && isCompleteTree(root,0,numberOfNodes);
	}


	public static void main(String[] args){

		root = new Node(10);
		root.left = new Node(9);
		root.right = new Node(8);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(2);
		root.left.right.left = new Node(1);

		if(isHeap())
			System.out.println("Given binary tree is a Heap");
		else
			System.out.println("Given binary tree is not a Heap");
	}
}
