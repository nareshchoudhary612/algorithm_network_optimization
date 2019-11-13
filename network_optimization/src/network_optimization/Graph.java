package network_optimization;

import java.util.LinkedList;

public class Graph {
	
	int numberOfVertex = 0;
	// Defining Adjacency list i.e., creating an array of LinkedList of array
	LinkedList<Edge> G[];

	/****************************************************************************
	 * Constructor
	 ***************************************************************************/
	public Graph(int numberOfVertex) {
		this.numberOfVertex = numberOfVertex;
		//Declaring LinkedList for each vertex
		G = new LinkedList[numberOfVertex];
		
		//Creating LinkeList for each vertex
		for(int i=0; i<G.length; i++) {
			G[i] = new LinkedList<Edge>();
		}	
	}
	
	/****************************************************************************
	 * Method to return LinkeList at  [i]
	 ***************************************************************************/
	public LinkedList<Edge> getLinkedListAtPosition(int i){
		return G[i];
	}
	
	/****************************************************************************
	 * To print Graph's adjacency list
	 ***************************************************************************/
	public void print() {
		String result = "";
		for(int i =0; i<G.length; i++)
			result = result + i+ " ==> " + G[i] + "\n";
		System.out.println(result);
	}
	
	/****************************************************************************
	 * To add edge from u to v and vice versa
	 ***************************************************************************/
	public void addEdge(int u, int v, int weight) {
		G[u].add(0, new Edge(v, weight)); // adding edge in the beginning of LinkedList to avoid LL traversal to end; O(1)..
		G[v].add(0,new Edge(u,weight)); // Since this is a undirected graph, edge should be added both the ways
	}
	
	/****************************************************************************
	 * To return number of vertex in graph 
	 ***************************************************************************/
	public int getNumberOfVertex() {
		return numberOfVertex;
	}
	
	
	
}
