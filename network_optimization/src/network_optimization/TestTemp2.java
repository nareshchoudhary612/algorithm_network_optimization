package network_optimization;

public class TestTemp2 {

	public static void main(String[] args) {
		int maxD2 = 0, maxK = 0, maxD1 = 0;
		Graph g = new Graph(10);
		System.out.println("Generating Graph");
		long startTime = System.currentTimeMillis();

		// g = graphGenerator.byDegree(10);
		// g = graphGenerator.byPercentage(1000);

		
		/*
		 * g.getLinkedListAtPosition(0).add(new Edge(0, 3, 13));
		 * g.getLinkedListAtPosition(0).add(new Edge(0, 8, 1));
		 */
		/*
		 * g.getLinkedListAtPosition(0).add(new Edge(0, 2,
		 * 6));g.getLinkedListAtPosition(0).add(new Edge(0, 6,
		 * 7));g.getLinkedListAtPosition(0).add(new Edge(0, 1,
		 * 6));g.getLinkedListAtPosition(1).add(new Edge(1, 7,
		 * 7));g.getLinkedListAtPosition(1).add(new Edge(1, 3, 4));
		 * g.getLinkedListAtPosition(1).add(new Edge(1, 5, 11));
		 * g.getLinkedListAtPosition(1).add(new Edge(1, 0, 6));
		 * g.getLinkedListAtPosition(1).add(new Edge(1, 2, 16));
		 * g.getLinkedListAtPosition(2).add(new Edge(2, 5, 14));
		 * g.getLinkedListAtPosition(2).add(new Edge(2, 9, 3));
		 * g.getLinkedListAtPosition(2).add(new Edge(2, 0, 6));
		 * g.getLinkedListAtPosition(2).add(new Edge(2, 1, 16));
		 * g.getLinkedListAtPosition(2).add(new Edge(2, 3, 10));
		 * g.getLinkedListAtPosition(3).add(new Edge(3, 9, 17));
		 * g.getLinkedListAtPosition(3).add(new Edge(3, 1, 4));
		 * g.getLinkedListAtPosition(3).add(new Edge(3, 0, 13));
		 * g.getLinkedListAtPosition(3).add(new Edge(3, 2, 10));
		 * g.getLinkedListAtPosition(3).add(new Edge(3, 4, 13));
		 * g.getLinkedListAtPosition(4).add(new Edge(4, 7, 17));
		 * g.getLinkedListAtPosition(4).add(new Edge(4, 9, 8));
		 * g.getLinkedListAtPosition(4).add(new Edge(4, 8, 19));
		 * g.getLinkedListAtPosition(4).add(new Edge(4, 3, 13));
		 * g.getLinkedListAtPosition(4).add(new Edge(4, 5, 20));
		 * g.getLinkedListAtPosition(5).add(new Edge(5, 7, 8));
		 * g.getLinkedListAtPosition(5).add(new Edge(5, 2, 14));
		 * g.getLinkedListAtPosition(5).add(new Edge(5, 1, 11));
		 * g.getLinkedListAtPosition(5).add(new Edge(5, 4, 20));
		 * g.getLinkedListAtPosition(5).add(new Edge(5, 6, 4));
		 * g.getLinkedListAtPosition(6).add(new Edge(6, 9, 3));
		 * g.getLinkedListAtPosition(6).add(new Edge(6, 8, 17));
		 * g.getLinkedListAtPosition(6).add(new Edge(6, 0, 7));
		 * g.getLinkedListAtPosition(6).add(new Edge(6, 5, 4));
		 * g.getLinkedListAtPosition(6).add(new Edge(6, 7, 15));
		 * g.getLinkedListAtPosition(7).add(new Edge(7, 5, 8));
		 * g.getLinkedListAtPosition(7).add(new Edge(7, 4, 17));
		 * g.getLinkedListAtPosition(7).add(new Edge(7, 1, 7));
		 * g.getLinkedListAtPosition(7).add(new Edge(7, 6, 15));
		 * g.getLinkedListAtPosition(7).add(new Edge(7, 8, 6));
		 * g.getLinkedListAtPosition(8).add(new Edge(8, 6, 17));
		 * g.getLinkedListAtPosition(8).add(new Edge(8, 4, 19));
		 * g.getLinkedListAtPosition(8).add(new Edge(8, 0, 1));
		 * g.getLinkedListAtPosition(8).add(new Edge(8, 7, 6));
		 * g.getLinkedListAtPosition(8).add(new Edge(8, 9, 12));
		 * g.getLinkedListAtPosition(9).add(new Edge(9, 6, 3));
		 * g.getLinkedListAtPosition(9).add(new Edge(9, 4, 8));
		 * g.getLinkedListAtPosition(9).add(new Edge(9, 3, 17));
		 * g.getLinkedListAtPosition(9).add(new Edge(9, 2, 3));
		 * g.getLinkedListAtPosition(9).add(new Edge(9, 8, 12));
		 */
		 
		g.getLinkedListAtPosition(0).add(new Edge(0,9,5));g.getLinkedListAtPosition(0).add(new Edge(0,2,15));g.getLinkedListAtPosition(0).add(new Edge(0,8,17));g.getLinkedListAtPosition(0).add(new Edge(0,6,14));g.getLinkedListAtPosition(0).add(new Edge(0,1,8));g.getLinkedListAtPosition(1).add(new Edge(1,9,12));g.getLinkedListAtPosition(1).add(new Edge(1,6,17));g.getLinkedListAtPosition(1).add(new Edge(1,5,6));g.getLinkedListAtPosition(1).add(new Edge(1,0,8));g.getLinkedListAtPosition(1).add(new Edge(1,2,14));g.getLinkedListAtPosition(2).add(new Edge(2,9,1));g.getLinkedListAtPosition(2).add(new Edge(2,8,2));g.getLinkedListAtPosition(2).add(new Edge(2,0,15));g.getLinkedListAtPosition(2).add(new Edge(2,1,14));g.getLinkedListAtPosition(2).add(new Edge(2,3,5));g.getLinkedListAtPosition(3).add(new Edge(3,7,4));g.getLinkedListAtPosition(3).add(new Edge(3,6,19));g.getLinkedListAtPosition(3).add(new Edge(3,5,8));g.getLinkedListAtPosition(3).add(new Edge(3,2,5));g.getLinkedListAtPosition(3).add(new Edge(3,4,7));g.getLinkedListAtPosition(4).add(new Edge(4,9,19));g.getLinkedListAtPosition(4).add(new Edge(4,8,2));g.getLinkedListAtPosition(4).add(new Edge(4,6,9));g.getLinkedListAtPosition(4).add(new Edge(4,3,7));g.getLinkedListAtPosition(4).add(new Edge(4,5,1));g.getLinkedListAtPosition(5).add(new Edge(5,9,7));g.getLinkedListAtPosition(5).add(new Edge(5,3,8));g.getLinkedListAtPosition(5).add(new Edge(5,1,6));g.getLinkedListAtPosition(5).add(new Edge(5,4,1));g.getLinkedListAtPosition(5).add(new Edge(5,6,20));g.getLinkedListAtPosition(6).add(new Edge(6,4,9));g.getLinkedListAtPosition(6).add(new Edge(6,3,19));g.getLinkedListAtPosition(6).add(new Edge(6,1,17));g.getLinkedListAtPosition(6).add(new Edge(6,0,14));g.getLinkedListAtPosition(6).add(new Edge(6,5,20));g.getLinkedListAtPosition(6).add(new Edge(6,7,16));g.getLinkedListAtPosition(7).add(new Edge(7,9,2));g.getLinkedListAtPosition(7).add(new Edge(7,3,4));g.getLinkedListAtPosition(7).add(new Edge(7,6,16));g.getLinkedListAtPosition(7).add(new Edge(7,8,4));g.getLinkedListAtPosition(8).add(new Edge(8,4,2));g.getLinkedListAtPosition(8).add(new Edge(8,2,2));g.getLinkedListAtPosition(8).add(new Edge(8,0,17));g.getLinkedListAtPosition(8).add(new Edge(8,7,4));g.getLinkedListAtPosition(8).add(new Edge(8,9,19));g.getLinkedListAtPosition(9).add(new Edge(9,7,2));g.getLinkedListAtPosition(9).add(new Edge(9,5,7));g.getLinkedListAtPosition(9).add(new Edge(9,4,19));g.getLinkedListAtPosition(9).add(new Edge(9,2,1));g.getLinkedListAtPosition(9).add(new Edge(9,1,12));g.getLinkedListAtPosition(9).add(new Edge(9,0,5));g.getLinkedListAtPosition(9).add(new Edge(9,8,19));

		
		System.out.println("number of edges" + g.getNumberOfEdge());
		long endTime = System.currentTimeMillis(); // g.print();

		System.out.println("Graph generated in: " + (endTime - startTime) + "ms");

		System.out.println("Calling Dijkstra1...");
		MaxBandwidthPathDijkstra1 maxBandwidthPathDijkstra1 = new MaxBandwidthPathDijkstra1();
		startTime = System.currentTimeMillis();
		maxD1 = maxBandwidthPathDijkstra1.maxBandwidthPath(g, 1, 9);
		endTime = System.currentTimeMillis();
		System.out.println("max weight by Dijkstra1: " + maxD1 + " found in " + (endTime - startTime) + "ms");

		System.out.println("Calling Dijkstra2...");
		MaxBandwidthPathDijkstra2 mb = new MaxBandwidthPathDijkstra2();
		startTime = System.currentTimeMillis();
		maxD2 = mb.findMaxBandwidthPathDijkstra2(g, 1, 9);
		endTime = System.currentTimeMillis();
		System.out.println("max weight by Dijkstra2: " + maxD2 + " found in " + (endTime - startTime) + "ms");

		System.out.println("Calling Kruskal....");
		MaxBandwidthPathKruskal mbk = new MaxBandwidthPathKruskal();
		startTime = System.currentTimeMillis();
		Graph newGraph = mbk.findMaxBandwidthPathByKruskal(g, 1, 9);
		endTime = System.currentTimeMillis();
		maxK = mbk.bfs(newGraph, 1, 9);
		long tempEndTime = System.currentTimeMillis();
		System.out.println("max weight by kruskal: " + maxK + " found in " + (endTime - startTime) + "ms"
				+ " bfs time: " + (tempEndTime - endTime));

		if (maxD1 != maxD2)
			g.print();// System.out.println("alert");
		// }
	//	g.printGenerationString();
	}
}
