package Queue.dataStructure;

public class Queue{
	int front,rear,size;
	int capacity;
	int array[];

	public Queue(int capacity){
		this.capacity=capacity;
		front=size=0;
		rear=capacity-1;
		array=new int[capacity];
	}


}
