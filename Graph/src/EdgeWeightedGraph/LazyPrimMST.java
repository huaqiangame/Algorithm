package EdgeWeightedGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMST {
	private boolean[] isMark; // �������Ķ���
	private List<Edge> mst; // �������ı�
	private Queue<Edge> pqueue; // ���б�
	
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
			if (isMark[v] && isMark[w]) continue; // ��Ч�ı�
			mst.add(e);
			if (!isMark[v]) visit(g, v);
			if (!isMark[w]) visit(g, w);
		}
	}
	
	private void visit(EdgeWeightGraph g, int node) { // ���ʵ�ǰ�ڵ㣬�������ı�ȫ���ӽ����ȶ�����
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
