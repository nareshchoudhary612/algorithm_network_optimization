package network_optimization;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxBandwidthPathDijkstra2 {

	int[] status;
	int[] dad;
	int[] bandwidth;

	public int WHITE = 0;
	public int GREY  = 1;
	public int BLACK = 2;

	public int findMaxBandwidthPathDijkstra2( Graph g, int s, int t) {
		
		int n = g.getNumberOfVertex();
		status = new int[n];
		dad = new int[n];
		bandwidth = new int[n];
		MaxHeap maxHeap = new MaxHeap(n);
		//make all nodes white
		for(int i=0; i<n; i++) {
			status[i] = WHITE;
			bandwidth[i] = Integer.MAX_VALUE;
		}
		
		// initialize source node
		status[s] = BLACK;
		dad[s]=0;
		
		//update vertex v connected to u
		ArrayList<Edge> adjList = new ArrayList<>(g.getLinkedListAtPosition(s));
		for(Edge edge: adjList) {
			int v = edge.getV();
			status[v] = GREY;
			dad[v] = s;
			bandwidth[v] = edge.getW();
			//System.out.println("Adding vertex to heap: " + v + " with weight: " + bandwidth[v]  );
			maxHeap.add(v, bandwidth[v]);
		}
		
		while(status[t] != BLACK) {
			//maxHeap.printH();
			int u = maxHeap.pollMax();
			
			//System.out.println("polled from heap: " +u);
			status[u] = BLACK;
			
			ArrayList<Edge> adjacencyListOfU = new ArrayList<>(g.getLinkedListAtPosition(u));
			
			for(Edge edge: adjacencyListOfU) { // for each vertex connected to u
				
				int v = edge.getV();
				
				if(status[v] == WHITE) {
					status[v] = GREY;
					dad[v] = u;
					bandwidth[v] = Math.min(bandwidth[u], edge.getW());
					//System.out.println("Adding element to heap: " + v + " with weight: " + bandwidth[v]  );
					maxHeap.add(v, bandwidth[v]);
				}
				else if(status[v] == GREY && bandwidth[v] < Math.min(bandwidth[u], edge.getW())) {
					dad[v] = u;
					bandwidth[v] = Math.min(bandwidth[u], edge.getW());
					maxHeap.delete(v);
					//System.out.println("Adding vertex to heap: " + v + " with weight: " + bandwidth[v]  );
					maxHeap.add(v, bandwidth[v]);
				}
			}
			
		}
		
		
		return bandwidth[t];
	}
}
