package network_optimization;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GraphGenerator {

	Graph g;
	int edgesPerVertex;
	int count = 0;
	int loopControl = 0;
	Random generateRandomNumber = new Random();
	Set<Integer> vertexSet = new HashSet<Integer>();

	public Graph byPercentage(int numberOfVertex, int percentage) {
		g = new Graph(numberOfVertex);

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
}
