package BinaryTree.application;

public class DepthFirstTraversal{
		static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	static Node root;
	
	
	//Depth First Traversal includes Inorder, Preorder and Postorder traversals
	public static void depthFirstTraversal(Node node){
		System.out.println("DEPTH FIRST TRAVERSAL");
		System.out.println("The inorder traversal of the tree is:");
		inorder(node);
		System.out.println("The preorder traversal of the tree is:");
		preorder(node);
		System.out.println("The postorder traversal of the tree is:");
		postorder(node);
	}
	
	//Inorder traversal(left,root,right)
	public static void inorder(Node node){
		
		if(node==null)return;
		
		inorder(node.left);
		print(node.data);
		inorder(node.right);
	}
	
	//Predorder traversal(root,left,right)
	public static void preorder(Node node){
		
		if(node==null)return;
		
		print(node.data);
		preorder(node.left);
		preorder(node.right);
	}
	
	//Postorder traversal(left,right,node)
	public static void postorder(Node node){
		if(node==null)return;
		
		postorder(node.left);
		postorder(node.right);
		print(node.data);
	}
	
	public static void main(String args[]){
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		
		depthFirstTraversal(root);
	}
	
	public static void print(int data){
		System.out.print(data+" ");
	}
}