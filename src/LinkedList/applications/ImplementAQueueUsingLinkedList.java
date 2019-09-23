package LinkedList.applications;

public class ImplementAQueueUsingLinkedList{
	public static void main(String[] args){
		Queue queue=new Queue();
		int[] numbers=new int[]{
				0,1,2,3,4,5,6
		};
		for(int num:numbers)queue.enqueue(num);
		queue.printList();
		queue.front();
		queue.rear();
		queue.dequeue();
		queue.printList();
		queue.front();
		queue.rear();
	}
}

class Queue{
	Node_ImplementAQueueUsingLinkedList head,last;
	public Queue(){
		last=new Node_ImplementAQueueUsingLinkedList(Integer.MIN_VALUE);
		head=null;
	}
	void enqueue(int data){
		Node_ImplementAQueueUsingLinkedList lastNode=new Node_ImplementAQueueUsingLinkedList(data);
		if(head==null){
			head=lastNode;
			last.next=head;
		}else{
			Node_ImplementAQueueUsingLinkedList node=last.next;
			node.next=lastNode;
			last.next=lastNode;
		}
	}
	void dequeue(){
		if(head==null)return;
		Node_ImplementAQueueUsingLinkedList node=head;
		head=head.next;
		System.out.println("The dequeued element is "+node.data);
	}
	void printList(){
		Node_ImplementAQueueUsingLinkedList current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
	void front(){
		if(head==null)return;
		System.out.println("Front element is "+last.next.data);
	}
	void rear(){
		if(head==null)return;
		System.out.println("Rear element is "+head.data);
	}
}

class Node_ImplementAQueueUsingLinkedList{
	int data;
	Node_ImplementAQueueUsingLinkedList next;
	public Node_ImplementAQueueUsingLinkedList(int data){
		this.data=data;
		this.next=null;
	}
}