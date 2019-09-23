package BinarySearchTree.application;

public class Merge2BSTs{
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	static Node root1,root2;

	public static void main(String[] args){
		/*
		Creating following tree as First balanced BST
                 100
                /   \
               50   300
               / \
              20 70
        */

		Merge2BSTs tree = new Merge2BSTs();
		tree.root1 = new Node(100);
		tree.root1.left = new Node(50);
		tree.root1.right = new Node(300);
		tree.root1.left.left = new Node(20);
		tree.root1.left.right = new Node(70);

        /*
        Creating following tree as second balanced BST
                80
                / \
              40 120
        */

		tree.root2 = new Node(80);
		tree.root2.left = new Node(40);
		tree.root2.right = new Node(120);
	}
}
