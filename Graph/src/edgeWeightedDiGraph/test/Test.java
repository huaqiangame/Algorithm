package edgeWeightedDiGraph.test;

import java.util.Scanner;

import edgeWeightedDiGraph.AcycleSP;
import edgeWeightedDiGraph.BellmanFordSP;
import edgeWeightedDiGraph.DirectedEdge;
import edgeWeightedDiGraph.EdgeWeightDiGraph;

public class Test {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = Integer.parseInt(sc.nextLine());
		int E = Integer.parseInt(sc.nextLine());
		EdgeWeightDiGraph g = new EdgeWeightDiGraph(V);
		
		for (int i = 0; i < E; i++) {
			String line[] = sc.nextLine().split(" ");
			int v = Integer.parseInt(line[0]);
			int w = Integer.parseInt(line[1]);
			double weight = Double.parseDouble(line[2]);
			DirectedEdge e = new DirectedEdge(v, w, weight);
			g.addEdge(e);
		}
		
//		DijkstraSP dijkstraSp = new DijkstraSP(g, 0);
//		for (int i = 0; i < V; i++) {
//			System.out.println(dijkstraSp.pathTo(i));
//		}
		
//		AcycleSP acycleSP = new AcycleSP(g);
//		for (int i = 0; i < V; i++) {
//			System.out.println(acycleSP.pathTo(i));
//		}
		
		BellmanFordSP bellmanFordSP = new BellmanFordSP(g, 0);
		for (int i = 0; i < V; i++) {
			System.out.println(bellmanFordSP.pathTo(i));
		}
		
		
	}
}
