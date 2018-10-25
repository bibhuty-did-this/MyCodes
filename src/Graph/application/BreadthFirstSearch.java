package Graph.application;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch{
	static class Graph{
		int V;
		LinkedList<Integer>[] adjList;

		public Graph(int V){
			this.V=V;
			adjList=new LinkedList[V];
			for(int i=0;i<V;++i)
				adjList[i]=new LinkedList<>();
		}
		public void addEdge(int u,int v){
			adjList[u].add(v);
			adjList[v].add(u);
		}
		public void BFS(int s){
			boolean[] visited=new boolean[V];
			Queue<Integer> queue=new LinkedList<>();
			queue.add(s);
			visited[s]=true;

			while(!queue.isEmpty()){
				int current=queue.poll();
				System.out.print(current+" ");
				for(int vertex:adjList[current]){
					if(!visited[vertex]){
						queue.add(vertex);
						visited[vertex]=true;
					}
				}
			}

		}
	}

	public static void main(String[] args){
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal "+
				"(starting from vertex 2)");

		g.BFS(2);
	}
}
