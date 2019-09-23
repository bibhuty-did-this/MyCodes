package Heap.dataStructure;

public class MinHeap{

	private int[] Heap;
	private int index;
	private int MAX_SIZE;

	public MinHeap(int MAX_SIZE){
		this.MAX_SIZE=MAX_SIZE;
		this.index=0;
		this.Heap=new int[this.MAX_SIZE];
	}

	int parent(int i){
		return (i-1)/2;
	}

	int leftChild(int i){
		return 2*i + 1;
	}

	int rightChild(int i){
		return 2*i + 2;
	}

	/**
	 * Inserts key into a min heap. First it inserts a key into the
	 * leaf. It checks for the retention of min heap value by comparing it
	 * with the value of the parent of the leaf. Then it moves the data value
	 * up the tree in case the min heap property is violated.
	 *
	 * @param key
	 */
	void insertKey(int key){

		// Check for the overflow
		if(index==MAX_SIZE){
			System.out.println("Memory Overflow\n");
			return;
		}

		// Add the key to the leaf node
		// And increase the index
		Heap[index++]=key;

		// While the `key` is not at its proper position fix it
		int i=index-1;
		while(i!=0 && Heap[parent(i)]>Heap[i]){

			// Swap the values
			int temp=Heap[parent(i)];
			Heap[parent(i)]=Heap[i];
			Heap[i]=temp;

			// Move up the ladder
			i=parent(i);
		}

		// printHeap();

	}

	/**
	 * It decreases the value of the at the `index` to `decVal`. It
	 * is assumed that `decVal` is less than new val.
	 *
	 * @param index
	 * @param decVal
	 */
	void decreaseKey(int index,int decVal){
		Heap[index]=decVal;

		// When the changed value violates the MinHeap property
		while(index!=0 && Heap[parent(index)]>Heap[index]){

			// Swap the nodes
			int temp=Heap[parent(index)];
			Heap[parent(index)]=Heap[index];
			Heap[index]=temp;

			// Move up the ladder
			index=parent(index);
		}
	}

	/**
	 * A recursive method to heapify the entire tree. It ensures that all other
	 * nodes are in place except for one node which we need to recursively heapify
	 * starting from some given root node.
	 *
	 * One more property of heapify is in order to heapify a particular node we
	 * need to ensure that all the child nodes are heapified order.
	 *
	 * @param i
	 */
	void minHeapify(int i){
		int l=leftChild(i);
		int r=rightChild(i);

		int smallest=i;

		if(l<index && Heap[l]<Heap[i])
			smallest=l;
		// This step is there to ensure that largest element goes to the top
		if(r<index && Heap[r]<Heap[smallest])
			smallest=r;

		if(smallest!=i){
			int temp=Heap[smallest];
			Heap[smallest]=Heap[i];
			Heap[i]=temp;

			minHeapify(smallest);
		}
	}

	/**
	 * This method removes the root node and returns it value as
	 * the minimum value and then rearranges the tree also so that
	 * the heap property is not violated.
	 *
	 * @return minimum value or root of the heap
	 */
	int extractMin(){

		// In case no value is present in the heap
		if(index<=0)
			return Integer.MAX_VALUE;

		// In case there is only one element in the heap
		if(index==1)
			return Heap[--index];

		int minimum=Heap[0]; // store the minimum value
		Heap[0]=Heap[--index]; // store the last leaf value at root and decrease the heap size

		minHeapify(0); // Heapify the heap

		return minimum;
	}

	/**
	 * Populate the index with the most minimum value, and in the process that index will
	 * be moved to the top. Extract the minimum value and flush it to dump, and in this
	 * process we'll heapify the tree.
	 *
	 * @param i
	 */
	void deleteKey(int i){
		decreaseKey(i,Integer.MIN_VALUE);
		extractMin();
	}

	/**
	 *
	 * @return get the minimum value without deleting it.
	 */
	int getMin(){
		return Heap[0];
	}

	void printHeap(){
		for(int i=0;i<index;++i){
			System.out.print(Heap[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args){
		MinHeap minHeap=new MinHeap(11);
		minHeap.insertKey(3);
		minHeap.insertKey(2);
		minHeap.deleteKey(1);
		minHeap.insertKey(15);
		minHeap.insertKey(5);
		minHeap.insertKey(4);
		minHeap.insertKey(45);

		System.out.println("Getting the minimum value of the heap without extracting it : "+minHeap.getMin());
		System.out.println("Extracting the minimum value of the heap : "+minHeap.extractMin());
		minHeap.decreaseKey(2,1);
		System.out.println("After decreasing the value of index 2 to 1 the min value in the heap is : "+minHeap.getMin());
		// minHeap.printHeap();

	}
}
