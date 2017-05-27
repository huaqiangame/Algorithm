package EdgeWeightedGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST {

	private List<Edge> mst; // MST的边的集合
	private Queue<Edge> pqueue; // 边的集合
	
	Comparator<Edge> edgeComparator = new Comparator<Edge>() {
		public int compare(Edge e1, Edge e2) {
			return e1.compareTo(e2);
		}
	};
	
	public KruskalMST(EdgeWeightGraph g) {
		pqueue = new PriorityQueue<>(edgeComparator);
		mst = new ArrayList<>();
		edgeAddAll(g);
		while (!pqueue.isEmpty() && mst.size() < g.V() - 1) {
			Edge e = pqueue.poll();
			mst.add(e);
			if (hasCycle(g.V())) {
				mst.remove(e);
				continue;
			}
		}
	}
	
	private void edgeAddAll(EdgeWeightGraph g) {
		for (Edge e : g.edges()) {
			pqueue.add(e);
		}
	}
	
	public double weight() {
		double weight = 0;
		for (Edge e : edges()) {
			weight += e.weight();
		}
		return weight;
	}
	
	public Iterable<Edge> edges() {
		return mst;
	}
	
	private boolean hasCycle(int length) {
		EdgeWeightGraph g = new EdgeWeightGraph(length);
		for (Edge e : mst) {
			g.addEdge(e);
		}
		EdgeWeightedCycle cycle = new EdgeWeightedCycle(g);
		return cycle.hasCycle();
	}
	
}
