package LinkedList.applications;

public class NthNodeFromEndOfLinkedList{
	public static void main(String...strings){
		LinkedList_NthNodeFromEndOfLinkedList list = new LinkedList_NthNodeFromEndOfLinkedList();
		list.head = new Node_NthNodeFromEndOfLinkedList(50);
		list.head.next = new Node_NthNodeFromEndOfLinkedList(20);
		list.head.next.next = new Node_NthNodeFromEndOfLinkedList(15);
		list.head.next.next.next = new Node_NthNodeFromEndOfLinkedList(4);
		list.head.next.next.next.next = new Node_NthNodeFromEndOfLinkedList(10);
		
		list.printList();
		for(int i=1;i<=5;++i)
			System.out.println(list.findNthNodeFromLast(i));
	}
}

class LinkedList_NthNodeFromEndOfLinkedList{
	Node_NthNodeFromEndOfLinkedList head;
	void pushFront(int data){
		Node_NthNodeFromEndOfLinkedList newNode=new Node_NthNodeFromEndOfLinkedList(data);
		if(head==null)head=newNode;
		else{
			newNode.next=head;
			head=newNode;
		}
	}
	void pushBack(int data){
		Node_NthNodeFromEndOfLinkedList newNode=new Node_NthNodeFromEndOfLinkedList(data);
		if(head==null)head=newNode;
		else{
			Node_NthNodeFromEndOfLinkedList current=head;
			while(current.next!=null)current=current.next;
			current.next=newNode;
		}
	}
	void printList(){
		Node_NthNodeFromEndOfLinkedList current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
	int findNthNodeFromLast(int n){
		Node_NthNodeFromEndOfLinkedList ahead=head,behind=head;
		int start=1;
		while(ahead!=null && start<n){
			ahead=ahead.next;
			++start;
		}
		if(ahead==null)return -1;
		while(ahead!=null){
			ahead=ahead.next;
			behind=behind.next;
		}
		return behind.data;
	}
}

class Node_NthNodeFromEndOfLinkedList{
	int data;
	Node_NthNodeFromEndOfLinkedList next;
	public Node_NthNodeFromEndOfLinkedList(int data){
		this.data=data;
		this.next=null;
	}
}