package network_optimization;

public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(10);
		g.addEdge(1, 2, 15);
		g.addEdge(2, 3, 15);
		g.addEdge(4, 9, 15);
		g.addEdge(7, 2, 15);
		g.addEdge(8, 3, 15);
		g.addEdge(3, 8, 15);
		g.addEdge(7, 6, 15);
		g.print();
	}

}
