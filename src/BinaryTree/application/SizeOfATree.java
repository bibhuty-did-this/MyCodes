package BinaryTree.application;

public class SizeOfATree{
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			left=right=null;
		}
	}

	static Node root;

	public static int calculateSize(Node node){
		if(node==null)
			return 0;
		return 1+calculateSize(node.left)+calculateSize(node.right);
	}

	public static int size(){
		return calculateSize(root);
	}
	public static void main(String[] args){
		SizeOfATree tree = new SizeOfATree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("The size of binary tree is : "
				+ tree.size());
	}
}
