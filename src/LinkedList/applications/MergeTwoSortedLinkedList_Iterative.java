package LinkedList.applications;

public class MergeTwoSortedLinkedList_Iterative{
	public static void main(String[] args){
		LinkedList_MergeTwoSortedLinkedList_Iterative list1=new LinkedList_MergeTwoSortedLinkedList_Iterative();
		LinkedList_MergeTwoSortedLinkedList_Iterative list2=new LinkedList_MergeTwoSortedLinkedList_Iterative();
		for(int i=0;i<10;i+=2)list1.push(i);
		list1.printList();
		for(int i=1;i<19;i+=2)list2.push(i);
		list2.printList();
		LinkedList_MergeTwoSortedLinkedList_Iterative list=MergeTwoSortedLinkedList_Iterative.merge(list1,list2);
		LinkedList_MergeTwoSortedLinkedList_Iterative newList=new LinkedList_MergeTwoSortedLinkedList_Iterative();
		newList.head=MergeTwoSortedLinkedList_Iterative.merge(list1.head,list2.head);

		newList.printList();
		//list.printList();
	}
	static LinkedList_MergeTwoSortedLinkedList_Iterative merge(LinkedList_MergeTwoSortedLinkedList_Iterative list1,LinkedList_MergeTwoSortedLinkedList_Iterative list2){
		LinkedList_MergeTwoSortedLinkedList_Iterative list=new LinkedList_MergeTwoSortedLinkedList_Iterative();
		Node_MergeTwoSortedLinkedList_Iterative node1=list1.head,node2=list2.head;
		while(node1!=null && node2!=null){
			if(node1.data<=node2.data){
				list.push(node1.data);
				node1=node1.next;
			}else{
				list.push(node2.data);
				node2=node2.next;
			}
		}
		if(node1!=null){
			while(node1!=null){
				list.push(node1.data);
				node1=node1.next;
			}
		}
		if(node2!=null){
			while(node2!=null){
				list.push(node2.data);
				node2=node2.next;
			}
		}
		return list;
	}

	static Node_MergeTwoSortedLinkedList_Iterative merge(Node_MergeTwoSortedLinkedList_Iterative nodeA,Node_MergeTwoSortedLinkedList_Iterative nodeB){
		Node_MergeTwoSortedLinkedList_Iterative headA=nodeA,headB=nodeB,temp,pointer=null,newHead=null;
		while(headA!=null && headB!=null){
			if(headA.data<=headB.data){
				temp=headA;
				headA=headA.next;
			}else{
				temp=headB;
				headB=headB.next;
			}
			if(pointer==null){
				pointer=temp;
				newHead=pointer;
			}else{
				pointer.next=temp;
				pointer=pointer.next;
			}

		}
		while(headA!=null){
			pointer.next=headA;
			headA=headA.next;
			pointer=pointer.next;
		}
		while(headB!=null){
			pointer.next=headB;
			headB=headB.next;
			pointer=pointer.next;
		}
		return newHead;
	}
}

class LinkedList_MergeTwoSortedLinkedList_Iterative{
	Node_MergeTwoSortedLinkedList_Iterative head;
	void push(int data){
		if(head==null)head=new Node_MergeTwoSortedLinkedList_Iterative(data);
		else{
			Node_MergeTwoSortedLinkedList_Iterative Node_MergeTwoSortedLinkedList_Iterative=new Node_MergeTwoSortedLinkedList_Iterative(data),current=head;
			while(current.next!=null)current=current.next;
			current.next=Node_MergeTwoSortedLinkedList_Iterative;
		}
	}
	void printList(){
		Node_MergeTwoSortedLinkedList_Iterative Node_MergeTwoSortedLinkedList_Iterative=head;
		while(Node_MergeTwoSortedLinkedList_Iterative!=null){
			System.out.print(Node_MergeTwoSortedLinkedList_Iterative.data+" ");
			Node_MergeTwoSortedLinkedList_Iterative=Node_MergeTwoSortedLinkedList_Iterative.next;
		}
		System.out.println();
	}
}

class Node_MergeTwoSortedLinkedList_Iterative{
	int data;
	Node_MergeTwoSortedLinkedList_Iterative next;
	public Node_MergeTwoSortedLinkedList_Iterative(int data){
		this.data=data;
		this.next=null;
	}
}