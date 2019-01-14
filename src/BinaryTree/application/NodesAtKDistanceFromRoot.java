package BinaryTree.application;

public class NodesAtKDistanceFromRoot{
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	static Node root;

	static void printNode(Node node,int current,int k){
		if(node==null)return;

		if(current==k){
			System.out.println(node.data);
			return;
		}

		printNode(node.left,current+1,k);
		printNode(node.right,current+1,k);
	}
	public static void main(String[] args){
		NodesAtKDistanceFromRoot tree = new NodesAtKDistanceFromRoot();

        /* Constructed binary tree is
                1
              /   \
             2     3
            /  \   /
           4    5 8
        */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);

		tree.printNode(tree.root, 0,2);
	}
}
