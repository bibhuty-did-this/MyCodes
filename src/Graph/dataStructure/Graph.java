package Graph.dataStructure;

import java.util.LinkedList;

/**
 * Pros: Space efficient
 * Cons: Can't really find in O(1) time if an edge exists or not
 *       need O(V) time for it
 */
public class Graph{
	int V; // Number of vertices in the graph
	LinkedList<Integer>[] adjList; // Data structure for representation

	public Graph(int V){
		this.V=V;

		adjList=new LinkedList[V];

		for(int i=0;i<V;++i)
			adjList[i]=new LinkedList<>();
	}

	// Adding of an edge assuming it is undirected graph
	public void addEdge(int u,int v){
		adjList[u].add(v);
		adjList[v].add(u);
	}

	// Printing the entire graph
	public void printGraph(){
		for(int i=0;i<V;++i){
			System.out.println("The vertices connected to vertex "+i+" are ");
			for(int j:adjList[i])
				System.out.print(j+" ");
			System.out.println();
		}
	}

	public static void main(String[] args){
		// create the graph given in above figure 
		int V = 5;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		// print the adjacency list representation of  
		// the above graph 
		graph.printGraph();
	}
}
