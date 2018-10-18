package LinkedList.applications;

public class Add2NumbersRepresentedByLinkedList{
	public static void main(String[] args){
		int num1=550,num2=99999;
		LinkedList_Add2NumbersRepresentedByLinkedList list1=new LinkedList_Add2NumbersRepresentedByLinkedList();
		LinkedList_Add2NumbersRepresentedByLinkedList list2=new LinkedList_Add2NumbersRepresentedByLinkedList();
		while(num1!=0){
			list1.push(num1%10);
			num1/=10;
		}
		list1.printList();
		while(num2!=0){
			list2.push(num2%10);
			num2/=10;
		}
		list2.printList();
		LinkedList_Add2NumbersRepresentedByLinkedList list=addLists(list1.head,list2.head);
		list.printList();
	}
	static LinkedList_Add2NumbersRepresentedByLinkedList addLists(Node_Add2NumbersRepresentedByLinkedList headA,Node_Add2NumbersRepresentedByLinkedList headB){
		Node_Add2NumbersRepresentedByLinkedList nodeA=headA,nodeB=headB;
		LinkedList_Add2NumbersRepresentedByLinkedList list=new LinkedList_Add2NumbersRepresentedByLinkedList();
		int carry=0;
		while(nodeA!=null && nodeB!=null){
			int dataA=nodeA.data;
			int dataB=nodeB.data;
			int total=dataA+dataB+carry;
			list.push(total%10);
			carry=total/10;
			nodeA=nodeA.next;
			nodeB=nodeB.next;
		}
		Node_Add2NumbersRepresentedByLinkedList residual=nodeA!=null?nodeA:nodeB;
		while(residual!=null){
			int data=carry+residual.data;
			list.push(data%10);
			carry=data/10;
			residual=residual.next;
		}
		while(carry!=0){
			list.push(carry%10);
			carry/=10;
		}
		return list;
	}
}

class LinkedList_Add2NumbersRepresentedByLinkedList{
	Node_Add2NumbersRepresentedByLinkedList head;
	void push(int data){
		Node_Add2NumbersRepresentedByLinkedList lastNode=new Node_Add2NumbersRepresentedByLinkedList(data);
		if(head==null)head=lastNode;
		else{
			Node_Add2NumbersRepresentedByLinkedList last=head;
			while(last.next!=null)last=last.next;
			last.next=lastNode;
		}
	}
	void printList(){
		Node_Add2NumbersRepresentedByLinkedList current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
}

class Node_Add2NumbersRepresentedByLinkedList{
	int data;
	Node_Add2NumbersRepresentedByLinkedList next;
	public Node_Add2NumbersRepresentedByLinkedList(int data){
		this.data=data;
		this.next=null;
	}
}