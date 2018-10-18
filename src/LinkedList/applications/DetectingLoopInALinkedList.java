package LinkedList.applications;

import java.util.HashSet;

public class DetectingLoopInALinkedList{
	public static void main(String args[]){
		LinkedList_DetectingLoopInALinkedList llist = new LinkedList_DetectingLoopInALinkedList();
          
        llist.addAtEnd(20);
        llist.addAtEnd(4);
        llist.addAtEnd(15);
        llist.addAtEnd(10);

        /*Create loop for testing */
        //llist.head.next.next.next.next = llist.head;

        if (llist.detectLoopUsingHashing())
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
	}
}

class LinkedList_DetectingLoopInALinkedList{
	Node_DetectingLoopInALinkedList head;
	void addAtEnd(int data){
		if(head==null)head=new Node_DetectingLoopInALinkedList(data);
		else{
			Node_DetectingLoopInALinkedList current=head;
			while(current.next!=null)current=current.next;
			current.next=new Node_DetectingLoopInALinkedList(data);
		}
	}
	void addAtFront(int data){
		if(head==null)head=new Node_DetectingLoopInALinkedList(data);
		else{
			Node_DetectingLoopInALinkedList newHead=new Node_DetectingLoopInALinkedList(data);
			newHead.next=head;
			head=newHead;
		}

	}
	void printList(){
		Node_DetectingLoopInALinkedList current=head;
		while(current!=null){
			System.out.print(current.data+" ");
		}
		System.out.println();
	}
	boolean detectLoop(){
		if(head==null)return false;
		Node_DetectingLoopInALinkedList slow=head,fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)return true;
		}
		return false;
	}
	
	boolean detectLoopUsingHashing(){
		if(head==null)return false;
		Node_DetectingLoopInALinkedList current=head;
		HashSet<Node_DetectingLoopInALinkedList> set=new HashSet();
		while(current!=null){
			if(set.contains(current))return true;
			set.add(current);
			current=current.next;
		}
		return false;
	}
	
}

class Node_DetectingLoopInALinkedList{
	int data;
	Node_DetectingLoopInALinkedList next;
	public Node_DetectingLoopInALinkedList(int data){
		this.data=data;
		this.next=null;
	}
}
