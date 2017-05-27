package EdgeWeightedGraph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightGraph {
	
	private List<Edge>[] adj; // �ڽӱ����
	private int V;
	private int E;
	
	public EdgeWeightGraph(int V) { // ����һ��V���ڵ㣬û�бߵ�ͼ
		this.V = V;
		this.E = 0;
		adj = (List<Edge>[])new List[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public Iterable<Edge> adj(int v) { // ����v�����ı�
		return adj[v];
	}
	
	public Iterable<Edge> edges() { // �������бߵļ���
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			for (Edge e : adj(i)) {
				if (e.other(i) > i) {
					edges.add(e);
				}
			}
		}
		return edges;
	}
	
	public String toString() {
		String s = V + " ������, " + E + " ����\n";
		for (int i = 0; i < V; i++) {
			s += i + ": ";
			for (Edge e : adj(i)) {
				s += e.other(i) + " [" + e.weight() + "], ";
			}
			s += "\n";
		}
		return s;
	}
	
}
