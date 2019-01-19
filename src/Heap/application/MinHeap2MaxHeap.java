package Heap.application;

// Given a min heap, convert it to max heap in O(n) time
public class MinHeap2MaxHeap{

	public int Heap[];
	int MAX_CAPACITY;
	int index;

	public MinHeap2MaxHeap(int MAX_CAPACITY){
		this.MAX_CAPACITY=MAX_CAPACITY;
		this.Heap=new int[this.MAX_CAPACITY];
		this.index=0;
	}

	public int parent(int i){
		return (i-1)/2;
	}

	public int leftChild(int i){
		return 2*i+1;
	}

	public int rightChild(int i){
		return 2*i+2;
	}

	public void insertMinHeap(int data){

		if(index==MAX_CAPACITY){
			System.out.println("\nMemory Overflow in Heap");
			return;
		}

		Heap[index++]=data;
		int i=index-1;
		while(i!=0 && Heap[parent(i)]>Heap[i]){
			// Swap the nodes
			int temp=Heap[i];
			Heap[i]=Heap[parent(i)];
			Heap[parent(i)]=temp;

			// Move up for further investigation
			i=parent(i);
		}
	}

	public void maxHeapify(int i){
		int maximum=i;
		int left=leftChild(i);
		int right=rightChild(i);

		if(left<index && Heap[maximum]<Heap[left])
			maximum=left;

		if(right<index && Heap[maximum]<Heap[right])
			maximum=right;

		if(maximum!=i){
			// Swap nodes between minimum and i
			int temp=Heap[i];
			Heap[i]=Heap[maximum];
			Heap[maximum]=temp;

			maxHeapify(maximum);
		}
	}

	// Time complexity is O(n)
	public void minToMaxHeapConversion(){
		// Start from the rightmost node which is not a leaf
		// node and traverse up and heapify each and every node
		// up in the same process
		for(int i=(index-2)/2;i>=0;--i)
			maxHeapify(i);
	}

	public void printHeap(){
		for(int i=0;i<index;++i)
			System.out.print(Heap[i]+" ");
		System.out.println();
	}

	public static void main(String[] args){
		int array[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
		MinHeap2MaxHeap heap=new MinHeap2MaxHeap(20);
		for(int data:array)
			heap.insertMinHeap(data);
		System.out.print("The min heap array is: ");
		heap.printHeap();
		heap.minToMaxHeapConversion();
		System.out.print("The converted max heap is: ");
		heap.printHeap();
	}
}
