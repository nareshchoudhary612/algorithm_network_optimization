package network_optimization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TestMain {

	public static void main(String[] args) throws Exception {

		/*******************************************************************************************
		 * Method to generate Report
		 *******************************************************************************************/
		int vertexCount = 5000;
		 generateReport(vertexCount);
		
		/*******************************************************************************************
		 * Method to generate graph and run algorithms according to parameters:
		 ********************************************************************************************/
		// Generate DenseGrapn? Run Kruskal1?  Run Dijkstra1? Run Dijkstra(Heap)
		// Comparing_Kruskal1_Kruskal2_Dijkstra1_Dijkstra2(true, true, true, true);
		
		
		/**************************************************************************
		 * Code to check time difference b/w sorting a int and sorting an edge
		 ***************************************************************************/
		//edgeVsIntSorting();
		
		/****************************************************************************
		 * Method to test MaxHeap
		 ***************************************************************************/
		//	testHeap();
			
			
			
		

		/*******************************************************************************************
		 * Method to Test MaxHeap for D2
		 ********************************************************************************************/
		// test_Heap_for_D1();

		// Below method will compare all 3 algorithm for a same graph generated manually
		// compare3AlgorithmForFixedGraph();

		// Check if IDs of Edges are generating properly
		// printnewEdgeIDs();

		/*******************************************************************************************
		 * Method to Generate small Graph
		 ********************************************************************************************/
		 //generateTestGraph();

	}

	public static void testHeap() {

		GraphGenerator graphGenerator = new GraphGenerator(5000);
		Graph g = graphGenerator.byDegree(1000);
		System.out.println("g.numberofEdge " + g.getNumberOfEdge());
		MaxHeapForKruskal maxHeap = new MaxHeapForKruskal(g.getNumberOfEdge());
		Edge[] elist = new Edge[g.getNumberOfEdge()];

		int k = 0;

		for (int i = 0; i < g.G.length; i++) {
			ArrayList<Edge> adjList = new ArrayList<>(g.getLinkedListAtPosition(i));

			// adding edges in heap
			for (Edge edge : adjList)
				maxHeap.add(edge); // adding edges in array
			for (int j = 0; j < adjList.size(); j++)
				elist[k++] = adjList.get(j);
		}
		System.out.println("size of elist: " + elist.length);
		Arrays.sort(elist);

		Edge temp;
		Boolean b = false;
		for (int s = 0; s < elist.length && !(maxHeap.isNull()); s++) {
			temp = maxHeap.pollMax();
			if (elist[s].w != temp.w) {
				System.out.println("elist edge: " + elist[s] + "is not same as " + temp);
				b = true;
			}
		}
		if (b)
			System.out.println("heap failing");
		else
			System.out.println("Heap working fine");

	}

	public static void edgeVsIntSorting() {

		GraphGenerator graphGenerator = new GraphGenerator(5000);
		Graph g = graphGenerator.byDegree(1000);
		System.out.println("Number Of Edges: " + g.getNumberOfEdge());

		Edge[] edgelist = new Edge[g.getNumberOfEdge()];
		int[] intList = new int[g.getNumberOfEdge()];

		// adding edges in array
		for (int i = 0, k = 0, x = 0; i < g.G.length; i++) {
			ArrayList<Edge> adjList = new ArrayList<>(g.getLinkedListAtPosition(i));
			for (int j = 0; j < adjList.size(); j++)
				edgelist[k++] = adjList.get(j);

			for (int j = 0; j < adjList.size(); j++)
				intList[x++] = adjList.get(j).getW();
		}

		long startTime = 0, endTime = 0;
		startTime = System.currentTimeMillis();
		Arrays.sort(edgelist);
		endTime = System.currentTimeMillis();
		System.out.println("\n Time taken to sort Edge list: " + (endTime - startTime) + "ms");
		startTime = System.currentTimeMillis();
		Arrays.sort(intList);
		endTime = System.currentTimeMillis();
		System.out.println("\n Time taken to sort int list: " + (endTime - startTime) + "ms");
	}

	public static void generateTestGraph() {
		GraphGenerator graphGenerator = new GraphGenerator(100);
		Graph g = graphGenerator.byDegree(6);
		g.print();
	}

	public static void generateReport(int vertexCount) {
		int maxK1 = 0, maxK2 = 0, maxD1 = 0, maxD2 = 0, count = 5;
		long startTime, endTime, tempEndTime = 0;
		Graph g = null;
		Random generateRandomNumber = new Random();

		System.out.println(
				"**********************************************************************************************************************************");
		System.out.println("Graph Type: Sparse");

		System.out.println(
				"**********************************************************************************************************************************");
		System.out.println(
				"Graph\tVertexs\tEdges\tSource\tDestination\tDijkstra_Max_BW|| Time Taken\tDijkstra_Max_BW_WithHeap|| Time Taken\tKruskal_Max_BW|| Time Taken\n");

		while (count > 0) {

			GraphGenerator graphGenerator = new GraphGenerator(vertexCount);
			g = graphGenerator.byDegree(6);
			int n = 5;
			while (n > 0) {
				int source = generateRandomNumber.nextInt(g.getNumberOfVertex());
				int destination = generateRandomNumber.nextInt(g.getNumberOfVertex());

				System.out.print("Graph" + count + "\t" + g.getNumberOfVertex() + "\t" + g.getNumberOfEdge() + "\t"
						+ source + "\t" + destination + "\t\t\t");

				MaxBandwidthPathDijkstra1 maxBandwidthPathDijkstra1 = new MaxBandwidthPathDijkstra1();
				startTime = System.currentTimeMillis();
				maxD1 = maxBandwidthPathDijkstra1.maxBandwidthPath(g, source, destination);
				endTime = System.currentTimeMillis();
				System.out.print("    " + maxD1 + "||" + (endTime - startTime) + "ms\t\t\t");

				MaxBandwidthPathDijkstra2 mb = new MaxBandwidthPathDijkstra2();
				startTime = System.currentTimeMillis();
				maxD2 = mb.findMaxBandwidthPathDijkstra2(g, source, destination);
				endTime = System.currentTimeMillis();
				System.out.print("    " + maxD2 + "||" + (endTime - startTime) + "ms\t\t\t");

				MaxBandwidthPathKruskal mbk = new MaxBandwidthPathKruskal();
				startTime = System.currentTimeMillis();
				Graph newGraph = mbk.findMaxBandwidthPathByKruskal(g, source, destination);
				maxK1 = mbk.bfs(newGraph, source, destination);
				endTime = System.currentTimeMillis();
				System.out.print("    " + maxK1 + "||" + (endTime - startTime) + "ms\t");

				/*
				 * MaxBandwidthPathKruskal2 mbpk2 = new MaxBandwidthPathKruskal2(); startTime =
				 * System.currentTimeMillis(); Graph newGraph2 =
				 * mbpk2.findMaxBandwidthPathByKruskal(g, source, destination); maxK2 =
				 * mbpk2.bfs(newGraph2, source, destination); endTime =
				 * System.currentTimeMillis(); System.out.print("    " + maxK2 + "||" + (endTime
				 * - startTime) + "ms\t");
				 */

				System.out.println("\n");
				n--;
			}
			count--;

		}

		System.out.println(
				"\n**********************************************************************************************************************************");
		System.out.println("Graph Type: Dense");

		System.out.println(
				"**********************************************************************************************************************************");
		System.out.println(
				"Graph\tVertexs\tEdges\tSource\tDestination\tDijkstra_Max_BW|| Time Taken\tDijkstra_Max_BW_WithHeap|| Time Taken\tKruskal_Max_BW|| Time Taken\n");
		count = 5;
		while (count > 0) {

			GraphGenerator graphGenerator = new GraphGenerator(vertexCount);
			g = graphGenerator.byPercentage(20);

			int n = 5;
			while (n > 0) {
				int source = generateRandomNumber.nextInt(g.getNumberOfVertex());
				int destination = generateRandomNumber.nextInt(g.getNumberOfVertex());

				System.out.print("Graph" + count + "\t" + g.getNumberOfVertex() + "\t" + g.getNumberOfEdge() + "\t"
						+ source + "\t" + destination + "\t\t\t");

				MaxBandwidthPathDijkstra1 maxBandwidthPathDijkstra1 = new MaxBandwidthPathDijkstra1();
				startTime = System.currentTimeMillis();
				maxD1 = maxBandwidthPathDijkstra1.maxBandwidthPath(g, source, destination);
				endTime = System.currentTimeMillis();
				System.out.print("    " + maxD1 + "||" + (endTime - startTime) + "ms\t\t\t");

				MaxBandwidthPathDijkstra2 mb = new MaxBandwidthPathDijkstra2();
				startTime = System.currentTimeMillis();
				maxD2 = mb.findMaxBandwidthPathDijkstra2(g, source, destination);
				endTime = System.currentTimeMillis();
				System.out.print("    " + maxD2 + "||" + (endTime - startTime) + "ms\t\t\t");

				MaxBandwidthPathKruskal mbk = new MaxBandwidthPathKruskal();
				startTime = System.currentTimeMillis();
				Graph newGraph = mbk.findMaxBandwidthPathByKruskal(g, source, destination);
				maxK1 = mbk.bfs(newGraph, source, destination);
				endTime = System.currentTimeMillis();
				System.out.print("    " + maxK1 + "||" + (endTime - startTime) + "ms\t");
				
				/*
				 * MaxBandwidthPathKruskal2 mbk2 = new MaxBandwidthPathKruskal2(); startTime =
				 * System.currentTimeMillis(); Graph newGraph2 =
				 * mbk2.findMaxBandwidthPathByKruskal(g, source, destination); endTime =
				 * System.currentTimeMillis(); maxK2 = mbk2.bfs(newGraph2, source, destination);
				 * tempEndTime = System.currentTimeMillis(); System.out.print("    " + maxK2 +
				 * "||" + (endTime - startTime) + "ms\t");
				 */
				
				System.out.println("\n");
				n--;
			}
			count--;

		}

	}

	private static void test_Heap_for_D1() {
		/*
		 * // TODO Auto-generated method stub MaxHeap mh = new MaxHeap(10); mh.add(0,
		 * 100); mh.add(1, 99); mh.add(2, 88); mh.add(3, 77); mh.add(4, 66); mh.add(5,
		 * 101);
		 * 
		 * System.out.print("H[]: "); mh.printH(); mh.printD();
		 * System.out.println("vL[]: "); mh.printVertexLocator();
		 * 
		 * // mh.update(0, 1001); mh.pollMax(); System.out.print("H[]: "); mh.printH();
		 * mh.printD(); System.out.println("vL[]: "); mh.printVertexLocator();
		 */

	}

	public static void Comparing_Kruskal1_Kruskal2_Dijkstra1_Dijkstra2(boolean denseGraph, boolean k1,
			boolean d1, boolean d2) throws Exception {

		int maxK1 = 0, maxK2 = 0, maxD1 = 0, maxD2 = 0;
		long startTime, endTime, tempEndTime = 0;
		Graph g = null;
		Random generateRandomNumber = new Random();

		System.out.println("*************************************************************************");

		GraphGenerator graphGenerator = new GraphGenerator(5000);
		if (denseGraph) {
			System.out.println("Generating Dense Graph...");
			g = graphGenerator.byPercentage(20);
		} else {
			System.out.println("Generating sparse Graph...");
			g = graphGenerator.byDegree(6);
		}

		int source = generateRandomNumber.nextInt(g.getNumberOfVertex());
		int destination = generateRandomNumber.nextInt(g.getNumberOfVertex());
		System.out.println("Source: " + source + " and Destination: " + destination);
		// System.out.println("number of edges" + g.getNumberOfEdge());
		System.out.println("number of edges: " + g.getNumberOfEdge());
		System.out.println("Number of Vertex: " + g.getNumberOfVertex());
		System.out.println("*************************************************************************");

		if (k1) {
			System.out.println("\nCalling Kruskal....");
			MaxBandwidthPathKruskal mbk = new MaxBandwidthPathKruskal();
			startTime = System.currentTimeMillis();
			Graph newGraph = mbk.findMaxBandwidthPathByKruskal(g, source, destination);
			endTime = System.currentTimeMillis();
			maxK1 = mbk.bfs(newGraph, source, destination);
			tempEndTime = System.currentTimeMillis();
			System.out.println("max weight by kruskal: " + maxK1 + " found in " + (endTime - startTime) + "ms"
					+ " bfs time: " + (tempEndTime - endTime));
		}

		/*
		 * if (k2) { System.out.println("\nCalling Kruskal2....");
		 * MaxBandwidthPathKruskal2 mbk2 = new MaxBandwidthPathKruskal2(); startTime =
		 * System.currentTimeMillis(); Graph newGraph2 =
		 * mbk2.findMaxBandwidthPathByKruskal(g, source, destination); endTime =
		 * System.currentTimeMillis(); maxK2 = mbk2.bfs(newGraph2, source, destination);
		 * tempEndTime = System.currentTimeMillis();
		 * System.out.println("max weight by kruskal2: " + maxK2 + " found in " +
		 * (endTime - startTime) + "ms" + " bfs time: " + (tempEndTime - endTime)); }
		 */

		if (d1) {
			System.out.println("\nCalling Dijkstra1...");
			MaxBandwidthPathDijkstra1 maxBandwidthPathDijkstra1 = new MaxBandwidthPathDijkstra1();
			startTime = System.currentTimeMillis();
			maxD1 = maxBandwidthPathDijkstra1.maxBandwidthPath(g, source, destination);
			endTime = System.currentTimeMillis();
			System.out.println("max weight by Dijkstra1: " + maxD1 + " found in " + (endTime - startTime) + "ms");
		}

		if (d2) {
			System.out.println("\nCalling Dijkstra2...");
			MaxBandwidthPathDijkstra2 mb = new MaxBandwidthPathDijkstra2();
			startTime = System.currentTimeMillis();
			maxD2 = mb.findMaxBandwidthPathDijkstra2(g, source, destination);
			endTime = System.currentTimeMillis();
			System.out.println("max weight by Dijkstra2: " + maxD2 + " found in " + (endTime - startTime) + "ms");
		}

		if (d1 == d2 && maxD1 != maxD2)
			throw new Exception();

	}

	public static void printnewEdgeIDs() {
		Edge e1 = new Edge(1, 2, 10);
		Edge e2 = new Edge(3, 2, 10);
		Edge e3 = new Edge(5, 2, 10);
		Edge e4 = new Edge(6, 2, 10);
		Edge e5 = new Edge(7, 2, 10);
		Edge e6 = new Edge(1, 8, 10);

		System.out.println(e1.getID());
		System.out.println(e2.getID());
		System.out.println(e3.getID());
		System.out.println(e4.getID());
		System.out.println(e5.getID());
		System.out.println(e6.getID());

	}

	public static void compare3AlgorithmForFixedGraph() {
		int maxD2 = 0, maxK = 0, maxD1 = 0;
		Graph g = new Graph(10);
		System.out.println("Generating Graph");
		long startTime = System.currentTimeMillis();

		// g = graphGenerator.byDegree(10);
		// g = graphGenerator.byPercentage(1000);

		g.getLinkedListAtPosition(0).add(new Edge(0, 9, 5));
		g.getLinkedListAtPosition(0).add(new Edge(0, 2, 15));
		g.getLinkedListAtPosition(0).add(new Edge(0, 8, 17));
		g.getLinkedListAtPosition(0).add(new Edge(0, 6, 14));
		g.getLinkedListAtPosition(0).add(new Edge(0, 1, 8));
		g.getLinkedListAtPosition(1).add(new Edge(1, 9, 12));
		g.getLinkedListAtPosition(1).add(new Edge(1, 6, 17));
		g.getLinkedListAtPosition(1).add(new Edge(1, 5, 6));
		g.getLinkedListAtPosition(1).add(new Edge(1, 0, 8));
		g.getLinkedListAtPosition(1).add(new Edge(1, 2, 14));
		g.getLinkedListAtPosition(2).add(new Edge(2, 9, 1));
		g.getLinkedListAtPosition(2).add(new Edge(2, 8, 2));
		g.getLinkedListAtPosition(2).add(new Edge(2, 0, 15));
		g.getLinkedListAtPosition(2).add(new Edge(2, 1, 14));
		g.getLinkedListAtPosition(2).add(new Edge(2, 3, 5));
		g.getLinkedListAtPosition(3).add(new Edge(3, 7, 4));
		g.getLinkedListAtPosition(3).add(new Edge(3, 6, 19));
		g.getLinkedListAtPosition(3).add(new Edge(3, 5, 8));
		g.getLinkedListAtPosition(3).add(new Edge(3, 2, 5));
		g.getLinkedListAtPosition(3).add(new Edge(3, 4, 7));
		g.getLinkedListAtPosition(4).add(new Edge(4, 9, 19));
		g.getLinkedListAtPosition(4).add(new Edge(4, 8, 2));
		g.getLinkedListAtPosition(4).add(new Edge(4, 6, 9));
		g.getLinkedListAtPosition(4).add(new Edge(4, 3, 7));
		g.getLinkedListAtPosition(4).add(new Edge(4, 5, 1));
		g.getLinkedListAtPosition(5).add(new Edge(5, 9, 7));
		g.getLinkedListAtPosition(5).add(new Edge(5, 3, 8));
		g.getLinkedListAtPosition(5).add(new Edge(5, 1, 6));
		g.getLinkedListAtPosition(5).add(new Edge(5, 4, 1));
		g.getLinkedListAtPosition(5).add(new Edge(5, 6, 20));
		g.getLinkedListAtPosition(6).add(new Edge(6, 4, 9));
		g.getLinkedListAtPosition(6).add(new Edge(6, 3, 19));
		g.getLinkedListAtPosition(6).add(new Edge(6, 1, 17));
		g.getLinkedListAtPosition(6).add(new Edge(6, 0, 14));
		g.getLinkedListAtPosition(6).add(new Edge(6, 5, 20));
		g.getLinkedListAtPosition(6).add(new Edge(6, 7, 16));
		g.getLinkedListAtPosition(7).add(new Edge(7, 9, 2));
		g.getLinkedListAtPosition(7).add(new Edge(7, 3, 4));
		g.getLinkedListAtPosition(7).add(new Edge(7, 6, 16));
		g.getLinkedListAtPosition(7).add(new Edge(7, 8, 4));
		g.getLinkedListAtPosition(8).add(new Edge(8, 4, 2));
		g.getLinkedListAtPosition(8).add(new Edge(8, 2, 2));
		g.getLinkedListAtPosition(8).add(new Edge(8, 0, 17));
		g.getLinkedListAtPosition(8).add(new Edge(8, 7, 4));
		g.getLinkedListAtPosition(8).add(new Edge(8, 9, 19));
		g.getLinkedListAtPosition(9).add(new Edge(9, 7, 2));
		g.getLinkedListAtPosition(9).add(new Edge(9, 5, 7));
		g.getLinkedListAtPosition(9).add(new Edge(9, 4, 19));
		g.getLinkedListAtPosition(9).add(new Edge(9, 2, 1));
		g.getLinkedListAtPosition(9).add(new Edge(9, 1, 12));
		g.getLinkedListAtPosition(9).add(new Edge(9, 0, 5));
		g.getLinkedListAtPosition(9).add(new Edge(9, 8, 19));

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
		// g.printGenerationString();
	}
}
