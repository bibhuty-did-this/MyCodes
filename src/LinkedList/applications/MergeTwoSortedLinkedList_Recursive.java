package LinkedList.applications;

public class MergeTwoSortedLinkedList_Recursive{
	public static void main(String[] args){
		LinkedList_MergeTwoSortedLinkedList_Recursive list1=new LinkedList_MergeTwoSortedLinkedList_Recursive();
		LinkedList_MergeTwoSortedLinkedList_Recursive list2=new LinkedList_MergeTwoSortedLinkedList_Recursive();
		for(int i=0;i<10;i+=2)list1.push(i);
		list1.printList();
		for(int i=1;i<19;i+=2)list2.push(i);
		list2.printList();
		LinkedList_MergeTwoSortedLinkedList_Recursive list=new LinkedList_MergeTwoSortedLinkedList_Recursive();
		list.head=MergeTwoSortedLinkedList_Recursive.merge(list1.head,list2.head);
		list.printList();
	}
	static Node_MergeTwoSortedLinkedList_Recursive merge(Node_MergeTwoSortedLinkedList_Recursive headA,Node_MergeTwoSortedLinkedList_Recursive headB){
		if(headB==null)return headA;
		if(headA==null)return headB;
		Node_MergeTwoSortedLinkedList_Recursive newNode=new Node_MergeTwoSortedLinkedList_Recursive('0');
		if(headA.data<=headB.data){
			newNode=headA;
			newNode.next=merge(headA.next,headB);
		}else{
			newNode=headB;
			newNode.next=merge(headA,headB.next);
		}
		return newNode;
	}
}

class LinkedList_MergeTwoSortedLinkedList_Recursive{
	Node_MergeTwoSortedLinkedList_Recursive head;
	void push(int data){
		if(head==null)head=new Node_MergeTwoSortedLinkedList_Recursive(data);
		else{
			Node_MergeTwoSortedLinkedList_Recursive Node_MergeTwoSortedLinkedList_Recursive=head;
			while(Node_MergeTwoSortedLinkedList_Recursive.next!=null)Node_MergeTwoSortedLinkedList_Recursive=Node_MergeTwoSortedLinkedList_Recursive.next;
			Node_MergeTwoSortedLinkedList_Recursive.next=new Node_MergeTwoSortedLinkedList_Recursive(data);
		}
	}
	void printList(){
		Node_MergeTwoSortedLinkedList_Recursive current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
}

class Node_MergeTwoSortedLinkedList_Recursive{
	int data;
	Node_MergeTwoSortedLinkedList_Recursive next;
	public Node_MergeTwoSortedLinkedList_Recursive(int data){
		this.data=data;
		this.next=null;
	}
}