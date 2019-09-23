package LinkedList.applications;

public class PariwiseSwapElementsOfLinkedList{
	public static void main(String[] args){
		int[] numbers=new int[]{
				2,1,4,3,6,5,8,7,10,9,11
		};
		LinkedList_PariwiseSwapElementsOfLinkedList list=new LinkedList_PariwiseSwapElementsOfLinkedList();
		for(int num:numbers)list.pushBack(num);
		list.printList();
		list.pairwiseSwap();
		list.printList();
		list.head=list.recursivePairwiseSwap(list.head);
		list.printList();
	}
}

class LinkedList_PariwiseSwapElementsOfLinkedList{
	Node_PariwiseSwapElementsOfLinkedList head;
	void pushBack(int data){
		Node_PariwiseSwapElementsOfLinkedList node=new Node_PariwiseSwapElementsOfLinkedList(data);
		if(head==null)head=node;
		else{
			Node_PariwiseSwapElementsOfLinkedList current=head;
			while(current.next!=null)current=current.next;
			current.next=node;
		}
	}
	void printList(){
		Node_PariwiseSwapElementsOfLinkedList current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
	void pairwiseSwap(){
		Node_PariwiseSwapElementsOfLinkedList _prev=null,prev,next,next_;
		Node_PariwiseSwapElementsOfLinkedList current=head;
		while(current!=null && current.next!=null){
			prev=current;
			next=current.next;
			next_=current.next.next;

			next.next=prev;
			prev.next=next_;
			if(_prev!=null){
				_prev.next=next;
				_prev=prev;
			}else{
				head=next;
				_prev=prev;
			}
			current=next_;
		}
	}

	Node_PariwiseSwapElementsOfLinkedList recursivePairwiseSwap(Node_PariwiseSwapElementsOfLinkedList node){
		if(node==null || node.next==null)return node;
		Node_PariwiseSwapElementsOfLinkedList prev=node,next=node.next,next_=node.next.next;
		next.next=prev;
		prev.next=recursivePairwiseSwap(next_);
		return next;
	}
}

class Node_PariwiseSwapElementsOfLinkedList{
	int data;
	Node_PariwiseSwapElementsOfLinkedList next;
	public Node_PariwiseSwapElementsOfLinkedList(int data){
		this.data=data;
		this.next=null;
	}
}