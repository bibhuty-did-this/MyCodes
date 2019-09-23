package BinaryTree.application;

public class DiameterOfBinaryTree_Optimized{
	Node root;
	
	int diameterUtility(Node node,Height height){
		
		//These variables are assigned to ensure pass by reference property in java
		Height leftHeight=new Height(),rightHeight=new Height();
		
		//If the node is null then the height is 0 only
		if(node==null){
			height.height=0;
			return 0;
		}
		
		int leftDiameter=diameterUtility(node.left,leftHeight); //It returns the maximum value of diameter till the left node of 'node'
		int rightDiameter=diameterUtility(node.right,rightHeight);//It returns the maximum value of the diameter till the right node of 'node'
		
		height.height=Math.max(leftHeight.height,rightHeight.height)+1;//It returns the maximum height till 'node' to the reference varaiable 'height'
		
		return Math.max(leftHeight.height+rightHeight.height+1,Math.max(leftDiameter,rightDiameter));//It returns the maximum diameter till the 'node'
		
	}
	
	int diameter(Node node){
		Height height=new Height();
		return diameterUtility(node,height);
	}
	
	public static void main(String args[]){
		DiameterOfBinaryTree_Optimized tree=new DiameterOfBinaryTree_Optimized();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		
		System.out.println("The diameter of the tree is " + tree.diameter(tree.root));
	}
}

class Height{
	int height;
}

class Node{
	int data;
	Node left,right;
	public Node(int data){
		this.data=data;
		this.left=this.right=null;
	}
}