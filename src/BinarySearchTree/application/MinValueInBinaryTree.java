package BinarySearchTree.application;

public class MinValueInBinaryTree {


    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    static Node root;

    public static Node insert(Node node,int data){

        // In case the node is null then return the node
        if(node==null)
            return new Node(data);

        // Search for the node otherwise
        else if(node.data>data)
            node.left = insert(node.left, data);
        else
            node.right=insert(node.right,data);

        // Return the unchanged node pointer
        return node;
    }

    public static void insert(int key){
        root=insert(root,key);
    }

    public static void inorder(Node node){

        if(node==null)
            return;

        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    /**
     * Start from the root and traverse left unless and until you reach the end,
     * the last node will give you the minimum value.
     *
     * @param node
     * @return minimum value of the binary search tree
     */
    public static int findMin(Node node){

        if(node==null)
            return Integer.MAX_VALUE;

        while(node.left!=null)
            node=node.left;

        return node.data;
    }

    public static void main(String[] args) {
        MinValueInBinaryTree tree=new MinValueInBinaryTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);

        tree.inorder(root);
        System.out.println("\nThe minimum value of the binary search tree is "+findMin(root));
    }
}
