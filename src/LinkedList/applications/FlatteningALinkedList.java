package LinkedList.applications;

public class FlatteningALinkedList{
	public static void main(String args[]){
		LinkedList_FlatteningALinkedList L = new LinkedList_FlatteningALinkedList();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

		L.head = L.push(L.head, 30);
		L.head = L.push(L.head, 8);
		L.head = L.push(L.head, 7);
		L.head = L.push(L.head, 5);

		L.head.right = L.push(L.head.right, 20);
		L.head.right = L.push(L.head.right, 10);

		L.head.right.right = L.push(L.head.right.right, 50);
		L.head.right.right = L.push(L.head.right.right, 22);
		L.head.right.right = L.push(L.head.right.right, 19);

		L.head.right.right.right = L.push(L.head.right.right.right, 45);
		L.head.right.right.right = L.push(L.head.right.right.right, 40);
		L.head.right.right.right = L.push(L.head.right.right.right, 35);
		L.head.right.right.right = L.push(L.head.right.right.right, 20);

		L.printlist();

		L.head=L.flatten(L.head);

		L.printlist();
	}
}

class LinkedList_FlatteningALinkedList{
	Node_FlatteningALinkedList head;
	Node_FlatteningALinkedList push(Node_FlatteningALinkedList Node_FlatteningALinkedList,int data){
		Node_FlatteningALinkedList newNode=new Node_FlatteningALinkedList(data);
		newNode.down=Node_FlatteningALinkedList;
		Node_FlatteningALinkedList=newNode;
		return Node_FlatteningALinkedList;
	}
	void printlist(){
		Node_FlatteningALinkedList current=head;
		while(current!=null){
			Node_FlatteningALinkedList now=current;
			while(now!=null){
				System.out.print(now.data+" ");
				now=now.down;
			}
			System.out.println();
			current=current.right;
		}
	}
	Node_FlatteningALinkedList merge(Node_FlatteningALinkedList nodeA,Node_FlatteningALinkedList nodeB){
		if(nodeA==null)return nodeB;
		if(nodeB==null)return nodeA;
		Node_FlatteningALinkedList newNode;
		if(nodeA.data<nodeB.data){
			newNode=nodeA;
			newNode.down=merge(nodeA.down,nodeB);
		}else{
			newNode=nodeB;
			newNode.down=merge(nodeA,nodeB.down);
		}
		return newNode;
	}
	Node_FlatteningALinkedList flatten(Node_FlatteningALinkedList root){
		if(root==null || root.right==null)return root;
		flatten(root.right);
		root=merge(root,root.right);
		return root;
	}
}

class Node_FlatteningALinkedList{
	int data;
	Node_FlatteningALinkedList right,down;
	public Node_FlatteningALinkedList(int data){
		this.data=data;
		this.right=null;
		this.right=null;
	}
}
