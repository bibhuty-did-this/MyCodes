package BinaryTree.application;

public class SubtreeCheck{

	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			left=right=null;
		}
	}

	static Node root1,root2;

	public static boolean areIdentical(Node root1, Node root2){
		if(root1==null && root2==null)
			return true;

		if(root1==null || root2==null)
			return false;

		return (root1.data==root2.data &&
				areIdentical(root1.left,root2.left) &&
				areIdentical(root1.right,root2.right));

	}

	public static boolean isSubtree(Node tree, Node subTree){
		if(subTree==null)
			return true;

		if(tree==null)
			return false;

		if(areIdentical(tree,subTree))
			return true;

		return isSubtree(tree.left,subTree) || isSubtree(tree.right,subTree);
	}

	public static void main(String[] args){
		SubtreeCheck tree = new SubtreeCheck();

		// TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

		tree.root1 = new Node(26);
		tree.root1.right = new Node(3);
		tree.root1.right.right = new Node(3);
		tree.root1.left = new Node(10);
		tree.root1.left.left = new Node(4);
		tree.root1.left.left.right = new Node(30);
		tree.root1.left.right = new Node(6);

		// TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

		tree.root2 = new Node(10);
		tree.root2.right = new Node(6);
		tree.root2.left = new Node(4);
		tree.root2.left.right = new Node(30);

		if (tree.isSubtree(tree.root1, tree.root2))
			System.out.println("Tree 2 is subtree of Tree 1 ");
		else
			System.out.println("Tree 2 is not a subtree of Tree 1");
	}
}
