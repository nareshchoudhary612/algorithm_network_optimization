package network_optimization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxBandwidthPathKruskal {

	public static int[] dad;
	public static int[] rank;
	MaxHeapForKruskal maxHeap;
	private static int[] status;
	private static int[] dadBFS;
	private static int[] bw;

	private static int BLACK = 2;
	private static int GREY = 1;
	private static int WHITE = 0;

	public Graph findMaxBandwidthPathByKruskal(Graph g, int source, int destination) {

		// Storing all edges in non decreasing order
		int numberOfEdge = g.numberOfEdge;

		long startTime = System.currentTimeMillis();
		maxHeap = new MaxHeapForKruskal(numberOfEdge);

		for (int i = 0; i < g.G.length; i++) {
			ArrayList<Edge> adjList = new ArrayList<>(g.getLinkedListAtPosition(i));

			for (Edge edge : adjList) {
				maxHeap.add(edge);
			}
		}
		long endTime = System.currentTimeMillis();
		// System.out.println("Time taken to insert all edges in Heap: "+
		// (endTime-startTime));

		// Initialize dad and rank for every vertex
		dad = new int[g.getNumberOfVertex()];
		rank = new int[g.getNumberOfVertex()];
		for (int i = 0; i < g.getNumberOfVertex(); i++) {
			dad[i] = i;
			rank[i] = 1;
		}

		// Merge into a Maximum Spanning Tree, newGraph stores all edges in MST
		Graph newGraph = new Graph(g.getNumberOfVertex());
		for (int e = 0; e < numberOfEdge; e++) {
			Edge edge = maxHeap.pollMax();
			
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
			rank[r2]++;
		}
	}

	public int bfs(Graph newGraph, int source, int destination) {
		status = new int[newGraph.getNumberOfVertex()];
		dadBFS = new int[newGraph.getNumberOfVertex()];
		bw = new int[newGraph.getNumberOfVertex()];
		for (int v = 0; v < newGraph.getNumberOfVertex(); v++) {
			bw[v] = Integer.MAX_VALUE;
			dadBFS[v] = -1;
			status[v] = WHITE;
		}
		
		status[source] = GREY;
		dad[source] = -1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);

		while (status[destination] != BLACK) { // && !queue.isEmpty()) {
			int u = queue.poll();
			ArrayList<Edge> uEdgeList = new ArrayList<Edge>(newGraph.getLinkedListAtPosition(u));
			for (Edge edge : uEdgeList) {
				int v = edge.getV();
				if (status[v] == WHITE) {
					status[v] = GREY;
					bw[v] = Math.min(bw[u], edge.getW());
					dadBFS[v] = u;
					queue.offer(v);
				} else if (status[v] == GREY && bw[v] < Math.min(bw[u], edge.getW())) {
					dadBFS[v] = u;
					bw[v] = Math.min(bw[u], edge.getW());

				}
			}
			status[u] = BLACK;
		}

		return bw[destination];
	}

}
