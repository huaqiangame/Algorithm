package edgeWeightedDiGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraSP {
	
	class QueueItem {
		int node;
		double distance;
		
		public QueueItem(int node, double distance) {
			this.node = node;
			this.distance = distance;
		}
		
		public int compareTo(QueueItem t) {
			if (node > t.node) return 1;
			if (node < t.node) return -1;
			return 0;
		}
	}
	
	Comparator<QueueItem> itemComparator = new Comparator<QueueItem>() {
		public int compare(QueueItem t1, QueueItem t2) {
			return t1.compareTo(t2);
		}
	};
	
	private Queue<QueueItem> pq; // ��ȡ��ǰdistance����Сֵ
	private double[] disTo; // �����ľ���
	private DirectedEdge[] edgeTo; // ·��
	
	public DijkstraSP(EdgeWeightDiGraph g, int begin) {
		pq = new PriorityQueue<>(itemComparator);
		disTo = new double[g.V()];
		edgeTo = new DirectedEdge[g.V()];
		for (int i = 0; i < g.V(); i++) {
			disTo[i] = Double.POSITIVE_INFINITY;
		}
		
		pq.add(new QueueItem(0, 0.0));
		disTo[0] = 0;
		while (!pq.isEmpty()) { // ��ȡQueue��Ԫ�أ��ɳڶ�Ӧ�Ķ���ı�
			QueueItem t = pq.poll();
			relax(g, t.node);
		}
	}
	
	private void relax(EdgeWeightDiGraph g, int v) {
		for (DirectedEdge e : g.adj(v)) {
			int to = e.getTo();
			if (disTo[to] > disTo[v] + e.weight()) {
				disTo[to] = disTo[v] + e.weight();
				edgeTo[to] = e;
				
				pq.offer(new QueueItem(to, disTo[to]));
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
