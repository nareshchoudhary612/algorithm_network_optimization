package network_optimization;

import java.util.LinkedList;

public class Graph {

	int numberOfVertex = 0;
	int numberOfEdge = 0;
	// Defining Adjacency list i.e., creating an array of LinkedList of array
	public LinkedList<Edge> G[];
//	String temp = null;
	StringBuilder temp = new StringBuilder();

	/****************************************************************************
	 * Constructor
	 ***************************************************************************/
	public Graph(int numberOfVertex) {
		this.numberOfVertex = numberOfVertex;
		// Declaring LinkedList for each vertex
		G = new LinkedList[numberOfVertex];

		// Creating LinkeList for each vertex
		for (int i = 0; i < G.length; i++) {
			G[i] = new LinkedList<Edge>();
		}
	}

	/****************************************************************************
	 * Method to return LinkeList at [i]
	 ***************************************************************************/
	public LinkedList<Edge> getLinkedListAtPosition(int i) {
		return G[i];
	}

	/****************************************************************************
	 * To print Graph's adjacency list
	 ***************************************************************************/
	public void print() {
		String result = "";
		// StringBuilder result = new StringBuilder();
		for (int i = 0; i < G.length; i++) {
			result = result + i + " ==> " + G[i] + "\n";
			/*
			 * for (int j = 0; j < G[i].size(); j++) { //
			 * temp.append("g.addEdge").append(G[i].get(j)).append(";");
			 * temp.append("g.getLinkedListAtPosition(").append(i).append(").add(new Edge").
			 * append(G[i].get(j)) .append(");"); // g.getLinkedListAtPosition(s).add(new
			 * Edge(8,8,8)) }
			 */
			// temp = temp + "g.addEdge"+G[i].get(j)+";"; g.getLinkedListAtPosition(s)
		}
		 System.out.println(result);
		//System.out.println(temp.toString());
	}
	
	public void printGenerationString() {
		
		for (int i = 0; i < G.length; i++) {
			for (int j = 0; j < G[i].size(); j++) {
				// temp.append("g.addEdge").append(G[i].get(j)).append(";");
				temp.append("g.getLinkedListAtPosition(").append(i).append(").add(new Edge").append(G[i].get(j))
						.append(");");
			}
		}
		System.out.println(temp.toString());
	}

	

	/****************************************************************************
	 * To add edge from u to v and vice versa
	 ***************************************************************************/
	public void addEdge(int u, int v, int weight) {
		G[u].add(0, new Edge(u, v, weight)); // adding edge in the beginning of LinkedList to avoid LL traversal to end;
												// O(1)..
		G[v].add(0, new Edge(v, u, weight)); // Since this is a undirected graph, edge should be added both the ways
		// getNumberOfEdge();
	}

	/****************************************************************************
	 * To return number of vertex in graph
	 ***************************************************************************/
	public int getNumberOfVertex() {
		return numberOfVertex;
	}

	public int getNumberOfEdge() {
		numberOfEdge = 0;
		for (int i = 0; i < this.G.length; i++)
			numberOfEdge += this.getLinkedListAtPosition(i).size();
		return numberOfEdge;
	}

}
