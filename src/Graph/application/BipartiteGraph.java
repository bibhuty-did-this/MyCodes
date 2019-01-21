package Graph.application;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// Undirected Graph
public class BipartiteGraph{

	private int V;
	private int[][] graph;
	int[] color;


	public BipartiteGraph(int[][] graph,int V){
		this.V=V;
		this.graph=graph;
		color=new int[V];
		Arrays.fill(color,-1);
	}

	boolean isBipartite(int src){

		Queue<Integer> queue=new ArrayDeque<>();

		color[src]=1; // Assign the first one a color
		queue.add(src); // Put it into the queue

		// Continue the changed BFS algorithm
		// As long as the queue is non-empty
		while(!queue.isEmpty()){

			// Get the top element of the queue
			int u=queue.poll();

			// Traverse through all the adjacent vertices
			for(int v=0;v<V;++v){

				// If there is an edge present
				if(graph[u][v]==1){

					// If the edge is not colored
					if(color[v]==-1){

						// Give it another color
						color[v]=1-color[u];

						// Add it to the queue(BFS property)
						queue.add(v);
					}
					// If the subsequent edge present is already colored and has the same
					// color as the one, then the graph can't be bipartite
					else if(color[v]==color[u])
						return false;
				}

			}
		}


		// If everything goes right the graph is bipartite
		return true;
	}


	// If any component of the graph is not bipartite
	// the graph is not bipartite
	public boolean isBipartite(){
		for(int i=0;i<V;++i)
			if(color[i]==-1)
				if(!isBipartite(i))
					return false;
		return true;

	}

	public static void main(String[] args){
		int graph[][] = {{0, 1, 0, 1},
				{1, 0, 1, 0},
				{0, 1, 0, 1},
				{1, 0, 1, 0}
		};
		BipartiteGraph b = new BipartiteGraph(graph,4);
		if (b.isBipartite())
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
