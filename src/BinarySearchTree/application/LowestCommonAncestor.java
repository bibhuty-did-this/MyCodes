package BinarySearchTree.application;

public class LowestCommonAncestor {


    // Lowest Common Ancestor
    // An iterative solution will be a space optimized one
    public static Node lowestCommonAncestor(Node node,int data1,int data2){
        if(node==null)
            return null;
        else if(node.data>data1 && node.data>data2)
            return lowestCommonAncestor(node.left,data1,data2);
        else if(node.data<data1 && node.data<data2)
            return lowestCommonAncestor(node.right,data1,data2);
        else
            return node;
    }


    // Data structure for BST
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    // root node
    static Node root;


    // Utility function for insertion of data
    public static Node insert(Node node,int data){
        if(node==null)
            return new Node(data);
        else if(node.data>data)
            node.left=insert(node.left,data);
        else if(node.data<data)
            node.right=insert(node.right,data);
        return node;
    }

    // Main function for insertion of data
    public static void insert(int data){
        root=insert(root,data);
    }

    // Inorder traversal for check
    public static void inorder(Node node){
        if(node==null)
            return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    public static void main(String[] args) {
        LowestCommonAncestor tree=new LowestCommonAncestor();

        // Creation of following BST
         /* Let us create following BST
              4
           /    \
          2      6
         / \    / \
       1    3  5   7
       */
        // Insertion of data
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        // Inorder sequence
        tree.inorder(root);
        System.out.println();

        int data1=1,data2=2;
        Node node=lowestCommonAncestor(root,data1,data2);
        System.out.println("The lowest common ancestor of "+data1+" and "+data2+" is "+node.data);
    }
}
