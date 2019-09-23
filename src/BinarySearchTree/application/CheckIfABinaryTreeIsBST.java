package BinarySearchTree.application;

public class CheckIfABinaryTreeIsBST {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    static Node root;

    public static boolean isBST(Node node,int min,int max){
        if(node==null)
            return true;
        return (node.data>min && node.data<max) &&
                isBST(node.left,min,node.data) &&
                isBST(node.right,node.data,max);
    }
    public static boolean isBST(){
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        CheckIfABinaryTreeIsBST tree = new CheckIfABinaryTreeIsBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");

    }
}
