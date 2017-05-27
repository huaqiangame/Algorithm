package DiGraph.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DiGraph.DiGraph;
import DiGraph.DirectedCycle;
import DiGraph.DirectedDFS;
import DiGraph.StrongConnection;

public class Test {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int V = Integer.parseInt(sc.nextLine());
		int E = Integer.parseInt(sc.nextLine());
		DiGraph g = new DiGraph(V);
		
		for (int i = 0; i < E; i++) {
			String line[] = sc.nextLine().split(" ");
			int v = Integer.parseInt(line[0]);
			int w = Integer.parseInt(line[1]);
			g.addEdge(v, w);
		}
//		System.out.println(g.toString());
		
//		List<Integer> sources = new ArrayList<>();
//		sources.add(0);
//		DirectedDFS dfs = new DirectedDFS(g);
//		for (int i = 0; i < V; i++) {
//			System.out.println(dfs.pathTo(i));
//		}
//		System.out.println(dfs.reversePost());
		
//		DirectedCycle cycle = new DirectedCycle(g);
//		System.out.println(cycle.hasCycle());
//		System.out.println(cycle.cycle().toString());
		
		StrongConnection scon = new StrongConnection(g);
		System.out.println(scon.count());
	}
}
