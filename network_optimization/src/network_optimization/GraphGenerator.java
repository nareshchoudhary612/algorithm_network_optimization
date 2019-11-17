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
		
		//create basic connected graph
		//intializeBasicConnectedGraph();
	}
	// create a loop to connect all vertices
	
	public void intializeBasicConnectedGraph() {
		
		/*
		 * ArrayList<Integer> list = new ArrayList<Integer>(); for (int i=0;
		 * i<numberOfVertex; i++) { list.add(new Integer(i)); } for(int l:list)
		 * System.out.print(l + " ");
		 * 
		 * Collections.shuffle(list);
		 * 
		 * System.out.println(); for(int l:list) System.out.print(l + " ");
		 */
	        
		for(int j=0; j< numberOfVertex-1; j++) {
		//	System.out.println(list.get(j) +" "+ list.get(j+1));
			int temp = generateRandomNumber.nextInt(2 * numberOfVertex) + 1;
			g.getLinkedListAtPosition(j).add(new Edge(j,j+1,temp));
			g.getLinkedListAtPosition(j+1).add(new Edge(j+1,j,temp));
			
		}
	}
	
	
	public Graph byPercentage(int percentage) {
		g = new Graph(numberOfVertex);
		
		intializeBasicConnectedGraph();
		//g.print();
		
		edgesPerVertex = ((numberOfVertex) * (percentage)) / (100);
		System.out.println(edgesPerVertex);
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
