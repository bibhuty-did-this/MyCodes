package LinkedList.applications;

import java.util.Stack;

public class ReverseALinkedListInGroupOfGivenSize{
	public static void main(String args[]){
		int[] numbers=new int[]{
			3,2,1,6,5,4,9,8,7,12,11,10,14,13
		};
		LinkedList_ReverseALinkedListInGroupOfGivenSize list=new LinkedList_ReverseALinkedListInGroupOfGivenSize();
		for(int i:numbers)list.push(i);
		list.printList();
		//list.head=list.reverseInGroupOfN(list.head,3);
		list.head=list.reverseUsingStack(list.head,3);
		list.printList();
	}
}

class LinkedList_ReverseALinkedListInGroupOfGivenSize{
	Node_ReverseALinkedListInGroupOfGivenSize head;
	void pushAtFront(int data){
		Node_ReverseALinkedListInGroupOfGivenSize Node_ReverseALinkedListInGroupOfGivenSize=new Node_ReverseALinkedListInGroupOfGivenSize(data);
		if(head==null)head=Node_ReverseALinkedListInGroupOfGivenSize;
		else{
			Node_ReverseALinkedListInGroupOfGivenSize.next=head;
			head=Node_ReverseALinkedListInGroupOfGivenSize;
		}
	}
	void push(int data){
		Node_ReverseALinkedListInGroupOfGivenSize Node_ReverseALinkedListInGroupOfGivenSize=new Node_ReverseALinkedListInGroupOfGivenSize(data);
		if(head==null)head=Node_ReverseALinkedListInGroupOfGivenSize;
		else{
			Node_ReverseALinkedListInGroupOfGivenSize current=head;
			while(current.next!=null)current=current.next;
			current.next=Node_ReverseALinkedListInGroupOfGivenSize;
		}
	}
	Node_ReverseALinkedListInGroupOfGivenSize reverseInGroupOfN(Node_ReverseALinkedListInGroupOfGivenSize Node_ReverseALinkedListInGroupOfGivenSize,int n){
		Node_ReverseALinkedListInGroupOfGivenSize current=Node_ReverseALinkedListInGroupOfGivenSize;
		Node_ReverseALinkedListInGroupOfGivenSize prev=null;
		Node_ReverseALinkedListInGroupOfGivenSize next=null;
		int k=1;
		while(k<=n && current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			++k;
		}
		if(next!=null)
			Node_ReverseALinkedListInGroupOfGivenSize.next=reverseInGroupOfN(next,n);
		return prev;
	}
	Node_ReverseALinkedListInGroupOfGivenSize reverseUsingStack(Node_ReverseALinkedListInGroupOfGivenSize Node_ReverseALinkedListInGroupOfGivenSize,int n){
		Stack<Node_ReverseALinkedListInGroupOfGivenSize> stack=new Stack();
		Node_ReverseALinkedListInGroupOfGivenSize prev=null;
		Node_ReverseALinkedListInGroupOfGivenSize current=Node_ReverseALinkedListInGroupOfGivenSize;
		while(current!=null){
			int k=n;
			while(current!=null && k>0){
				stack.push(current);
				current=current.next;
				--k;
			}
			while(!stack.isEmpty()){
				if(prev==null){
					prev=stack.pop();
					head=prev;
				}else{
					prev.next=stack.pop();
					prev=prev.next;
				}
			}
		}
		prev.next=null;
		return head;
	}
	void printList(){
		Node_ReverseALinkedListInGroupOfGivenSize current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
}

class Node_ReverseALinkedListInGroupOfGivenSize{
	int data;
	Node_ReverseALinkedListInGroupOfGivenSize next;
	public Node_ReverseALinkedListInGroupOfGivenSize(int data){
		this.data=data;
		this.next=null;
	}
}
