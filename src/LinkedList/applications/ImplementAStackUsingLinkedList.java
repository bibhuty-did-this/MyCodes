package LinkedList.applications;

public class ImplementAStackUsingLinkedList{
	public static void main(String[] args){
		Stack stack=new Stack();
		int[] numbers=new int[]{
				0,1,2,3,4,5,6
		};
		stack.pop();
		for(int num:numbers)stack.push(num);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
	}
}

class Stack{
	Node_ImplementAStackUsingLinkedList top;
	boolean isEmpty(){
		return top==null?true:false;
	}
	void push(int data){
		Node_ImplementAStackUsingLinkedList node=new Node_ImplementAStackUsingLinkedList(data);
		node.next=top;
		top=node;
	}
	void pop(){
		if(isEmpty())System.out.println("The stack is empty");
		else{
			System.out.println("The popped element is "+top.data);
			top=top.next;
		}
	}
	int peek(){
		if(isEmpty())return Integer.MIN_VALUE;
		else return top.data;
	}
}

class Node_ImplementAStackUsingLinkedList{
	int data;
	Node_ImplementAStackUsingLinkedList next;
	public Node_ImplementAStackUsingLinkedList(int data){
		this.data=data;
		this.next=null;
	}
}