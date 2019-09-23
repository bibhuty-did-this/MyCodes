package BinaryTree.application;

public class PrintAllAncestorsOfANode{

	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			left=right=null;
		}
	}

	static Node root;

	boolean printAllAncestors(Node node,int target){
		if(node==null)
			return false;

		if(node.data==target)
			return true;

		if(printAllAncestors(node.left,target) || printAllAncestors(node.right,target)){
			System.out.println(node.data);
			return true;
		}

		return false;
	}

	public static void main(String[] args){
		PrintAllAncestorsOfANode tree = new PrintAllAncestorsOfANode();

		/* Construct the following binary tree
				1
				/ \
			2	 3
			/ \
			4 5
			/
		7
		*/
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(7);

		tree.printAllAncestors(tree.root, 5);
	}
}
