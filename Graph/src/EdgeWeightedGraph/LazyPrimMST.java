package EdgeWeightedGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMST {
	private boolean[] isMark; // 生成树的顶点
	private List<Edge> mst; // 生成树的边
	private Queue<Edge> pqueue; // 横切边
	
	Comparator<Edge> edgeComparator = new Comparator<Edge>() {
		public int compare(Edge e1, Edge e2) {
			return e1.compareTo(e2);
		}
	};
	
	public LazyPrimMST(EdgeWeightGraph g) {
		isMark = new boolean[g.V()];
		mst = new ArrayList<>();
		pqueue = new PriorityQueue<>(edgeComparator);
		visit(g, 0);
		while (!pqueue.isEmpty()) {
			Edge e = pqueue.poll();
			int v = e.either();
			int w = e.other(v);
			if (isMark[v] && isMark[w]) continue; // 无效的边
			mst.add(e);
			if (!isMark[v]) visit(g, v);
			if (!isMark[w]) visit(g, w);
		}
	}
	
	private void visit(EdgeWeightGraph g, int node) { // 访问当前节点，将附近的边全部加进优先队列中
		isMark[node] = true;
		for (Edge e : g.adj(node)) {
			if (!isMark[e.other(node)]) {
				pqueue.add(e);
			}
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
	
}
