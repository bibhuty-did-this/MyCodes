package BinaryTree.application;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstTraversal{
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	static Node root;
	
	//Breadth First Traversal or Level Order Traversal
	public static void breadthFirstTraversal(Node node){
		System.out.println("The breadth first traversal or level order traversal of the tree is");
		Queue<Node> queue=new ArrayDeque();
		queue.add(node);
		while(!queue.isEmpty()){
			
			Node current=queue.poll();
			print(current.data);
			if(current.left!=null)
				queue.add(current.left);
			if(current.right!=null)
				queue.add(current.right);
		}
	}
	
	public static void main(String args[]){
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		
		breadthFirstTraversal(root);
	}
	
	public static void print(int data){
		System.out.print(data+" ");
	}
}