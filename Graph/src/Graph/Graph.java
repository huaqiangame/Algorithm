package Graph;
import java.util.ArrayList;
import java.util.List;

public class Graph {
	private List<Integer>[] adj; // �ڽӱ�
	private int V;	// ������Ŀ
	private int E;	// �ߵ���Ŀ
	
	public Graph(int V) {
		this.V = V;
		adj = (List<Integer>[])new List[V];
		E = 0;
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(adj[v].size(), w);
		adj[w].add(adj[w].size(), v);
		E++;
	}
	
	public List<Integer> adj(int v) {
		return adj[v];
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public String toString() {
		String s = V + " ������, " + E + " ����\n";
		for (int i = 0; i < V; i++) {
			s += i + ": ";
			for (Integer node : adj(i)) {
				s += node + " ";
			}
			s += "\n";
		}
		return s;
	}

}
