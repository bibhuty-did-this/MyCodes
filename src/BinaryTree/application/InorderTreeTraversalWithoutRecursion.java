package BinaryTree.application;

import java.util.Stack;

public class InorderTreeTraversalWithoutRecursion{
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	static Node root;
	static void printInorderTraversal(Node node){
		
		if(node==null) return;
		
		Stack<Node> stack=new Stack();
		stack.push(node);
		while(!stack.isEmpty()){
			Node current=stack.pop();
			while(current!=null){
				stack.push(current);
				current=current.left;
			}
			while(!stack.isEmpty()){
				Node now=stack.pop();
				System.out.print(now.data+" ");
				if(now.right!=null){
					stack.push(now.right);
					break;
				}
			}
		}
	}
	public static void main(String args[]){
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.left.right.right=new Node(6);
		printInorderTraversal(root);
	}
}