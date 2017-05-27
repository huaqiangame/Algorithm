package edgeWeightedDiGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BellmanFordSP {

	private Queue<Integer> queue; // 需要被放松的顶点
	private boolean[] onQueue; // 顶点是否在队列中
	private DirectedEdge[] edgeTo;
	private double[] disTo;
	private List<DirectedEdge> cycle;
	private int cost;
	
	public BellmanFordSP(EdgeWeightDiGraph g, int begin) {
		queue = new LinkedList<Integer>();
		onQueue = new boolean[g.V()];
		edgeTo = new DirectedEdge[g.V()];
		disTo = new double[g.V()];
		cost = 0;
		for (int i = 0; i < g.V(); i++) {
			disTo[i] = Double.POSITIVE_INFINITY;
		}
		disTo[begin] = 0;
		onQueue[begin] = true;
		queue.offer(begin);
		while (!queue.isEmpty() && !hasNagetiveCycle()) {
			Integer node = queue.poll();
			onQueue[node] = false;
			relax(g, node);
		}
		if (hasNagetiveCycle()) {
			System.out.println("Nagetive cycle!!");
		}
	}
	
	private void relax(EdgeWeightDiGraph g, int v) {
		for (DirectedEdge e : g.adj(v)) {
			int to = e.getTo();
			if (disTo[to] > disTo[v] + e.weight()) {
				disTo[to] = disTo[v] + e.weight();
				edgeTo[to] = e;
				
				if (!onQueue[to]) {
					queue.offer(to);
					onQueue[to] = true;
				}
			}
			if (cost++ % g.V() == 0) {
				findNagativeCycle();
			}
		}
	}
	
	public double disTo(int v) {
		return disTo[v];
	}
	
	public boolean hasPath(int v) {
		return disTo[v] < Double.POSITIVE_INFINITY;
	}
	
	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPath(v)) return null;
		List<DirectedEdge> path = new ArrayList<>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.getFrom()]) {
			path.add(0, e);
		}
		return path;
	}
	
	private void findNagativeCycle() {
		EdgeWeightDiGraph tempG = new EdgeWeightDiGraph(edgeTo.length);
		for (int i = 0; i < edgeTo.length; i++) {
			DirectedEdge e = edgeTo[i];
			if (e != null) {
				tempG.addEdge(e);
			}
		}
		DirectedCycle directedCycle = new DirectedCycle(tempG);
		if (directedCycle.hasCycle()) {
			for (Integer v : directedCycle.cycle()) {
				cycle = new ArrayList<>();
				cycle.add(edgeTo[v]);
			}
		}
	}
	
	public boolean hasNagetiveCycle() {
		return cycle != null;
	}
	
	public Iterable<DirectedEdge> nagetiveCycle() {
		return cycle;
	}
}
