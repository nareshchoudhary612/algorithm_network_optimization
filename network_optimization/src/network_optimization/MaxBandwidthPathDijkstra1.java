package network_optimization;

import java.util.ArrayList;

public class MaxBandwidthPathDijkstra1 {
	 public static int[] status;
	    public static int[] dad;
	    public static int[] bw;

	    public static int INTREE = 2;
	    public static int FRINGE = 1;
	    public static int UNSEEN = 0;

	    public  int maxBandwidthPath(Graph graph, int source, int destination) {
	        status = new int[graph.getNumberOfVertex()];
	        dad = new int[graph.getNumberOfVertex()];
	        bw = new int[graph.getNumberOfVertex()];

	        for (int i = 0; i < graph.getNumberOfVertex(); i++) {
	            status[i] = UNSEEN;
	            bw[i] = Integer.MAX_VALUE;
	        }

	        //Update info of source
	        status[source] = INTREE;
	        dad[source] = -1;

	        //Update vertices adjacent to source
	        ArrayList<Edge> verticesToSource = new ArrayList<Edge>(graph.getLinkedListAtPosition(source));// getAdj()[source];
	        for (Edge edge : verticesToSource) {
	            int w = edge.getV();// getOtherVertex(source);
	            status[w] = FRINGE;
	            dad[w] = source;
	            bw[w] = edge.getW(); // getWeight();
	            //System.out.println("TEST " + bw[w]);
	        }
	        //System.out.println("TEST " + maxBandwidth + " TEST " + maxIndex);

	        //Dijsktra algorithm to find destination
	        int count = 0;
	        while (status[destination] != INTREE) {
	            count++;
	            //pick a fringe v with max bw[v], that is maxIndex
	            int maxBandwidth = Integer.MIN_VALUE, maxIndex = -1;
	            for (int i = 0; i < graph.getNumberOfVertex() ;i++) {
	                if (status[i] == FRINGE) {
	                    //System.out.println("TEST " + i + " TEST " + bw[i]);
	                    if (bw[i] > maxBandwidth) {
	                        maxBandwidth = bw[i];
	                        maxIndex = i;
	                        //System.out.println("TEST maxBandwidth " + maxBandwidth);
	                    }
	                }
	            }
	            status[maxIndex] = INTREE;
	            //System.out.println("TEST " + maxBandwidth + " TEST " + maxIndex);

	            ArrayList<Edge> verticesToV = new ArrayList<Edge>(graph.getLinkedListAtPosition(maxIndex));// getAdj()[maxIndex];
	            //System.out.println("TEST verticesToV " + verticesToV);
	            for (Edge edge : verticesToV) {
	                int w = edge.getV();// getOtherVertex(maxIndex);
	                //System.out.println("TEST " + w);
	                if (status[w] == UNSEEN) {
	                    dad[w] = maxIndex;
	                    status[w] = FRINGE;
	                    bw[w] = Math.min(bw[maxIndex], edge.getW()); // getWeight());
	                } else if(status[w] == FRINGE && bw[w] < Math.min(bw[maxIndex], edge.getW())) {
	                    dad[w] = maxIndex;
	                    bw[w] = Math.min(bw[maxIndex], edge.getW());
	                }
	            }
	        }
	        //System.out.println("TEST count " + count);
	        return bw[destination];
	}
}
