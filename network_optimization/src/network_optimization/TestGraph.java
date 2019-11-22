package network_optimization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestGraph {

	public static void main(String[] args) {

		/****************************************************************************
		 * Code to test Kruskal (GraphGenerator method byDegree
		 ***************************************************************************/

		int maxD2 = 0, maxK = 0, maxD1 = 0;
		Graph g = null;
//		  while(maxD == maxK) { maxD=0;maxK=0;
		g = null;
		System.out.println("Generating Graph");
		GraphGenerator graphGenerator = new GraphGenerator(15);
		long startTime = System.currentTimeMillis();

		 g = graphGenerator.byDegree(10);
		//g = graphGenerator.byPercentage(1000);

		/*
		 * g = new Graph(20); g.addEdge(0, 14, 20); g.addEdge(0, 1,22);
		 * g.addEdge(1,2,5); g.addEdge(2,3,29); g.addEdge(3,4,24); g.addEdge(4,5,33);
		 * g.addEdge(5,6,25); g.addEdge(6,7,6); g.addEdge(7,8,30); g.addEdge(8,9,14);
		 * g.addEdge(9,10,4); g.addEdge(10,11,13); g.addEdge(11,12,39);
		 * g.addEdge(12,13,5); g.addEdge(13,14,9); g.addEdge(14,15,8);
		 * g.addEdge(15,16,31); g.addEdge(16,17,20); g.addEdge(17,18,21);
		 * g.addEdge(18,19,4);
		 */
//	g = new Graph(100);
//		g.addEdge(0,4,37);g.addEdge(0,19,11);g.addEdge(0,10,13);g.addEdge(0,1,31);g.addEdge(1,3,27);g.addEdge(1,11,31);g.addEdge(1,0,31);g.addEdge(1,2,23);g.addEdge(2,14,19);g.addEdge(2,15,16);g.addEdge(2,1,23);g.addEdge(2,3,26);g.addEdge(3,9,35);g.addEdge(3,1,27);g.addEdge(3,2,26);g.addEdge(3,4,5);g.addEdge(4,8,36);g.addEdge(4,0,37);g.addEdge(4,3,5);g.addEdge(4,5,10);g.addEdge(5,9,4);g.addEdge(5,13,22);g.addEdge(5,4,10);g.addEdge(5,6,26);g.addEdge(6,9,15);g.addEdge(6,15,18);g.addEdge(6,5,26);g.addEdge(6,7,1);g.addEdge(7,9,19);g.addEdge(7,11,19);g.addEdge(7,6,1);g.addEdge(7,8,3);g.addEdge(8,11,28);g.addEdge(8,4,36);g.addEdge(8,7,3);g.addEdge(8,9,31);g.addEdge(9,7,19);g.addEdge(9,6,15);g.addEdge(9,5,4);g.addEdge(9,3,35);g.addEdge(9,8,31);g.addEdge(9,10,6);g.addEdge(10,19,15);g.addEdge(10,0,13);g.addEdge(10,9,6);g.addEdge(10,11,13);g.addEdge(11,8,28);g.addEdge(11,7,19);g.addEdge(11,1,31);g.addEdge(11,10,13);g.addEdge(11,12,24);g.addEdge(12,16,2);g.addEdge(12,14,2);g.addEdge(12,11,24);g.addEdge(12,13,30);g.addEdge(13,16,39);g.addEdge(13,5,22);g.addEdge(13,12,30);g.addEdge(13,14,2);g.addEdge(14,12,2);g.addEdge(14,2,19);g.addEdge(14,13,2);g.addEdge(14,15,27);g.addEdge(15,6,18);g.addEdge(15,2,16);g.addEdge(15,14,27);g.addEdge(15,16,13);g.addEdge(16,13,39);g.addEdge(16,12,2);g.addEdge(16,15,13);g.addEdge(16,17,24);g.addEdge(17,19,40);g.addEdge(17,16,24);g.addEdge(17,18,10);g.addEdge(18,17,10);g.addEdge(18,19,29);g.addEdge(19,17,40);g.addEdge(19,10,15);g.addEdge(19,0,11);g.addEdge(19,18,29);
//	g.addEdge(0,17,196);g.addEdge(0,34,47);g.addEdge(0,58,169);g.addEdge(0,1,159);g.addEdge(1,96,142);g.addEdge(1,82,162);g.addEdge(1,0,159);g.addEdge(1,2,125);g.addEdge(2,43,138);g.addEdge(2,95,118);g.addEdge(2,1,125);g.addEdge(2,3,100);g.addEdge(3,43,79);g.addEdge(3,49,18);g.addEdge(3,2,100);g.addEdge(3,4,66);g.addEdge(4,34,35);g.addEdge(4,29,142);g.addEdge(4,3,66);g.addEdge(4,5,185);g.addEdge(5,48,84);g.addEdge(5,77,181);g.addEdge(5,4,185);g.addEdge(5,6,95);g.addEdge(6,73,153);g.addEdge(6,91,161);g.addEdge(6,5,95);g.addEdge(6,7,73);g.addEdge(7,18,144);g.addEdge(7,52,136);g.addEdge(7,6,73);g.addEdge(7,8,148);g.addEdge(8,94,144);g.addEdge(8,43,59);g.addEdge(8,7,148);g.addEdge(8,9,143);g.addEdge(9,57,102);g.addEdge(9,48,184);g.addEdge(9,8,143);g.addEdge(9,10,31);g.addEdge(10,17,126);g.addEdge(10,92,69);g.addEdge(10,9,31);g.addEdge(10,11,53);g.addEdge(11,55,183);g.addEdge(11,95,101);g.addEdge(11,10,53);g.addEdge(11,12,57);g.addEdge(12,73,153);g.addEdge(12,99,88);g.addEdge(12,11,57);g.addEdge(12,13,96);g.addEdge(13,60,138);g.addEdge(13,58,194);g.addEdge(13,12,96);g.addEdge(13,14,123);g.addEdge(14,55,147);g.addEdge(14,65,85);g.addEdge(14,13,123);g.addEdge(14,15,175);g.addEdge(15,67,34);g.addEdge(15,56,18);g.addEdge(15,14,175);g.addEdge(15,16,135);g.addEdge(16,19,73);g.addEdge(16,88,75);g.addEdge(16,15,135);g.addEdge(16,17,28);g.addEdge(17,10,126);g.addEdge(17,0,196);g.addEdge(17,16,28);g.addEdge(17,18,89);g.addEdge(18,83,52);g.addEdge(18,7,144);g.addEdge(18,17,89);g.addEdge(18,19,171);g.addEdge(19,58,3);g.addEdge(19,16,73);g.addEdge(19,18,171);g.addEdge(19,20,138);g.addEdge(20,90,39);g.addEdge(20,57,168);g.addEdge(20,19,138);g.addEdge(20,21,199);g.addEdge(21,31,189);g.addEdge(21,86,8);g.addEdge(21,20,199);g.addEdge(21,22,95);g.addEdge(22,39,157);g.addEdge(22,41,150);g.addEdge(22,21,95);g.addEdge(22,23,117);g.addEdge(23,67,143);g.addEdge(23,40,24);g.addEdge(23,22,117);g.addEdge(23,24,58);g.addEdge(24,29,173);g.addEdge(24,88,40);g.addEdge(24,23,58);g.addEdge(24,25,45);g.addEdge(25,98,12);g.addEdge(25,88,111);g.addEdge(25,24,45);g.addEdge(25,26,18);g.addEdge(26,47,130);g.addEdge(26,63,122);g.addEdge(26,25,18);g.addEdge(26,27,175);g.addEdge(27,47,17);g.addEdge(27,31,13);g.addEdge(27,26,175);g.addEdge(27,28,83);g.addEdge(28,81,153);g.addEdge(28,86,187);g.addEdge(28,27,83);g.addEdge(28,29,48);g.addEdge(29,24,173);g.addEdge(29,4,142);g.addEdge(29,28,48);g.addEdge(29,30,114);g.addEdge(30,39,116);g.addEdge(30,43,120);g.addEdge(30,29,114);g.addEdge(30,31,150);g.addEdge(31,27,13);g.addEdge(31,21,189);g.addEdge(31,30,150);g.addEdge(31,32,106);g.addEdge(32,86,11);g.addEdge(32,97,118);g.addEdge(32,31,106);g.addEdge(32,33,133);g.addEdge(33,89,190);g.addEdge(33,46,35);g.addEdge(33,32,133);g.addEdge(33,34,14);g.addEdge(34,4,35);g.addEdge(34,0,47);g.addEdge(34,33,14);g.addEdge(34,35,94);g.addEdge(35,77,169);g.addEdge(35,50,180);g.addEdge(35,34,94);g.addEdge(35,36,177);g.addEdge(36,69,50);g.addEdge(36,66,18);g.addEdge(36,35,177);g.addEdge(36,37,197);g.addEdge(37,42,38);g.addEdge(37,97,3);g.addEdge(37,36,197);g.addEdge(37,38,105);g.addEdge(38,56,112);g.addEdge(38,48,148);g.addEdge(38,37,105);g.addEdge(38,39,149);g.addEdge(39,30,116);g.addEdge(39,22,157);g.addEdge(39,38,149);g.addEdge(39,40,160);g.addEdge(40,73,184);g.addEdge(40,23,24);g.addEdge(40,39,160);g.addEdge(40,41,151);g.addEdge(41,98,161);g.addEdge(41,22,150);g.addEdge(41,40,151);g.addEdge(41,42,40);g.addEdge(42,98,194);g.addEdge(42,37,38);g.addEdge(42,41,40);g.addEdge(42,43,189);g.addEdge(43,30,120);g.addEdge(43,8,59);g.addEdge(43,3,79);g.addEdge(43,2,138);g.addEdge(43,42,189);g.addEdge(43,44,193);g.addEdge(44,84,92);g.addEdge(44,52,183);g.addEdge(44,43,193);g.addEdge(44,45,114);g.addEdge(45,80,188);g.addEdge(45,55,158);g.addEdge(45,44,114);g.addEdge(45,46,70);g.addEdge(46,71,8);g.addEdge(46,33,35);g.addEdge(46,45,70);g.addEdge(46,47,115);g.addEdge(47,27,17);g.addEdge(47,26,130);g.addEdge(47,46,115);g.addEdge(47,48,37);g.addEdge(48,38,148);g.addEdge(48,9,184);g.addEdge(48,5,84);g.addEdge(48,47,37);g.addEdge(48,49,169);g.addEdge(49,74,151);g.addEdge(49,3,18);g.addEdge(49,48,169);g.addEdge(49,50,31);g.addEdge(50,68,51);g.addEdge(50,35,180);g.addEdge(50,49,31);g.addEdge(50,51,61);g.addEdge(51,69,110);g.addEdge(51,62,67);g.addEdge(51,50,61);g.addEdge(51,52,183);g.addEdge(52,44,183);g.addEdge(52,7,136);g.addEdge(52,51,183);g.addEdge(52,53,79);g.addEdge(53,92,192);g.addEdge(53,73,38);g.addEdge(53,52,79);g.addEdge(53,54,37);g.addEdge(54,94,52);g.addEdge(54,99,113);g.addEdge(54,53,37);g.addEdge(54,55,185);g.addEdge(55,45,158);g.addEdge(55,14,147);g.addEdge(55,11,183);g.addEdge(55,54,185);g.addEdge(55,56,181);g.addEdge(56,38,112);g.addEdge(56,15,18);g.addEdge(56,55,181);g.addEdge(56,57,89);g.addEdge(57,20,168);g.addEdge(57,9,102);g.addEdge(57,56,89);g.addEdge(57,58,122);g.addEdge(58,19,3);g.addEdge(58,13,194);g.addEdge(58,0,169);g.addEdge(58,57,122);g.addEdge(58,59,16);g.addEdge(59,90,159);g.addEdge(59,88,23);g.addEdge(59,58,16);g.addEdge(59,60,39);g.addEdge(60,71,37);g.addEdge(60,13,138);g.addEdge(60,59,39);g.addEdge(60,61,147);g.addEdge(61,77,37);g.addEdge(61,76,81);g.addEdge(61,60,147);g.addEdge(61,62,27);g.addEdge(62,80,17);g.addEdge(62,51,67);g.addEdge(62,61,27);g.addEdge(62,63,153);g.addEdge(63,67,186);g.addEdge(63,26,122);g.addEdge(63,62,153);g.addEdge(63,64,134);g.addEdge(64,76,93);g.addEdge(64,77,187);g.addEdge(64,63,134);g.addEdge(64,65,194);g.addEdge(65,97,83);g.addEdge(65,14,85);g.addEdge(65,64,194);g.addEdge(65,66,117);g.addEdge(66,85,136);g.addEdge(66,36,18);g.addEdge(66,65,117);g.addEdge(66,67,18);g.addEdge(67,63,186);g.addEdge(67,23,143);g.addEdge(67,15,34);g.addEdge(67,66,18);g.addEdge(67,68,138);g.addEdge(68,96,69);g.addEdge(68,50,51);g.addEdge(68,67,138);g.addEdge(68,69,97);g.addEdge(69,51,110);g.addEdge(69,36,50);g.addEdge(69,68,97);g.addEdge(69,70,176);g.addEdge(70,92,190);g.addEdge(70,98,170);g.addEdge(70,69,176);g.addEdge(70,71,161);g.addEdge(71,60,37);g.addEdge(71,46,8);g.addEdge(71,70,161);g.addEdge(71,72,63);g.addEdge(72,96,11);g.addEdge(72,99,184);g.addEdge(72,71,63);g.addEdge(72,73,104);g.addEdge(73,53,38);g.addEdge(73,40,184);g.addEdge(73,12,153);g.addEdge(73,6,153);g.addEdge(73,72,104);g.addEdge(73,74,188);g.addEdge(74,82,72);g.addEdge(74,49,151);g.addEdge(74,73,188);g.addEdge(74,75,88);g.addEdge(75,96,28);g.addEdge(75,88,1);g.addEdge(75,74,88);g.addEdge(75,76,181);g.addEdge(76,64,93);g.addEdge(76,61,81);g.addEdge(76,75,181);g.addEdge(76,77,158);g.addEdge(77,64,187);g.addEdge(77,61,37);g.addEdge(77,35,169);g.addEdge(77,5,181);g.addEdge(77,76,158);g.addEdge(77,78,139);g.addEdge(78,87,3);g.addEdge(78,86,131);g.addEdge(78,77,139);g.addEdge(78,79,119);g.addEdge(79,82,153);g.addEdge(79,83,104);g.addEdge(79,78,119);g.addEdge(79,80,155);g.addEdge(80,62,17);g.addEdge(80,45,188);g.addEdge(80,79,155);g.addEdge(80,81,151);g.addEdge(81,89,24);g.addEdge(81,28,153);g.addEdge(81,80,151);g.addEdge(81,82,197);g.addEdge(82,79,153);g.addEdge(82,74,72);g.addEdge(82,1,162);g.addEdge(82,81,197);g.addEdge(82,83,75);g.addEdge(83,79,104);g.addEdge(83,18,52);g.addEdge(83,82,75);g.addEdge(83,84,128);g.addEdge(84,87,135);g.addEdge(84,44,92);g.addEdge(84,83,128);g.addEdge(84,85,56);g.addEdge(85,93,68);g.addEdge(85,66,136);g.addEdge(85,84,56);g.addEdge(85,86,34);g.addEdge(86,78,131);g.addEdge(86,32,11);g.addEdge(86,28,187);g.addEdge(86,21,8);g.addEdge(86,85,34);g.addEdge(86,87,37);g.addEdge(87,84,135);g.addEdge(87,78,3);g.addEdge(87,86,37);g.addEdge(87,88,117);g.addEdge(88,75,1);g.addEdge(88,59,23);g.addEdge(88,25,111);g.addEdge(88,24,40);g.addEdge(88,16,75);g.addEdge(88,87,117);g.addEdge(88,89,135);g.addEdge(89,81,24);g.addEdge(89,33,190);g.addEdge(89,88,135);g.addEdge(89,90,144);g.addEdge(90,59,159);g.addEdge(90,20,39);g.addEdge(90,89,144);g.addEdge(90,91,30);g.addEdge(91,93,142);g.addEdge(91,6,161);g.addEdge(91,90,30);g.addEdge(91,92,138);g.addEdge(92,70,190);g.addEdge(92,53,192);g.addEdge(92,10,69);g.addEdge(92,91,138);g.addEdge(92,93,112);g.addEdge(93,91,142);g.addEdge(93,85,68);g.addEdge(93,92,112);g.addEdge(93,94,49);g.addEdge(94,54,52);g.addEdge(94,8,144);g.addEdge(94,93,49);g.addEdge(94,95,30);g.addEdge(95,11,101);g.addEdge(95,2,118);g.addEdge(95,94,30);g.addEdge(95,96,140);g.addEdge(96,75,28);g.addEdge(96,72,11);g.addEdge(96,68,69);g.addEdge(96,1,142);g.addEdge(96,95,140);g.addEdge(96,97,82);g.addEdge(97,65,83);g.addEdge(97,37,3);g.addEdge(97,32,118);g.addEdge(97,96,82);g.addEdge(97,98,79);g.addEdge(98,70,170);g.addEdge(98,42,194);g.addEdge(98,41,161);g.addEdge(98,25,12);g.addEdge(98,97,79);g.addEdge(98,99,68);g.addEdge(99,72,184);g.addEdge(99,54,113);g.addEdge(99,12,88);g.addEdge(99,98,68);
//g = new Graph(20);
//g.addEdge(0,2,27);g.addEdge(0,18,31);g.addEdge(0,19,32);g.addEdge(0,12,11);g.addEdge(0,1,39);g.addEdge(1,9,6);g.addEdge(1,11,2);g.addEdge(1,4,28);g.addEdge(1,0,39);g.addEdge(1,2,16);g.addEdge(2,15,15);g.addEdge(2,16,20);g.addEdge(2,0,27);g.addEdge(2,1,16);g.addEdge(2,3,15);g.addEdge(3,12,15);g.addEdge(3,13,33);g.addEdge(3,17,30);g.addEdge(3,2,15);g.addEdge(3,4,12);g.addEdge(4,10,9);g.addEdge(4,9,23);g.addEdge(4,1,28);g.addEdge(4,3,12);g.addEdge(4,5,37);g.addEdge(5,17,40);g.addEdge(5,15,22);g.addEdge(5,9,10);g.addEdge(5,4,37);g.addEdge(5,6,7);g.addEdge(6,12,27);g.addEdge(6,14,18);g.addEdge(6,10,12);g.addEdge(6,5,7);g.addEdge(6,7,5);g.addEdge(7,16,12);g.addEdge(7,10,24);g.addEdge(7,11,27);g.addEdge(7,6,5);g.addEdge(7,8,1);g.addEdge(8,19,3);g.addEdge(8,14,12);g.addEdge(8,16,29);g.addEdge(8,7,1);g.addEdge(8,9,24);g.addEdge(9,5,10);g.addEdge(9,4,23);g.addEdge(9,1,6);g.addEdge(9,8,24);g.addEdge(9,10,2);g.addEdge(10,7,24);g.addEdge(10,6,12);g.addEdge(10,4,9);g.addEdge(10,9,2);g.addEdge(10,11,28);g.addEdge(11,13,12);g.addEdge(11,7,27);g.addEdge(11,1,2);g.addEdge(11,10,28);g.addEdge(11,12,17);g.addEdge(12,6,27);g.addEdge(12,3,15);g.addEdge(12,0,11);g.addEdge(12,11,17);g.addEdge(12,13,13);g.addEdge(13,18,25);g.addEdge(13,11,12);g.addEdge(13,3,33);g.addEdge(13,12,13);g.addEdge(13,14,23);g.addEdge(14,17,21);g.addEdge(14,8,12);g.addEdge(14,6,18);g.addEdge(14,13,23);g.addEdge(14,15,31);g.addEdge(15,17,38);g.addEdge(15,5,22);g.addEdge(15,2,15);g.addEdge(15,14,31);g.addEdge(15,16,39);g.addEdge(16,8,29);g.addEdge(16,7,12);g.addEdge(16,2,20);g.addEdge(16,15,39);g.addEdge(16,17,34);g.addEdge(17,15,38);g.addEdge(17,14,21);g.addEdge(17,5,40);g.addEdge(17,3,30);g.addEdge(17,16,34);g.addEdge(17,18,39);g.addEdge(18,13,25);g.addEdge(18,0,31);g.addEdge(18,17,39);g.addEdge(18,19,1);g.addEdge(19,8,3);g.addEdge(19,0,32);g.addEdge(19,18,1);

		System.out.println("number of edges" + g.getNumberOfEdge());
		long endTime = System.currentTimeMillis(); // g.print();

		System.out.println("Graph generated in: " + (endTime - startTime) + "ms");

		System.out.println("Calling Dijkstra1...");
		MaxBandwidthPathDijkstra1 maxBandwidthPathDijkstra1 = new MaxBandwidthPathDijkstra1();
		startTime = System.currentTimeMillis();
		maxD1 = maxBandwidthPathDijkstra1.maxBandwidthPath(g, 1, 14);
		endTime = System.currentTimeMillis();
		System.out.println("max weight by Dijkstra1: " + maxD1 + " found in " + (endTime - startTime) + "ms");

		System.out.println("Calling Dijkstra2...");
		MaxBandwidthPathDijkstra2 mb = new MaxBandwidthPathDijkstra2();
		startTime = System.currentTimeMillis();
		maxD2 = mb.findMaxBandwidthPathDijkstra2(g, 1, 14);
		endTime = System.currentTimeMillis();
		System.out.println("max weight by Dijkstra2: " + maxD2 + " found in " + (endTime - startTime) + "ms");

		/*
		 * System.out.println("Calling Kruskal...."); MaxBandwidthPathKruskal mbk = new
		 * MaxBandwidthPathKruskal(); startTime = System.currentTimeMillis(); Graph
		 * newGraph = mbk.findMaxBandwidthPathByKruskal(g, 1, 14); endTime =
		 * System.currentTimeMillis(); maxK = mbk.bfs(newGraph, 1, 14); long tempEndTime
		 * = System.currentTimeMillis(); System.out.println("max weight by kruskal: " +
		 * maxK + " found in " + (endTime - startTime) + "ms" + " bfs time: " +
		 * (tempEndTime - endTime));
		 */

		if (maxD1 != maxD2)
			g.print();//System.out.println("alert");  
		// }

		// g.print();

		/****************************************************************************
		 * Code to test Dijkstra with heap (GraphGenerator method byDegree
		 ***************************************************************************/

		/*
		 * GraphGenerator graphGenerator = new GraphGenerator(10); Graph g =
		 * graphGenerator.byDegree(3); g.print(); MaxBandwidthPathDijkstra2 mb = new
		 * MaxBandwidthPathDijkstra2(); System.out.println("max weight: " +
		 * mb.findMaxBandwidthPathDijkstra2(g, 1, 9));
		 */

		/****************************************************************************
		 * Code to test Dijkstra with heap (GraphGenerator method byPercentage
		 ***************************************************************************/
		/*
		 * GraphGenerator graphGenerator2 = new GraphGenerator(5000); Graph g2 =
		 * graphGenerator2.byDegree(20); //Graph g = graphGenerator.byPercentage(20);
		 * MaxBandwidthPathDijkstra2 mb2 = new MaxBandwidthPathDijkstra2();
		 * System.out.println("max weight: " + mb2.findMaxBandwidthPathDijkstra2(g2, 1,
		 * 9));
		 */

		/****************************************************************************
		 * Code to test MaxHeapForKruskal
		 ***************************************************************************/
		/*
		 * MaxHeapForKruskal mhk = new MaxHeapForKruskal(10); mhk.add(new Edge(1,2,3));
		 * mhk.add(new Edge(2,3,4)); mhk.add(new Edge(3,4,7)); mhk.add(new Edge(4,5,5));
		 * mhk.add(new Edge(5,6,10)); mhk.add(new Edge(6,7,1)); mhk.add(new
		 * Edge(8,9,1));
		 * 
		 * 
		 * System.out.println("polled in testGraph:" + mhk.pollMax());
		 * System.out.println("polled in testGraph:" + mhk.pollMax()); mhk.add(new
		 * Edge(9,8,45)); System.out.println("polled in testGraph:" + mhk.pollMax());
		 * System.out.println("polled in testGraph:" + mhk.pollMax());
		 * System.out.println("polled in testGraph:" + mhk.pollMax());
		 */

		/****************************************************************************
		 * Code to test create and addEdge method of graph
		 ***************************************************************************/
		/*
		 * Graph g = new Graph(10); g.addEdge(1, 2, 15); g.addEdge(2, 3, 15);
		 * g.addEdge(4, 9, 15); g.addEdge(7, 2, 15); g.addEdge(8, 3, 15); g.addEdge(3,
		 * 8, 15); g.addEdge(7, 6, 15); g.print();
		 */

		/****************************************************************************
		 * Code to generate graph using percentage
		 ***************************************************************************/
		// GraphGenerator graphGenerator = new GraphGenerator();
		// Graph g = graphGenerator.byPercentage(5000, 20);

		/****************************************************************************
		 * Code to generate graph using degree
		 ***************************************************************************/
		// GraphGenerator graphGenerator = new GraphGenerator();
		// Graph g = graphGenerator.byDegree(5000, 6);

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

		/****************************************************************************
		 * Code to check time difference b/w sorting a int and sorting an edge
		 ***************************************************************************/
		/*
		 * GraphGenerator graphGenerator = new GraphGenerator(5000); Graph g =
		 * graphGenerator.byDegree(1000); System.out.println("g.numberofEdge " +
		 * g.getNumberOfEdge());
		 * 
		 * Edge[] edgelist = new Edge[g.getNumberOfEdge()]; int[] intList = new
		 * int[g.getNumberOfEdge()];
		 * 
		 * //adding edges in array for (int i = 0, k=0; i < g.G.length; i++) {
		 * ArrayList<Edge> adjList = new ArrayList<>(g.getLinkedListAtPosition(i)); for
		 * (int j = 0; j < adjList.size(); j++) edgelist[k++] = adjList.get(j); }
		 * 
		 * //adding int in array for (int i = 0, k=0; i < g.G.length; i++) {
		 * ArrayList<Edge> adjList = new ArrayList<>(g.getLinkedListAtPosition(i)); for
		 * (int j = 0; j < adjList.size(); j++) intList[k++] = adjList.get(j).getW(); }
		 * 
		 * long startTime =0, endTime =0; startTime = System.currentTimeMillis();
		 * Arrays.sort(edgelist); endTime = System.currentTimeMillis();
		 * 
		 * // for(int i=0; i<edgelist.length; i++) System.out.print(edgelist[i].w+ " ");
		 * 
		 * System.out.println("\n Time taken to sort Edge list: "+(endTime -
		 * startTime)+"ms");
		 * 
		 * startTime = System.currentTimeMillis(); Arrays.sort(intList); endTime =
		 * System.currentTimeMillis();
		 * 
		 * // for(int i=0; i<intList.length; i++) System.out.print(intList[i]+" ");
		 * 
		 * System.out.println("\n Time taken to sort int list: "+ (endTime -
		 * startTime)+"ms");
		 */

		/****************************************************************************
		 * Code to test maxHeap for kruskal
		 ***************************************************************************/
		/*
		 * GraphGenerator graphGenerator = new GraphGenerator(5000); Graph g =
		 * graphGenerator.byDegree(1000); System.out.println("g.numberofEdge " +
		 * g.getNumberOfEdge()); MaxHeapForKruskal maxHeap = new
		 * MaxHeapForKruskal(g.getNumberOfEdge()); Edge[] elist = new
		 * Edge[g.getNumberOfEdge()];
		 * 
		 * int k = 0;
		 * 
		 * for (int i = 0; i < g.G.length; i++) { ArrayList<Edge> adjList = new
		 * ArrayList<>(g.getLinkedListAtPosition(i)); //adding edges in heap for (Edge
		 * edge : adjList) maxHeap.add(edge); //adding edges in array for (int j = 0; j
		 * < adjList.size(); j++) elist[k++] = adjList.get(j); }
		 * System.out.println("size of elist: " + elist.length); Arrays.sort(elist);
		 * 
		 * Edge temp; Boolean b= false; for (int s = 0; s < elist.length &&
		 * !(maxHeap.isNull()); s++) { temp = maxHeap.pollMax(); if (elist[s].w !=
		 * temp.w) { System.out.println("elist edge: " + elist[s] + "is not same as " +
		 * temp); b = true; } } if(b) System.out.println("heap failing"); else
		 * System.out.println("Heap working fine");
		 */

	}

}
