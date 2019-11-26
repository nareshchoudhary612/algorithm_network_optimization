package network_optimization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxBandwidthPathKruskal2 {

	public static int[] dad;
	public static int[] rank;
	// public Graph g;
	MaxHeapForKruskal2 maxHeap;
	private static int[] status;
	private static int[] dadBFS;
	private static int[] bw;

	private static int BLACK = 2;
	private static int GREY = 1;
	private static int WHITE = 0;
	Set<String> s = new HashSet<String>();
	Edge[] edgeArray;

	public Graph findMaxBandwidthPathByKruskal(Graph g, int source, int destination) {

		// Storing all edges in non decreasing order
		//int numberOfEdge = g.getNumberOfEdge();
		int numberOfEdge = g.numberOfEdge;
	//	System.out.println(numberOfEdge);
		edgeArray = new Edge[numberOfEdge+1];
		
		long startTime = System.currentTimeMillis();
		maxHeap = new MaxHeapForKruskal2(numberOfEdge+1);

		//ArrayList<Edge> elist = new ArrayList<Edge>();
	//	Edge[] elist = new Edge[g.numberOfEdge];
		int k =0;
		for (int i = 0; i < g.G.length; i++) {
			ArrayList<Edge> adjList = new ArrayList<>(g.getLinkedListAtPosition(i));
			//elist.addAll(adjList);
			
			for(Edge edge: adjList) {
				//System.out.println(edge.ID);
			 // for (int j=0; j<adjList.size(); j++) { 
				  //maxHeap.insert(edge); // String key = edge.u+"|"+edge.v+"|"+edge.w;
				  // String key2 = edge.v+ "|"+edge.u+"|"+edge.w; 
				  // if(s.add(key) && s.add(key2)) 
				  maxHeap.add(edge.ID,edge.w);
				  edgeArray[edge.ID] = edge;
				  //elist.add(edge); 
				//  elist[k++] = adjList.get(j);
			  }
		}
		long endTime = System.currentTimeMillis();
	//	System.out.println("Time taken to insert all edges in Heap: "+ (endTime-startTime));
	//	Collections.sort(elist);
	//	startTime = System.currentTimeMillis();
	//	Arrays.sort(elist);
		//endTime = System.currentTimeMillis();
	//	System.out.println("Time taken for Arrays.sort: "+ (endTime-startTime));
		/*
		 * for(int i=0; i<elist.size(); i++) System.out.print(elist.get(i));
		 * //System.out.println(maxHeap); System.out.println();
		 */

		// Initialize dad and rank for every vertex
		dad = new int[g.getNumberOfVertex()];
		rank = new int[g.getNumberOfVertex()];
		for (int i = 0; i < g.getNumberOfVertex(); i++) {
			dad[i] = i;
			rank[i] = 1;
		}

		// Merge into a Maximum Spanning Tree, newGraph stores all edges in MST
		Graph newGraph = new Graph(g.getNumberOfVertex());
		// System.out.println("TEST heapNumber " + heap.getHeapNumber());
		for (int e = 0; e < numberOfEdge; e++) {
			
			startTime = System.currentTimeMillis();
			//Edge edge = elist[e];//Edge edge = elist.get(e);//
			Edge edge = edgeArray[maxHeap.pollMax()];
			endTime = System.currentTimeMillis();
		//	if((endTime-startTime)>1)
		//	System.out.println("Time taken for heap: "+ (endTime-startTime));
			
			
			// Find the ranks for start vertex and end vertex
			// vertices
			int U = edge.u;
			int V = edge.v;
			int R1 = find(U);
			int R2 = find(V);
			if (R1 != R2) {
				newGraph.addEdge(edge.u, edge.v, edge.w);
				union(R1, R2);
			}
			
		}
		
		return newGraph;
	}

	public static int find(int vertex) {
		int v = vertex;
		while (dad[v] != v) {
			v = dad[v];
		}
		return v;
	}

	public static void union(int r1, int r2) {
		if (rank[r1] > rank[r2]) {
			dad[r2] = r1;
		} else if (rank[r1] < rank[r2]) {
			dad[r1] = r2;
		} else {
			dad[r1] = r2;
			rank[r1]++;
		}
	}

	public int bfs(Graph newGraph, int source, int destination) {
		status = new int[newGraph.getNumberOfVertex()];
		dadBFS = new int[newGraph.getNumberOfVertex()];
		bw = new int[newGraph.getNumberOfVertex()];
		for (int v = 0; v < newGraph.getNumberOfVertex(); v++) {
			status[v] = WHITE;
			dadBFS[v] = -1;
			bw[v] = Integer.MAX_VALUE;
		}
		status[source] = GREY;
		dad[source] = -1;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);

		while (status[destination] != BLACK && !queue.isEmpty()) {
			int u = queue.poll();
			ArrayList<Edge> uEdgeList = new ArrayList<Edge>(newGraph.getLinkedListAtPosition(u));
			for (Edge edge : uEdgeList) {
				int v = edge.getV(); // getOtherVertex(u);
				if (status[v] == WHITE) {
					status[v] = GREY;
					bw[v] = Math.min(bw[u], edge.getW());// getWeight());
					dadBFS[v] = u;
					queue.offer(v);
				} else if (status[v] == GREY && bw[v] < Math.min(bw[u], edge.getW())) { // getWeight())) {
					dadBFS[v] = u;
					bw[v] = Math.min(bw[u], edge.getW()); // getWeight());
					
				}
			}
			status[u] = BLACK;
		}

		return bw[destination];
	}

}
