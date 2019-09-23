package Graph.application;

import java.util.LinkedList;
import java.util.Stack;

// Time complexity O(V+E)
// Toplogical Ordering in directed acyclic graph is nothing but ordering
// of vertices in such a way that for a vertex u -> v, u comes always
// before v. It is not possible is the graph is not acyclic.
public class TopologicalSorting{

	private int V;
	private LinkedList<Integer>[] graph;

	public TopologicalSorting(int V){
		this.V=V;
		graph=new LinkedList[V];
		for(int i=0;i<V;++i)
			graph[i]=new LinkedList<>();
	}

	public void addEdge(int u,int v){
		graph[u].add(v);
	}

	public void topologicalSort(int u,Stack stack,boolean[] visited){
		visited[u]=true;
		for(int v:graph[u])
			if(!visited[v])
				topologicalSort(v,stack,visited);
		stack.push(u);
	}

	public void topologicalSort(){
		Stack stack=new Stack<>();
		boolean[] visited=new boolean[V];
		for(int u=0;u<V;++u)
			if(!visited[u])
				topologicalSort(u,stack,visited);
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
		System.out.println();
	}


	public static void main(String[] args){
		TopologicalSorting g = new TopologicalSorting(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " +
				"sort of the given graph");
		g.topologicalSort();
	}
}
