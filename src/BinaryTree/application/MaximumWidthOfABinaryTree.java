package BinaryTree.application;

import static java.lang.Math.max;

public class MaximumWidthOfABinaryTree{
	static class Node{
		Node left;
		Node right;
		int data;

		Node(int data){
			this.data=data;
			left=right=null;
		}
	}

	static Node root;

	static int heigth(Node node){
		return node==null?0:1+max(heigth(node.left),heigth(node.right));
	}


	static void calculateWidth(Node node,int level,int[] width){
		if(node==null)return;

		++width[level];

		calculateWidth(node.left,level+1,width);
		calculateWidth(node.right,level+1,width);
	}

	static int getMaxWidth(){
		int n=heigth(root);
		int[] width=new int[n];
		calculateWidth(root,0,width);
		int maxWidth=0;
		for(int i=0;i<n;++i)
			maxWidth=max(maxWidth,width[i]);
		return maxWidth;
	}
	public static void main(String[] args){
		MaximumWidthOfABinaryTree tree = new MaximumWidthOfABinaryTree();

        /*
        Constructed bunary tree is:
              1
            /  \
           2    3
         /  \    \
        4   5     8
                 /  \
                6   7
         */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(8);
		tree.root.right.right.left = new Node(6);
		tree.root.right.right.right = new Node(7);

		System.out.println(getMaxWidth());
	}
}
