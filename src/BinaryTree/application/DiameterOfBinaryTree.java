package BinaryTree.application;

public class DiameterOfBinaryTree{
	
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	static Node root;
	
	static int diameter(Node node){
		
		if(node==null)return 0;
		
		int leftHeight=height(node.left);
		int rightHeight=height(node.right);
		
		int leftDiameter=diameter(node.left);
		int rightDiameter=diameter(node.right);
		
		return Math.max(1+leftHeight+rightHeight,Math.max(leftDiameter,rightDiameter));
	}
	
	static int height(Node node){
		return node!=null ? 1 + Math.max(height(node.left),height(node.right)) : 0;
	}
	
	static int diameter(){
		return diameter(root);
	}
	
	public static void main(String args[]){
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		
		System.out.println("The diameter of the tree is " + diameter());
	}
}
