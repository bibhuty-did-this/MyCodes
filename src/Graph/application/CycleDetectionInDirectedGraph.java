package Graph.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CycleDetectionInDirectedGraph{
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
		}

		public boolean findCycle(int s,boolean inRecursion[],boolean isVisited[]){
			if(inRecursion[s])
				return true;

			if(isVisited[s])
				return false;

			isVisited[s]=true;
			inRecursion[s]=true;

			for(int v:adjList[s])
				if(findCycle(v,inRecursion,isVisited))
					return true;

			inRecursion[s]=false;
			return false;
		}

		public boolean cycleExists(){
			boolean[] inRecursion=new boolean[V];
			boolean[] isVisited=new boolean[V];
			for(int i=0;i<V;++i)
				if(findCycle(i,inRecursion,isVisited))
					return true;
			return false;
		}
	}
	public static void main(String[] args) throws IOException{
		/*
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if(graph.cycleExists())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't "
					+ "contain cycle");
		*/
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer in=new StringTokenizer(br.readLine());
		int testCases=Integer.parseInt(in.nextToken());
		while(testCases-->0){
			in=new StringTokenizer(br.readLine());
			int vertices=Integer.parseInt(in.nextToken()),edges=Integer.parseInt(in.nextToken());
			Graph g=new Graph(vertices);
			in=new StringTokenizer(br.readLine());
			while(edges-->0)
				g.addEdge(Integer.parseInt(in.nextToken()),Integer.parseInt(in.nextToken()));
			if(g.cycleExists())
				out.println(1);
			else out.println(0);
		}

		out.close();
	}
}
