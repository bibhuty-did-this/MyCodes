package Graph.application;

import java.util.LinkedList;

public class DepthFirstSearch{
	static class Graph{
		int V;
		LinkedList<Integer>[] adjList;
		public Graph(int V){
			this.V=V;
			adjList=new LinkedList[V];
			for(int i=0;i<V;++i)
				adjList[i]=new LinkedList();
		}
		public void addEdge(int u,int v){
			adjList[u].add(v);
			adjList[v].add(u);
		}

		public void DFS_Util(int s,boolean visited[]){
			visited[s]=true;
			System.out.print(s+" ");
			for(int vertex:adjList[s]){
				if(!visited[vertex])
					DFS_Util(vertex,visited);
			}
		}
		public void DFS(int s){
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;++i)
				if(!visited[i])
					DFS_Util(s,visited);
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

		System.out.println("Following is Depth First Traversal "+
				"(starting from vertex 2)");

		g.DFS(2);
	}
}
