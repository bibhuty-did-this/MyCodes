package BinarySearchTree.dataStructure;

public class BinarySearchTree{

	static class Node{
		int data;
		Node left,right;

		public Node(int data){
			this.data=data;
			left=right=null;
		}
	}

	static Node root;

	public static Node search(Node node,int key){
		if(node==null || node.data==key)
			return node;

		if(node.data>key)
			return search(node.left,key);

		return search(node.right,key);
	}

	public static Node insertNode(Node node,int key){
		if(node==null){
			Node root=new Node(key);
			return root;
		}
		if(node.data>key)
			node.left=insertNode(node.left,key);
		else
			node.right=insertNode(node.right,key);

		return node;
	}

	public static void insert(int key){
		root=insertNode(root,key);
	}


	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();

        /*
        Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80
        */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// print inorder traversal of the BST
		tree.inorder(root);
	}


	/*
		Methods which are for support only
	 */
	public static void inorder(Node node){
		if(node==null)
			return;

		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
}
