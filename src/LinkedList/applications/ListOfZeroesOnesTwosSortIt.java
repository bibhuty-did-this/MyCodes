package LinkedList.applications;

public class ListOfZeroesOnesTwosSortIt{
	public static void main(String...strings){
		int numbers[]={0,0,1,1,2,2,0,1,2,2,2,0,2,1,1,0};
		LinkedList list=new LinkedList();
		for(int num:numbers)list.add(num);
		list.printList();
	}
}

class LinkedList{
	Node head;
	void add(int data){
		Node node=new Node(data);
		if(head==null){
			head=node;
		}else{
			Node last=head;
			while(last.next!=null)last=last.next;
			last.next=node;
		}
	}
	void sort(){

	}
	void printList(){
		Node current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
}

class Node{
	int data;
	Node next;
	public Node(int data){
		this.data=data;
		this.next=null;
	}
}