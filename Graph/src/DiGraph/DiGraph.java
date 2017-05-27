package DiGraph;
import java.util.ArrayList;
import java.util.List;

public class DiGraph {
	private int V;  // �ڵ���
	private int E;  // �ߵ���Ŀ
	private List<Integer>[] adj; // �ڽӱ����
	
	public DiGraph(int V) { // �����ڵ����ΪV��û�бߵ�����ͼ
		this.V = V;
		this.E = 0;
		adj = (List<Integer>[])new List[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) { // ������ͼ�����ӱ�v->w
		adj[v].add(w);
		E++;
	}
	
	public List<Integer> adj(int v) { // ����v�ڵ�����ڽڵ�
		return adj[v];
	}
	
	public int V() { // ���ؽڵ���
		return V;
	}
	
	public int E() { // ���رߵ���Ŀ
		return E;
	}
	
	public String toString() { // ��ӡͼ
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
	
	public DiGraph reverse() {
		DiGraph g = new DiGraph(V);
		for (int i = 0; i < V; i++) {
			for (Integer node : adj[i]) {
				g.addEdge(node, i);
			}
		}
		return g;
	}
}
