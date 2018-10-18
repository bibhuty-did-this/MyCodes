package LinkedList.applications;

public class CheckIfLinkedListIsPalindrome{
	public static void main(String[] args){
		int num=1;
		LinkedList_CheckIfLinkedListIsPalindrome list=new LinkedList_CheckIfLinkedListIsPalindrome();
		while(num!=0){
			list.push(num%10);
			num=num/10;
		}
		list.printList();
		if(list.isPalindrome())
			System.out.println("The linked list is a palindrome");
		else
			System.out.println("The linked list is not a palindrome");
	}
}

class LinkedList_CheckIfLinkedListIsPalindrome{
	Node_CheckIfLinkedListIsPalindrome head;
	void push(int data){
		Node_CheckIfLinkedListIsPalindrome lastNode=new Node_CheckIfLinkedListIsPalindrome(data);
		if(head==null)head=lastNode;
		else{
			Node_CheckIfLinkedListIsPalindrome last=head;
			while(last.next!=null)last=last.next;
			last.next=lastNode;
		}
	}
	void printList(){
		Node_CheckIfLinkedListIsPalindrome current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
	int length(){
		Node_CheckIfLinkedListIsPalindrome current=head;
		int count=0;
		while(current!=null){
			current=current.next;
			++count;
		}
		return count;
	}
	boolean isPalindromeByLength(){
		Node_CheckIfLinkedListIsPalindrome node=head;
		int totalNodes=length();
		if(totalNodes==1)return true;
		if(totalNodes==2){
			if(head.data==head.next.data)return true;
			else return false;
		}
		int traverse=totalNodes/2;
		int store=traverse;
		Node_CheckIfLinkedListIsPalindrome prev=null;
		while(traverse-->0){
			Node_CheckIfLinkedListIsPalindrome next=node.next;
			node.next=prev;
			prev=node;
			node=next;
		}
		Node_CheckIfLinkedListIsPalindrome nextStart=store%2==1?node.next:node;
		node=prev;
		System.out.println(node.data+" "+nextStart.data);
		while(node!=null && nextStart!=null){
			if(node.data!=nextStart.data)return false;
			node=node.next;
			nextStart=nextStart.next;
		}
		return true;
	}

	Node_CheckIfLinkedListIsPalindrome left;
	boolean isPalindromeUtility(Node_CheckIfLinkedListIsPalindrome right){
		left=head;

		if(right==null)return true;

		boolean isPalindrome=isPalindromeUtility(right.next);

		if(!isPalindrome)return false;

		boolean foundPalindrome=(right.data==(left).data);
		left=left.next;

		return foundPalindrome;
	}
	boolean isPalindrome(){
		return isPalindromeUtility(head);
	}
}

class Node_CheckIfLinkedListIsPalindrome{
	int data;
	Node_CheckIfLinkedListIsPalindrome next;
	public Node_CheckIfLinkedListIsPalindrome(int data){
		this.data=data;
		this.next=null;
	}
}