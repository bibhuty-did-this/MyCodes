package BinarySearchTree.application;

// Wrong solution
public class InorderSuccessorAndPredecessor {
    // Special class to take care of the parent
    static class Node{
        int data;
        Node left,right,parent;
        public Node(int data){
            this.data=data;
            left=right=parent=null;
        }
    }

    // Root node
    static Node root;

    // Insertion by taking care of the pointer to the parent node
    public static Node insert(Node node,int data){
        if(node==null)
            return new Node(data);
        else if(node.data>data) {
            Node leftNode=insert(node.left, data);
            node.left = leftNode;
            leftNode.parent=node;
        }else {
            Node rightNode=insert(node.right, data);
            node.right = rightNode;
            rightNode.parent=node;

        }
        return node;
    }

    // Main function for insertion
    public static void insert(int data){
        root=insert(root,data);
    }

    // Inorder traversal of the tree starting from a particular node
    public static void inorder(Node node){
        if(node==null)
            return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
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
        else return findSuccessor(node);
    }

    /**
     * Case 1: If right subtree is present
     *  + Inorder successor is nothing but the leftmost node of the
     *    right subtree of the given node.
     * Case 2: If right subtree is absent
     *  + Inorder successor is nothing but the first parent which is
     *    having data greater than the current data; OR
     *    It is the first ancestor which is the left child of its parent.
     * @param node
     * @return inorder successor of the node when its right subtree is present
     */
    public static Node findSuccessor(Node node){
        Node current=node.right;
        if(current!=null) {
            while (current.left != null)
                current = current.left;
            return current;
        }else{
            Node parent=node.parent;
            Node child=node;
            while (parent!=null && parent.right==child) {
                child=parent;
                parent = parent.parent;
            }
            return parent;
        }
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
     * Case 1: If the left subtree is present
     *  + Inorder predecessor of the node is nothing but the right most node
     *    of the left subtree of the given node.
     * Case 2: If the left subtree is absent
     *  + Inorder predecessor is the first parent having data less than the
     *    current data; OR
     *    It is the first ancestor which is the right child of its parent.
     *
     * @param node
     * @return inorder predecessor of the node
     */
    public static Node findPredecessor(Node node){
        Node current=node.left;
        if(current!=null){
            while (current.right!=null)
                current=current.right;
            return current;
        }else{
            Node parent=node.parent;
            Node child=node;
            while (parent!=null && parent.left==child){
                child=parent;
                parent=parent.parent;
            }
            return parent;
        }
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

        int data=5;
        // finding the inorder successor
        Node inorderPredecessor=inorderPredecessor(root,data);
        System.out.println("The inorder predecessor of "+data+" is "+inorderPredecessor.data);
        //finding the inorder predecessor
        Node inorderSuccssor=inorderSuccessor(root,data);
        System.out.println("The inorder successor of "+data+" is "+inorderSuccssor.data);
    }

}
