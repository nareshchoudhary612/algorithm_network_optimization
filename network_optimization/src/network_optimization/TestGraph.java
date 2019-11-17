package network_optimization;

public class TestGraph {

	public static void main(String[] args) {
		
		/****************************************************************************
		 * Code to test Dijkstra with heap (GraphGenerator method byDegree
		 ***************************************************************************/
		GraphGenerator graphGenerator = new GraphGenerator(5000);
		Graph g = graphGenerator.byDegree(6);
		//Graph g = graphGenerator.byPercentage(20);
		MaxBandwidthPathDijkstra2 mb = new MaxBandwidthPathDijkstra2();
		System.out.println("max weight: " + mb.findMaxBandwidthPathDijkstra2(g, 1, 9));
		
		/****************************************************************************
		 * Code to test Dijkstra with heap (GraphGenerator method byPercentage
		 ***************************************************************************/
		GraphGenerator graphGenerator2 = new GraphGenerator(5000);
		Graph g2 = graphGenerator2.byDegree(20);
		//Graph g = graphGenerator.byPercentage(20);
		MaxBandwidthPathDijkstra2 mb2 = new MaxBandwidthPathDijkstra2();
		System.out.println("max weight: " + mb2.findMaxBandwidthPathDijkstra2(g2, 1, 9));
		
		
		/****************************************************************************
		 * Code to test create and addEdge method of graph
		 ***************************************************************************/
		/*Graph g = new Graph(10);
		g.addEdge(1, 2, 15);
		g.addEdge(2, 3, 15);
		g.addEdge(4, 9, 15);
		g.addEdge(7, 2, 15);
		g.addEdge(8, 3, 15);
		g.addEdge(3, 8, 15);
		g.addEdge(7, 6, 15);
		g.print(); */
		
		/****************************************************************************
		 * Code to generate graph using percentage
		 ***************************************************************************/
		//GraphGenerator graphGenerator = new GraphGenerator();
		//Graph g = graphGenerator.byPercentage(5000, 20);
		
		/****************************************************************************
		 * Code to generate graph using degree
		 ***************************************************************************/
		//GraphGenerator graphGenerator = new GraphGenerator();
		//Graph g = graphGenerator.byDegree(5000, 6);

		/****************************************************************************
		 * Code to generate graph using degree
		 ***************************************************************************/
		
		
		/****************************************************************************
		 * To print Graph's adjacency list
		 ***************************************************************************/
		// g.print();

		/****************************************************************************
		 * To print number of connections of each vertex
		 ***************************************************************************/
		/*
		 * int edgeCount = 0; int count=0; long totalEdge = 0; for (int i = 0; i <
		 * g.getNumberOfVertex(); i++) {
		 * 
		 * edgeCount = 0; for (int j = 0; j < g.getLinkedListAtPosition(i).size(); j++)
		 * { // System.out.print( g.getLinkedListAtPosition(i).get(j).getV() + "->");
		 * edgeCount++; } totalEdge = totalEdge + edgeCount;
		 * 
		 * if(edgeCount != 6) System.out.println(i + " ==> " + edgeCount); }
		 * System.out.println(totalEdge);
		 */
		
		
		/****************************************************************************
		 * Code to test Heap
		 ***************************************************************************/
		/*
		 * MaxHeap h = new MaxHeap(10);
		 * 
		 * h.add(0, 1); h.printH(); h.add(1, 4); h.printH(); h.add(2, 7); h.printH();
		 * h.add(4, 3); h.printH(); h.delete(0); h.printH(); h.add(5, 45); h.printH();
		 * System.out.println(h.pollMax()); h.printH(); System.out.println(h.pollMax());
		 * h.printH(); System.out.println(h.pollMax()); h.printH(); h.add(7,2 );
		 * h.printH(); System.out.println(h.pollMax()); h.printH();
		 * System.out.println(h.pollMax()); h.printH(); System.out.println(h.pollMax());
		 * h.printH();
		 */

		/***************************************************************************/
		
		
	}

}
