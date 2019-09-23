package LinkedList.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RotatingALinkedList{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int testCases=Integer.parseInt(in.nextToken());
		while(testCases-->0){
			int n=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			in=new StringTokenizer(br.readLine());
			LinkedList_RotatingALinkedList list=new LinkedList_RotatingALinkedList();
			while(n-->0)
				list.addAtEnd(Integer.parseInt(in.nextToken()));
			int k=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			list.rotate(k);
			list.printList();
		}
		out.close();

	}
}

class Node_RotatingALinkedList{
	int data;
	Node_RotatingALinkedList next;
	public Node_RotatingALinkedList(int data){
		this.data=data;
		this.next=null;
	}
}

class LinkedList_RotatingALinkedList{
	Node_RotatingALinkedList head;
	void rotate(int k){
		Node_RotatingALinkedList current=head;
		Node_RotatingALinkedList lastPointer=head;
		--k;
		while(k-->0)
			current=current.next;
		if(current.next==null)return;
		head=current.next;
		current.next=null;
		current=head;
		while(current.next!=null)current=current.next;
		current.next=lastPointer;

	}
	void addAtFront(int data){
		if(head==null){
			head=new Node_RotatingALinkedList(data);
			return;
		}
		Node_RotatingALinkedList front=new Node_RotatingALinkedList(data);
		front.next=head;
		head=front;
	}
	void addAtEnd(int data){
		if(head==null)head=new Node_RotatingALinkedList(data);
		else{
			Node_RotatingALinkedList current=head;
			while(current.next!=null)current=current.next;
			current.next=new Node_RotatingALinkedList(data);
		}
	}
	void printList(){
		Node_RotatingALinkedList current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}

}