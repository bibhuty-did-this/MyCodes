package LinkedList.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ReversingALinkedList{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int testCases=Integer.parseInt(in.nextToken());
		while(testCases-->0){
			int n=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			in=new StringTokenizer(br.readLine());
			LinkedList_ReversingALinkedList list=new LinkedList_ReversingALinkedList();
			while(n-->0)
				list.addAtEnd(Integer.parseInt(in.nextToken()));
			list.reverseList_iterative();
			list.printList();
		}
		out.close();
	}
}

class Node_ReversingALinkedList{
	int data;
	Node_ReversingALinkedList next;
	Node_ReversingALinkedList(int data){
		this.data=data;
		this.next=null;
	}
}

class LinkedList_ReversingALinkedList{
	Node_ReversingALinkedList head;
	void addAtBeginning(int data){
		if(head==null)head=new Node_ReversingALinkedList(data);
		else{
			Node_ReversingALinkedList current=new Node_ReversingALinkedList(data);
			current.next=head;
			head=current;
		}
	}
	void addAtEnd(int data){
		if(head==null)head=new Node_ReversingALinkedList(data);
		else{
			Node_ReversingALinkedList current=head;
			while(current.next!=null)current=current.next;
			current.next=new Node_ReversingALinkedList(data);
		}
	}
	void printList(){
		Node_ReversingALinkedList current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
	Node_ReversingALinkedList newHead;

	void reverseListUtil(Node_ReversingALinkedList current, Node_ReversingALinkedList prev){
		Node_ReversingALinkedList after=prev;
		Node_ReversingALinkedList before=current;
		if(current.next==null){
			head=current;
			before.next=after;
			return;
		}
		reverseListUtil(current.next,current);
		before.next=after;
	}
	void reverseList_recursive(){
		reverseListUtil(head,null);
	}
	void reverseList_iterative(){
		if(head==null)return;
		Node_ReversingALinkedList previous=null;
		Node_ReversingALinkedList current=head;
		Node_ReversingALinkedList next=null;
		while(current!=null){
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		head=previous;
	}
}