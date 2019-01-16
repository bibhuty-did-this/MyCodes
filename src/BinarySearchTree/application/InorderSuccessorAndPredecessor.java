package BinarySearchTree.application;

public class InorderSuccessorAndPredecessor {
    /**
     * Find the node whose inorder successor to be found and return the inorder
     * successor of the node is found or return null.
     * @param node
     * @param data
     * @return inorder successor of data if found.
     */
    public static Node inorderSuccessor(Node node,int data){
        if(node==null)
            return node;
        else if(node.data>data)
            return inorderSuccessor(node.left,data);
        else if(node.data<data)
            return inorderSuccessor(node.right,data);
        else
            return findSuccessor(node);
    }

    /**
     * Inorder successor is nothing but the leftmost node of the
     * right subtree of the given node.
     *
     * @param node
     * @return inorder successor of the node
     */
    public static Node findSuccessor(Node node){
        Node current=node.right;
        while (current.left!=null)
            current=current.left;
        return current;
    }

    /**
     * Find the node whose inorder predecessor to be found and return the inorder
     * predecessor of the node is found or return null.
     *
     * @param node
     * @param data
     * @return inorder predecessor of data if found
     */
    public static Node inorderPredecessor(Node node,int data){
        if(node==null)
            return node;
        else if(node.data>data)
            return inorderPredecessor(node.left,data);
        else if(node.data<data)
            return inorderPredecessor(node.right,data);
        else
            return findPredecessor(node);
    }

    /**
     * Inorder predecessor of the node is nothing but the right most node
     * of the left subtree of the given node.
     *
     * @param node
     * @return inorder predecessor of the node
     */
    public static Node findPredecessor(Node node){
        Node current=node.left;
        while (current.right!=null)
            current=current.right;
        return current;
    }
    public static void main(String[] args) {
        InorderSuccessorAndPredecessor tree=new InorderSuccessorAndPredecessor();

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

        // finding the inorder sequence
        tree.inorder(root);
        System.out.println();

        int data=4;
        // finding the inorder successor
        Node inorderPredecessor=inorderPredecessor(root,data);
        System.out.println("The inorder predecessor of "+data+" is "+inorderPredecessor.data);
        //finding the inorder predecessor
        Node inorderSuccssor=inorderSuccessor(root,data);
        System.out.println("The inorder successor of "+data+" is "+inorderSuccssor.data);
    }
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
        if(node==null)
            return new Node(data);
        else if(node.data>data)
            node.left=insert(node.left,data);
        else
            node.right=insert(node.right,data);
        return node;
    }
    public static void insert(int data){
        root=insert(root,data);
    }
    public static void inorder(Node node){
        if(node==null)
            return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
}
