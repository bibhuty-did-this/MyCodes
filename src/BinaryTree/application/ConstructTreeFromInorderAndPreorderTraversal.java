package BinaryTree.application;

/**
 * The main idea here is how the preorder/postorder array is filled.
 * Rest is all about backtracking.
 */

public class ConstructTreeFromInorderAndPreorderTraversal{

	static class Node{
		char data;
		Node left,right;
		public Node(char data){
			this.data=data;
			left=right=null;
		}
	}

	static Node root;

	static int preIndex=0;

	public static Node treeConstruct(char in[],char pre[],int s,int e){

		if(s>e)
			return null;

		Node node=new Node(pre[preIndex++]);

		// Find the index inorder traversal
		int i;
		for(i=s;i<=e;++i)
			if(in[i]==node.data)
				break;

		node.left=treeConstruct(in,pre,s,i-1);
		node.right=treeConstruct(in,pre,i+1,e);

		return node;
	}

	public static void printInorder(Node node){
		if(node==null)
			return;

		printInorder(node.left);
		System.out.print(node.data+" ");
		printInorder(node.right);
	}

	public static void main(String[] args){
		ConstructTreeFromInorderAndPreorderTraversal tree = new ConstructTreeFromInorderAndPreorderTraversal();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;
		Node root = tree.treeConstruct(in, pre, 0, len - 1);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.printInorder(root);
	}
}
