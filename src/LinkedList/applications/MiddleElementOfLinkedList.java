package LinkedList.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MiddleElementOfLinkedList{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int testCases=Integer.parseInt(in.nextToken());
		while(testCases-->0){
			int n=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			LinkedList_MiddleElementOfLinkedList list=new LinkedList_MiddleElementOfLinkedList();
			in=new StringTokenizer(br.readLine());
			while(n-->0)list.addToLast(Integer.parseInt(in.nextToken()));
			//list.printList();
			out.println(list.printMiddleElement_Enhanced());

		}
		out.close();
	}
}

class LinkedList_MiddleElementOfLinkedList{
	Node_MiddleElementOfLinkedList head;

	void addToFirst(int data){
		if(head==null)head=new Node_MiddleElementOfLinkedList(data);
		else{
			Node_MiddleElementOfLinkedList current=new Node_MiddleElementOfLinkedList(data);
			current.next=head;
			head=current;
		}
	}

	void addToLast(int data){
		if(head==null)head=new Node_MiddleElementOfLinkedList(data);
		else{
			Node_MiddleElementOfLinkedList lastNode=new Node_MiddleElementOfLinkedList(data);
			Node_MiddleElementOfLinkedList last=head;
			while(last.next!=null)last=last.next;
			last.next=lastNode;
		}
	}

	void printList(){
		System.out.println("The linked list is\n");
		Node_MiddleElementOfLinkedList current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}

	int printMiddleElement_Enhanced(){
		if(head==null)return -1;
		Node_MiddleElementOfLinkedList fast=head;
		Node_MiddleElementOfLinkedList slow=head;
		//fast!=null covers the condition for even numbers if the later one is taken
		//fast.next.next=null covers the condition of even numbers if the former one is taken
		//fast.next!=null covers the condition of odd numbers
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}

	int printMiddleElement(){
		int length=recursiveLength();
		if(length==0)return -1;
		else {
			length=length/2+1;
			--length;
			Node_MiddleElementOfLinkedList current=head;
			while(length-->0){
				current=current.next;
			}
			return current.data;
		}
	}

	int iterativeLength(){
		int i=0;
		Node_MiddleElementOfLinkedList current=head;
		while(current!=null){
			++i;
			current=current.next;
		}
		return i;
	}

	int recursiveLengthUtil(Node_MiddleElementOfLinkedList Node_MiddleElementOfLinkedList){
		if(Node_MiddleElementOfLinkedList!=null) return 1+recursiveLengthUtil(Node_MiddleElementOfLinkedList.next);
		else return 0;
	}

	int recursiveLength(){
		return recursiveLengthUtil(head);
	}
}

class Node_MiddleElementOfLinkedList{
	int data;
	Node_MiddleElementOfLinkedList next;
	Node_MiddleElementOfLinkedList(int data){
		this.data=data;
		this.next=null;
	}
}