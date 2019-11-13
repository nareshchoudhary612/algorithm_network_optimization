package network_optimization;

public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		GraphGenerator graphGenerator = new GraphGenerator();
		Graph g = graphGenerator.byPercentage(5000, 20);

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
		int edgeCount = 0;
		for (int i = 0; i < g.getNumberOfVertex(); i++) {

			edgeCount = 0;
			for (int j = 0; j < g.getLinkedListAtPosition(i).size(); j++) {
				// System.out.print( g.getLinkedListAtPosition(i).get(j).getV() + "->");
				edgeCount++;
			}
			// if(edgeCount != 1000)
			System.out.println(i + " ==> " + edgeCount);
		} 
	}

}
