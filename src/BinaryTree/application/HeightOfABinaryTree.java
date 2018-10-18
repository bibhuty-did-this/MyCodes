package BinaryTree.application;

public class HeightOfABinaryTree{
	
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	static Node root;
	
	static int height(Node node){		
		return node==null ? 0 :1 + Math.max(height(node.left),height(node.right));
	}
	
	public static void main(String args[]){
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		
		System.out.println("The height of the binary tree is "+height(root));
	}
}