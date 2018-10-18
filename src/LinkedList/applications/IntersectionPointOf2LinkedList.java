package LinkedList.applications;

public class IntersectionPointOf2LinkedList{
	public static void main(String[] args){
		LinkedList_IntersectionPointOf2LinkedList list1=new LinkedList_IntersectionPointOf2LinkedList();
		LinkedList_IntersectionPointOf2LinkedList list2=new LinkedList_IntersectionPointOf2LinkedList();

		// creating first linked list1
		list1.head = new Node_IntersectionPointOf2LinkedList(3);
		list1.head.next = new Node_IntersectionPointOf2LinkedList(6);
		list1.head.next.next = new Node_IntersectionPointOf2LinkedList(9);
		list1.head.next.next.next = new Node_IntersectionPointOf2LinkedList(15);
		list1.head.next.next.next.next = new Node_IntersectionPointOf2LinkedList(30);
		list1.printList();

		// creating second linked list2
		list2.head = new Node_IntersectionPointOf2LinkedList(10);
		list2.head.next =list1.head.next.next.next;
		list2.printList();

		System.out.println(findIntersection(list1.head,list2.head));
	}
	static int findIntersection(Node_IntersectionPointOf2LinkedList headA,Node_IntersectionPointOf2LinkedList headB){
		if(headA==null || headB==null)return -1;
		Node_IntersectionPointOf2LinkedList currentA=headA,currentB=headB;
		int countA=1,countB=1;
		while(currentA.next!=null){
			currentA=currentA.next;
			++countA;
		}
		while(currentB.next!=null){
			currentB=currentB.next;
			++countB;
		}
		//System.out.println(countA+" "+countB+" "+currentA.data+" "+currentB.data);
		if(currentA!=currentB)return -1;
		if(countA>countB){
			int go=countA-countB;
			currentA=headA;
			currentB=headB;
			while(go-->0)currentA=currentA.next;
			//System.out.println(currentA.data);
			while(true){
				if(currentA==currentB){
					return currentA.data;
				}else{
					currentA=currentA.next;
					currentB=currentB.next;
				}
			}
		}else{
			int go=countB-countA;
			currentA=headA;
			currentB=headB;
			while(go-->0)currentB=currentB.next;
			while(true){
				if(currentA==currentB)return currentB.data;
				else{
					currentA=currentA.next;
					currentB=currentB.next;
				}
			}
		}
	}
}

class LinkedList_IntersectionPointOf2LinkedList{
	Node_IntersectionPointOf2LinkedList head;
	void pushFront(int data){
		Node_IntersectionPointOf2LinkedList newNode=new Node_IntersectionPointOf2LinkedList(data);
		newNode.next=head;
		head=newNode;
	}
	void pushBack(int data){
		Node_IntersectionPointOf2LinkedList lastNode=new Node_IntersectionPointOf2LinkedList(data);
		if(head==null)head=lastNode;
		else{
			Node_IntersectionPointOf2LinkedList current=head;
			while(current.next!=null)current=current.next;
			current.next=lastNode;
		}
	}
	void printList(){
		Node_IntersectionPointOf2LinkedList current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
}

class Node_IntersectionPointOf2LinkedList{
	int data;
	Node_IntersectionPointOf2LinkedList next;
	public Node_IntersectionPointOf2LinkedList(int data){
		this.data=data;
		this.next=null;
	}
}