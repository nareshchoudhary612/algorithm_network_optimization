package network_optimization;

import java.util.Random;

public class TestTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random generateRandomNumber = new Random();
		int maxD2 = 0, maxK = 0, maxD1 = 0;
		Graph g = null;
		  while(maxD2 == maxD1) 
		  { 
			  maxD1=0;maxD2=0;
		  
		g = null;
		
		
		System.out.println("*************************************************************************");
		System.out.println("Generating Graph");
		GraphGenerator graphGenerator = new GraphGenerator(5000);
		long startTime = System.currentTimeMillis();

		 g = graphGenerator.byDegree(250);
		//g = graphGenerator.byPercentage(1000);
		 int source = generateRandomNumber.nextInt(g.getNumberOfVertex());
		 int destination = generateRandomNumber.nextInt(g.getNumberOfVertex());
		 System.out.println("Source: "+source+ " and Destination: "+ destination);
			//System.out.println("number of edges" + g.getNumberOfEdge());
		 System.out.println("*************************************************************************");
			long endTime = System.currentTimeMillis(); // g.print();

			System.out.println("Graph generated in: " + (endTime - startTime) + "ms");

			//System.out.println("Calling Dijkstra1...");
			MaxBandwidthPathDijkstra1 maxBandwidthPathDijkstra1 = new MaxBandwidthPathDijkstra1();
			startTime = System.currentTimeMillis();
			maxD1 = maxBandwidthPathDijkstra1.maxBandwidthPath(g, source, destination);
			endTime = System.currentTimeMillis();
			System.out.println("max weight by Dijkstra1(w/o heap)  : " + maxD1 + " found in " + (endTime - startTime) + "ms");

			//System.out.println("Calling Dijkstra2...");
			MaxBandwidthPathDijkstra2 mb = new MaxBandwidthPathDijkstra2();
			startTime = System.currentTimeMillis();
			maxD2 = mb.findMaxBandwidthPathDijkstra2(g, source, destination);
			endTime = System.currentTimeMillis();
			System.out.println("max weight by Dijkstra2 (with heap): " + maxD2 + " found in " + (endTime - startTime) + "ms");
			
			if (maxD1 != maxD2) {
				g.print();
				System.out.println("********************************");
				g.printGenerationString();
			}
				//System.out.println("alert");  
			// }
	}

	}
	
}
