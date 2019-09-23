package BinaryTree.dataStructure;

/**
 * Tree:
 *
 * ~ Some common terms in the trees are as follows:
 *      1. Root
 *      2. Child/children
 *      3. Parent
 *
 * ~ Why trees?
 *      1. Storing hierarchical data
 *      2. Moderate access/search timing(AVL and Red-Black trees)
 *      3. Moderate insertion/deletion timing(AVL and Red-Black trees)
 *      4. No upper limit on number of nodes
 *
 * ~ Application of trees are as follows:
 *      1. Using it in router algorithms
 */

/**
 * Binary Tree:
 *
 * ~ A tree which has at most 2 children
 *
 * ~ Properties of Binary Tree are as follows:
 *      1. Maximum no of nodes at any level 'l' is 2^(l-1)
 *      2. Maximum no of nodes in a binary tree of height h is 2^h - 1
 *      3. Minimum possible height of a binary tree with N nodes is log2(N+1)
 *      4. Maximum possible height of a binary tree with N nodes is N
 *      5. Binary tree with L leaves have at least log2(L+1) levels
 *      6. No of leaf nodes = No of internal nodes with 2 children + 1
 *
 * ~ Types of Binary Tree are as follows:
 *      1. Full binary tree: Each and every node has 0 or 2 children
 *      2. Complete binary tree: All levels are completely filled except for the last level
 *      3. Perfect binary tree: All internal nodes have 2 children and all leaves are at the same level
 *      4. Balanced binary tree: Height of the tree is log2(n) where n is the number of nodes(AVL tree and Red-Black tree)
 *      5. Degenerate or pathological binary tree: Every internal node has 1 child
 *
 * ~ Handshaking lemma and related properties:
 *      1. sum of degree of vertices = 2*(no of edges)
 *      2. number of vertices with odd degree is always even
 *      3. for a k ary tree: no of leaf nodes = (k-1)*(no of internal nodes with k nodes) + 1
 */
public class BinaryTree{

    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    static Node root;

    public BinaryTree(int data){
        root=new Node(data);
    }

    public BinaryTree(){
        root=null;
    }



    public static void main(String[] args){
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
    }

}

