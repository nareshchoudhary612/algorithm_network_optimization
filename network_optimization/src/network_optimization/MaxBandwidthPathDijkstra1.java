package network_optimization;


import java.util.HashSet;

public class MaxBandwidthPathDijkstra1 {
	
    enum Color {
        WHITE, GREY, BLACK
    }

    private static Color[] status;
    private static int[] dad;
    private static int[] bw;
    private static HashSet<Integer> vertexSet;

    public  int maxBandwidthPath(Graph g, int source, int destination) {
        int n = g.getNumberOfVertex();
        status = new Color[n];
        dad = new int[n];
        bw  = new int[n];
        vertexSet = new HashSet<>();

        for (int i = 0; i < g.getNumberOfVertex(); i++) {
            status[i] = Color.WHITE;
            bw[i] = Integer.MAX_VALUE;
        }

        // put source point in-tree
        status[source] = Color.BLACK;
        dad[source] = -1;

        // visit the point adj to the source
        for (Edge e : g.getLinkedListAtPosition(source)){
            int w = e.getV();
            status[w] = Color.GREY;
            dad[w] = source;
            bw[w] = e.w;
           
            vertexSet.add(w);
        }
        
        while (!vertexSet.isEmpty()) {
            int maxIndex = -1;
            int maxBwVal = Integer.MIN_VALUE;
            for (int v : vertexSet) {
                if (bw[v] > maxBwVal) {
                    maxIndex = v;
                    maxBwVal = bw[v];
                }
            }
            vertexSet.remove(maxIndex);
            status[maxIndex] = Color.BLACK;

          
            for (Edge e : g.getLinkedListAtPosition(maxIndex)){
                int w = e.getV();// getEnd(maxIndex);
         //       int minBwValue = Math.min(bw[maxIndex], e.w);

                if (status[w] == Color.WHITE) {
                    dad[w] = maxIndex;
                    bw[w] = Math.min(bw[maxIndex], e.w);
                    status[w] = Color.GREY;   
                    vertexSet.add(w);
                }
                else if (status[w] == Color.GREY && bw[w] < Math.min(bw[maxIndex], e.w)) {
                    dad[w] = maxIndex;
                    bw[w] = Math.min(bw[maxIndex], e.w);
                }
            }
        }

        return bw[destination];
    }
}