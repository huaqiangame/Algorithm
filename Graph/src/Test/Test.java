package Test;
import java.util.Scanner;

import Graph.BreadthFirstSearch;
import Graph.Graph;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = Integer.parseInt(sc.nextLine());
		int E = Integer.parseInt(sc.nextLine());
		Graph g = new Graph(V);
		for (int i = 0; i < E; i++) {
			String line[] = sc.nextLine().split(" ");
			int v = Integer.parseInt(line[0]);
			int w = Integer.parseInt(line[1]);
			g.addEdge(v, w);
		}
		
		for (int i = 0; i < V; i++) {
			BreadthFirstSearch search = new BreadthFirstSearch(g, i);
			System.out.println("begin: " + i + " count: " + search.count());
			for (int j = 0; j < V; j++) {
				System.out.println(i + " to " + j + ": " + search.pathTo(j));
			}
		}
	}
	
}
