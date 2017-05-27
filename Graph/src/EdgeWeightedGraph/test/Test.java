package EdgeWeightedGraph.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import EdgeWeightedGraph.Edge;
import EdgeWeightedGraph.EdgeWeightGraph;
import EdgeWeightedGraph.KruskalMST;
import EdgeWeightedGraph.LazyPrimMST;

public class Test {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int V = Integer.parseInt(sc.nextLine());
		int E = Integer.parseInt(sc.nextLine());
		EdgeWeightGraph g = new EdgeWeightGraph(V);
		
		for (int i = 0; i < E; i++) {
			String line[] = sc.nextLine().split(" ");
			int v = Integer.parseInt(line[0]);
			int w = Integer.parseInt(line[1]);
			double weight = Double.parseDouble(line[2]);
			Edge e = new Edge(v, w, weight);
			g.addEdge(e);
		}
		
		System.out.println("Prim");
		LazyPrimMST lpMST = new LazyPrimMST(g);
		System.out.println("MST weight: " + lpMST.weight());
		for (Edge e : lpMST.edges()) {
			int v = e.either();
			int w = e.other(v);
			System.out.println(v + " " + w + " " + e.weight());
		}
		
		System.out.println("Kruskal");
		KruskalMST kMST = new KruskalMST(g);
		System.out.println("MST weight: " + kMST.weight());
		for (Edge e : kMST.edges()) {
			int v = e.either();
			int w = e.other(v);
			System.out.println(v + " " + w + " " + e.weight());
		}
		
	}
}
