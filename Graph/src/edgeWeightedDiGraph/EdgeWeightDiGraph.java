package edgeWeightedDiGraph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightDiGraph {
	
	private List<DirectedEdge>[] adj; // 邻接表矩阵
	private int V; // 点的数目
	private int E; // 边的数目
	
	public EdgeWeightDiGraph(int V) {
		this.V = V;
		E = 0;
		adj = (List<DirectedEdge>[]) new List[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(DirectedEdge e) {
		adj[e.getFrom()].add(e);
		E++;
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}
	
	public Iterable<DirectedEdge> edges() {
		List<DirectedEdge> edges = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			for (DirectedEdge e : adj[i]) {
				edges.add(e);
			}
		}
		return edges;
	}
	
	public String toString() {
		String s = V + " 个顶点, " + E + " 条边\n";
		for (int i = 0; i < V; i++) {
			s += i + ": ";
			for (DirectedEdge e : adj(i)) {
				s += e.getTo() + " [" + e.weight() + "], ";
			}
			s += "\n";
		}
		return s;
	}

}
