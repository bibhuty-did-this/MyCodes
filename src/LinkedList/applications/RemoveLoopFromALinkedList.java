package LinkedList.applications;

import java.util.HashSet;

public class RemoveLoopFromALinkedList{
	public static void main(String...strings){
		LinkedList_RemoveLoopFromALinkedList list = new LinkedList_RemoveLoopFromALinkedList();
        list.head = new Node_RemoveLoopFromALinkedList(50);
        list.head.next = new Node_RemoveLoopFromALinkedList(20);
        list.head.next.next = new Node_RemoveLoopFromALinkedList(15);
        list.head.next.next.next = new Node_RemoveLoopFromALinkedList(4);
        list.head.next.next.next.next = new Node_RemoveLoopFromALinkedList(10);
		
		// Creating a loop for testing 
        list.head.next.next.next.next.next = list.head.next;
		
		list.removeLoop();
        System.out.println("Linked List after removing loop : ");
        list.printList();
 
	}
}

class LinkedList_RemoveLoopFromALinkedList{
	Node_RemoveLoopFromALinkedList head;
	void pushFront(int data){
		if(head==null)head=new Node_RemoveLoopFromALinkedList(data);
		else{
			Node_RemoveLoopFromALinkedList newHead=new Node_RemoveLoopFromALinkedList(data);
			newHead.next=head;
			head=newHead;
		}
	}	
	void pushBack(int data){
		if(head==null)head=new Node_RemoveLoopFromALinkedList(data);
		else{
			Node_RemoveLoopFromALinkedList current=head;
			while(current.next!=null)current=current.next;
			current.next=new Node_RemoveLoopFromALinkedList(data);
		}
	}
	void removeLoopUsingHashing(){
		HashSet<Node_RemoveLoopFromALinkedList> listSet=new HashSet();
		if(head==null)return;
		Node_RemoveLoopFromALinkedList current=head;
		while(current.next!=null && !listSet.contains(current.next)){
			listSet.add(current);
			current=current.next;
		}
		current.next=null;
	}
	Node_RemoveLoopFromALinkedList cycleExists(){
		if(head==null)return null;
		Node_RemoveLoopFromALinkedList fast=head,slow=head;
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)return slow;
		}
		return null;
		
	}
	void removeLoop_CheckingOneByOne(){
		Node_RemoveLoopFromALinkedList loopNode=cycleExists();
		if(loopNode==null)return;
		Node_RemoveLoopFromALinkedList current=head;
		while(true){
			Node_RemoveLoopFromALinkedList traverse=loopNode;
			while(traverse.next!=loopNode && traverse.next!=current)traverse=traverse.next;
			if(traverse.next==current){
				traverse.next=null;
				return;
			}
			current=current.next;
		}
	}
	void removeLoop(){
		if(head==null)return;
		Node_RemoveLoopFromALinkedList hare=head, tortoise=head;
		while(hare!=null && hare.next!=null){
			hare=hare.next.next;
			tortoise=tortoise.next;
			if(hare==tortoise)break;
		}
		if(tortoise==null)return;
		hare=head;
		while(hare!=tortoise){
			hare=hare.next;
			tortoise=tortoise.next;
		}
		tortoise=tortoise.next;
		while(tortoise.next!=hare)tortoise=tortoise.next;
		tortoise.next=null;

	}
	void printList(){
		Node_RemoveLoopFromALinkedList current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
}


class Node_RemoveLoopFromALinkedList{
	int data;
	Node_RemoveLoopFromALinkedList next;
	public Node_RemoveLoopFromALinkedList(int data){
		this.data=data;
		this.next=null;
	}
}