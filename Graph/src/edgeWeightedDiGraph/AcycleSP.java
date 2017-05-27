package edgeWeightedDiGraph;

import java.util.ArrayList;
import java.util.List;

public class AcycleSP { // 无环加权有向图最短路径
	
	private double[] disTo;
	private DirectedEdge[] edgeTo;
	
	public AcycleSP(EdgeWeightDiGraph g) {
		disTo = new double[g.V()];
		edgeTo = new DirectedEdge[g.V()];
		for (int i = 0; i < g.V(); i++) {
			disTo[i] = Double.POSITIVE_INFINITY;
		}
		int count = 0;
		Topological topo = new Topological(g);
		for (Integer node : topo.reversePost()) {
			if (count == 0) disTo[node] = 0;
			relax(g, node);
			count++;
		}
	}
	
	private void relax(EdgeWeightDiGraph g, int v) {
		for (DirectedEdge e : g.adj(v)) {
			int to = e.getTo();
			if (disTo[to] > disTo[v] + e.weight()) {
				disTo[to] = disTo[v] + e.weight();
				edgeTo[to] = e;
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
	
}
