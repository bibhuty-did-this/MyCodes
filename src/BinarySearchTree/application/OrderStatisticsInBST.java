package BinarySearchTree.application;

public class OrderStatisticsInBST{

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

	// Find the kth element in the inorder traversal
	static int index,inorder[];
	public static void inorder(Node node){
		if(node==null)
			return;
		inorder(node.left);
		inorder[++index]=node.data;
		inorder(node.right);
	}

	public static int kthOrderStatistics(int k){
		index=0;
		inorder=new int[1000];
		inorder(root);
		return inorder[k];
	}
	public static void main(String[] args){
		OrderStatisticsInBST tree=new OrderStatisticsInBST();

		// Insertion of data
		// Creation of following BST
         /* Let us create following BST
              4
           /    \
          2      6
         / \    / \
       1    3  5   7
       */
		tree.insert(4);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(6);
		tree.insert(5);
		tree.insert(7);

		//Inorder traversal
		int kth=4;

		System.out.println("The "+kth+" order statistics is "+kthOrderStatistics(kth));
	}
}
