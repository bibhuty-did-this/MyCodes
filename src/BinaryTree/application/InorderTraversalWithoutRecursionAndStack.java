package BinaryTree.application;

public class InorderTraversalWithoutRecursionAndStack{
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	static Node root;
	
	static void inorderTraversalWithoutRecursionAndStack(Node node){
		
		if(node==null)return;
		
		Node current=node;
		while(current!=null){
			if(current.left==null){
				visit(current);
				current=current.right;
			}else{
				Node inorderPredecessor=inorderPredecessor(current);
				if(inorderPredecessor.right==null){
					inorderPredecessor.right=current;
					current=current.left;
				}else{
					inorderPredecessor.right=null;
					visit(current);
					current=current.right;
				}
			}
		}
	}
	static Node inorderPredecessor(Node node){
		Node current=node.left;
		while(current.right!=null && current.right!=node)
			current=current.right;
		return current;
	}
	static void visit(Node node){
		System.out.print(node.data+" ");
	}
	public static void main(String args[]){
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		
		inorderTraversalWithoutRecursionAndStack(root);
	}
}