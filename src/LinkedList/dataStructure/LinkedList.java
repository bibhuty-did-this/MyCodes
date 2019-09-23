package LinkedList.dataStructure;

/**
 * Linked List:
 * 	- Linked List is a linear data structure
 * 	- Unlike arrays the elements in the Linked List are not
 * 	  stored in contiguous locations
 * 	- Advantages over array:
 * 		+ Dynamic size
 * 		+ Ease of insertion and deletion
 * 	- Drawbacks:
 * 		+ Random access not allowed
 * 		+ Extra memory space for the pointer
 * 	- Array vs DataStructure_LinkedList.LinkedList in terms of memory point of view:
 * 		+ Array is considered as a static data structure whose
 * 		  memory is fixed during compile time and array
 * 		  memory is allocated either from:
 * 		  	1) Data Section(Global array)
 * 		  	2) Stack Section(Local array)
 * 		+ Linked list is considered as a dynamic data structure
 * 		  for which size is not fixed and memory is allocated
 * 		  from heap section as and when needed.
 */

public class LinkedList{
	Node head;//to store the head of the linked list

	//custom class for linked list
	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			this.next=null;
		}

	}

	//function to print the complete linked list
	void printList(){
		System.out.println("The DataStructure_LinkedList.LinkedList is");
		Node progress=head;
		while(progress!=null){
			System.out.print(progress.data+" ");
			progress=progress.next;
		}
		System.out.println();
	}

	//Add a node at the front
	void push(int newData){
		if(head==null){
			head=new Node(newData);
			return;
		}
		Node newNode=new Node(newData);
		newNode.next=head;
		head=newNode;
	}

	//Add a node at the end
	void append(int newData){
		if(head==null){
			head=new Node(newData);
			return;
		}
		Node lastNode=new Node(newData);
		Node last=head;
		while(last.next!=null)last=last.next;
		last.next=lastNode;

	}

	//Add a node after any given node
	void pushAfter(Node node, int newData){
		Node newNode=new Node(newData);
		if(node==null){
			System.out.println("The given node can't be null");
			return;
		}
		newNode.next=node.next;
		node.next=newNode;
	}

	//Deleting a node in linked list for a given key
	void deleteNode(int key){
		Node current=head, prev=null;
		if(current!=null && current.data==key){
			head=current.next;
			return;
		}
		while(current!=null && current.data!=key){
			prev=current;
			current=current.next;
		}
		if(current==null){
			System.out.println(key+" not found");
			return;
		}
		prev.next=current.next;

	}

	//Deleting a node in linked list for a given position
	void deleteAt(int pos){
		if(head==null)return;
		Node current=head;
		if(pos==0){
			head=current.next;
			return;
		}
		for(int i=0;current!=null && i<pos-1;++i)
			current=current.next;
		if(current==null || current.next==null)return;
		current.next=current.next.next;
	}

	//Find the length of the linked list in iterative way
	int iterativeLength(){
		int length=0;
		Node current=head;
		while(current!=null){
			++length;
			current=current.next;
		}
		return length;
	}

	//Find the length of the linked list in recursive way
	int recursiveLengthUtility(Node node){
		if(node==null)return 0;
		else return 1+recursiveLengthUtility(node.next);
	}
	int recursiveLength(){
		return recursiveLengthUtility(head);
	}

	//Swap nodes in a linked list without swapping data
	public void swapNodes(int x, int y){
		if(x==y)return;

		Node prevX=null, currX=head;
		while(currX!=null && currX.data!=x){
			prevX=currX;
			currX=currX.next;
		}
		if(currX==null)return;

		Node prevY=null, currY=head;
		while(currY!=null && currY.data!=y){
			prevY=currY;
			currY=currY.next;
		}
		if(currY==null)return;

		if(prevX!=null)prevX.next=currY;
		else head=currY;

		if(prevY!=null)prevY.next=currX;
		else head=currX;

		Node temp=currX.next;
		currX.next=currY.next;
		currY.next=temp;
	}

	//Reverse a linked list in iterative manner
	void iterativeReverse(){
		Node prev=null;
		Node current=head;
		Node next;
		while(current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
	}

	//Reverse a linked list in recursive manner
	void recursiveReverseUtil(Node curr, Node prev){
		if(curr.next==null){
			curr.next=prev;
			head=curr;
			return;
		}

		Node nextCurr=curr.next;
		curr.next=prev;
		recursiveReverseUtil(nextCurr, curr);
		return;
	}
	void recursiveReverse(){
		recursiveReverseUtil(head, null);
	}

	//Checking if a linked list is a palindrome or not
	

	//Main method for implementation
	public static void main(String...strings){
		LinkedList linkedList=new LinkedList();
		linkedList.append(1);
		linkedList.printList();//1
		linkedList.push(0);
		linkedList.printList();//0 1
		linkedList.append(2);
		linkedList.printList();//0 1 2
		linkedList.pushAfter(linkedList.head,1);
		linkedList.printList();//0 1 1 2
		System.out.println("Reversing the linkedList");
		linkedList.iterativeReverse();
		linkedList.printList();
		System.out.println("Again reversing it we get");
		linkedList.recursiveReverse();
		linkedList.printList();
		linkedList.deleteNode(-1);//-1 not found
		linkedList.printList();//0 1 1 2
		linkedList.deleteAt(1);//same as linkedList.deleteNode(1);
		linkedList.printList();//0 1 2
		linkedList.deleteAt(0);//same as linkedList.deleteNode(0);
		linkedList.printList();//1 2
		System.out.println("recursiveLength() returns "+
				linkedList.recursiveLength());
		System.out.println("iterativeLength() returns "+
				linkedList.iterativeLength());
		linkedList.swapNodes(1,2);
		linkedList.printList();//2 1

	}
}
