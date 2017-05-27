package Graph;
import java.util.Stack;

public class DepthFirstSearch {
	private boolean[] isMarked;
	private int begin;
	private int count;
	private Integer[] edgeTo; 
	
	public DepthFirstSearch(Graph g, int begin) {
		isMarked = new boolean[g.V()];
		edgeTo = new Integer[g.V()];
		count = 0;
		this.begin = begin;
		dfs(g, begin);
	}
	
	public void dfs(Graph g, int begin) {
		isMarked[begin] = true;
		for (Integer i : g.adj(begin)) {
			if (!isMarked[i]) {
				edgeTo[i] = begin;
				count++;
				dfs(g, i);
			}
		}
	}
	
	
	public boolean hasPath(int v) {
		return isMarked[v];
	}
	
	public int count() {
		return count;
	}
	
	public String pathTo(int v) {
		if (!hasPath(v)) return "";
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		for (int i = v; i != begin; i = edgeTo[i]) {
			stack.push(edgeTo[i]);
		}
		
		return stack.toString();
	}
	
	
}
