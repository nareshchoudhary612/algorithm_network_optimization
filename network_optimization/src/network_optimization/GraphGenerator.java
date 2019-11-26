package network_optimization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GraphGenerator {

	Graph g;
	int edgesPerVertex;
	int count = 0;
	int loopControl = 0;
	int numberOfVertex = 0;
	Random generateRandomNumber = new Random();
	Set<Integer> vertexSet = new HashSet<Integer>();
	
	//constructor
	public GraphGenerator(int numberOfVertex) {
		this.numberOfVertex = numberOfVertex;
		g = new Graph(numberOfVertex);
	}
	
	// create a loop to connect all vertices
	public void intializeBasicConnectedGraph() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int j=0; j< numberOfVertex; j++) {
			list.add(j);
		}
		
		Collections.shuffle(list);
		
		for(int i =0; i< numberOfVertex-1;i++) {
			int temp = generateRandomNumber.nextInt(2 *numberOfVertex) + 1;
			g.addEdge(list.get(i), list.get(i+1), temp);
		}
	}
	
	
	public Graph byPercentage(int percentage) {
		g = new Graph(numberOfVertex);
		
		intializeBasicConnectedGraph();
		//g.print();
		
		edgesPerVertex = ((numberOfVertex) * (percentage)) / (100);
		//System.out.println(edgesPerVertex);
		for (int i = 0; i < numberOfVertex; i++) {

			vertexSet.clear();
			// adding existing v stored in linked list of u = g[i] in set so that they are
			// not added again to linked list of u incase random generator generates same
			// vertex
			for (int j = 0; j < g.getLinkedListAtPosition(i).size(); j++)
				vertexSet.add(g.getLinkedListAtPosition(i).get(j).getV());

			count = vertexSet.size();
			loopControl = 0;
			
			while (count < edgesPerVertex && loopControl < 100000) {
				int randomVertex = generateRandomNumber.nextInt(numberOfVertex - i) + i;
				int randomWeight = generateRandomNumber.nextInt(2 * numberOfVertex) + 1;

				// avoiding self loop or if two vertex already connected
				if (i != randomVertex && !vertexSet.contains(randomVertex)) {
					// System.out.println("i=" + i + " randomVertex=" + randomVertex + " random weight=" + randomWeight);
					g.addEdge(i, randomVertex, randomWeight);
					count++;
					vertexSet.add(randomVertex);
				}

				loopControl++;

			}
			
		}
		
		return g;
	}
	
	public Graph byDegree(int degree) {
		g = new Graph(numberOfVertex);
		
		intializeBasicConnectedGraph();
		//g.print();
		edgesPerVertex = degree;
	//	System.out.println(edgesPerVertex);
		for (int i = 0; i < numberOfVertex; i++) {

			vertexSet.clear();
			// adding existing v stored in linked list of u = g[i] in set so that they are
			// not added again to linked list of u incase random generator generates same
			// vertex
			for (int j = 0; j < g.getLinkedListAtPosition(i).size(); j++)
				vertexSet.add(g.getLinkedListAtPosition(i).get(j).getV());

			count = vertexSet.size();
			loopControl = 0;

			while (count < edgesPerVertex && loopControl < 100000) {
				int randomVertex = generateRandomNumber.nextInt(numberOfVertex - i) + i;
				int randomWeight = generateRandomNumber.nextInt(2 * numberOfVertex) + 1;

				// avoiding self loop or if two vertex already connected
				if (i != randomVertex && !vertexSet.contains(randomVertex)) {
					// System.out.println("i=" + i + " randomVertex=" + randomVertex + " random weight=" + randomWeight);
					g.addEdge(i, randomVertex, randomWeight);
					count++;
					vertexSet.add(randomVertex);
				}

				loopControl++;

			}
		}
		return g;
	}
}
