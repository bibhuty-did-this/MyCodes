package Graph.application;

import java.util.LinkedList;

public class CycleDetectionInUndirectedGraph{

	private int V;
	private LinkedList<Integer>[] graph;

	public CycleDetectionInUndirectedGraph(int V){
		this.V=V;
		graph=new LinkedList[V];
		for(int i=0;i<V;++i)
			graph[i]=new LinkedList();
	}

	public void addEdge(int u,int v){
		graph[u].add(v);
		graph[v].add(u);
	}

	public boolean isCyclePresent(int u, boolean[] isVisited, int parent){

		isVisited[u]=true;

		for(int v:graph[u]){
			if(!isVisited[v]){ // Braces are most essential part here
				if(isCyclePresent(v,isVisited,u))
					return true;
			}else if(v!=parent)
					return true;
		}
		return false;
	}

	public boolean isCyclePresent(){
		boolean[] isVisited=new boolean[V];
		for(int u=0;u<V;++u)
			if(!isVisited[u])
				if(isCyclePresent(u,isVisited,-1))
					return true;
		return false;
	}

	public static void main(String[] args){
		// Create a graph given in the above diagram
		CycleDetectionInUndirectedGraph g1 = new CycleDetectionInUndirectedGraph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isCyclePresent())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		CycleDetectionInUndirectedGraph g2 = new CycleDetectionInUndirectedGraph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCyclePresent())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
	}
}
