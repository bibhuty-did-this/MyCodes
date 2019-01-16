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

	/**
	 * For each node if the value of the node is greater than key then search the key to the left,
	 * if the value is less than the key then search the key in the right subtree,
	 * if the value is same as the key then return the node.
	 *
	 * @param node
	 * @param key
	 * @return the node with key if found and null if no key found
	 */
	public static Node search(Node node,int key){
		if(node==null || node.data==key)
			return node;

		if(node.data>key)
			return search(node.left,key);

		return search(node.right,key);
	}

	/**
	 * It is to be noted that for a binary search tree insertion, it is always done at the leaf
	 * node. Same step as the search is followed until a leaf node is found, and when it is found
	 * the new node is inserted into the same spot.
	 *
	 * @param node
	 * @param key
	 * @return A binary search tree with the new node inserted at its leaf
	 */
	public static Node insert(Node node,int key){
		if(node==null){
			Node root=new Node(key);
			return root;
		}
		if(node.data>key)
			node.left=insert(node.left,key);
		else
			node.right=insert(node.right,key);

		return node;
	}

	public static void insert(int key){
		root=insert(root,key);
	}

	/**
	 * When you want to delete a node from a binary search tree one of the below 3 cases
	 * could occur:
	 * 	+ Case 1: If it is a leaf node then directly delete it.
	 * 	+ Case 2: If it has one child only then copy the child to the key location and delete
	 * 	          the child node.
	 * 	+ Case 3: If it has 2 children then either take the inorder successor or predecessor and
	 * 	          put them in the key position and delete the value you put in the key position.
	 *
	 * @param key key to be deleted
	 */
	public static void deleteNode(int key){
		root=delete(root,key);
	}

	public static Node delete(Node node,int key){

		// The case when nothing is found to be deleted
		if(root==null)
			return root;

		// Search for the key
		if(node.data>key)
			node.left=delete(node.left,key);
		else if(node.data<key)
			node.right=delete(node.right,key);

		// When the key is finally found
		else{
			// Case 1: When no child is present
			if(node.left==null && node.right==null)
				return null;

			// Case 2: When only one child is present
			else if(node.left==null)
				return node.right;
			else if(node.right==null)
				return node.left;

			// Case 3: When both left and right child are present
			else{

				// Find the inorder successor and store them in the place where key is found
				// Inorder successor(min value in right subtree)
				node.data=findMin(node.right);

				// Delete the inorder successor(in this way we are reducing it to Case 1 or 2
				// accordingly)
				node.right=delete(node.right,node.data);
			}

		}

		return node;

	}

	/**
	 * @param node
	 * @return minimum value in the tree
	 */
	public static int findMin(Node node){
		while(node.left!=null)
			node=node.left;
		return node.data;
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


		// Searching the node in a tree
		try{
			Node node=tree.search(root,30);
			System.out.println();
			System.out.println(node.data+" is found in the tree");
		}catch (NullPointerException e){
			System.out.println("The data searched is not found in the tree");
		}

		// Deleting a node in the tree
		try {
			deleteNode(80);
			deleteNode(70);
			deleteNode(30);
			inorder(root);
		}catch (NullPointerException e){
			System.out.println("The given value is not present hence can't be deleted");
		}
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
