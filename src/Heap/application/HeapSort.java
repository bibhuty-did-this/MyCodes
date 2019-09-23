package Heap.application;

public class HeapSort{

	private int n;
	private int[] array;

	public HeapSort(int array[]){
		this.n=array.length;
		this.array=array;
	}

	public void sort(){

		// Only this much nodes are heapified because there is no meaning
		// of comparing leaf nodes with its leaves and don't do anything
		// hence by wasting operation time.
		for(int i=n/2-1;i>=0;--i)
			heapify(i,n);

		// Extract one by one element from the end
		for(int i=n-1;i>=0;--i){

			// Swap the root element to the leaf element at the end
			int temp=array[0];
			array[0]=array[i];
			array[i]=temp;

			// Heapify starting from node as swapping of nodes made it unbalanced
			// Note that heapify should be done with remaining reduced heap as
			// doing it including others will give incorrect solution.
			heapify(0,i);

		}
	}

	// max heap creation
	// n is added to ensure that upto which lower limit you want to check
	// for heapification.
	public void heapify(int i,int n){
		int l=2*i+1;
		int r=2*i+2;
		int largest=i;

		if(l<n && array[largest]<array[l])
			largest=l;
		if(r<n && array[largest]<array[r])
			largest=r;

		if(largest!=i){

			// swap the largest element to the top
			int swap=array[i];
			array[i]=array[largest];
			array[largest]=swap;

			// heapify down the bottom
			heapify(largest,n);
		}
	}

	public void printArray(){
		for(int i=0;i<n;++i)
			System.out.print(array[i]+" ");
		System.out.println();
	}

	public static void main(String[] args){
		int array[] = {12,21,19,11,13,5,6,7,20,25};
		HeapSort heapSort=new HeapSort(array);
		heapSort.printArray();
		heapSort.sort();
		heapSort.printArray();
	}
}
