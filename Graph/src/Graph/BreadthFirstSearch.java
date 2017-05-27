package Graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
	
	private boolean[] isMarked;
	private Integer[] edgeTo;
	private int begin;
	private int count; // 多少个点连通
	
	public BreadthFirstSearch(Graph g, int begin) {
		isMarked = new boolean[g.V()];
		edgeTo = new Integer[g.V()];
		this.begin = begin;
		count = 0;
		bfs(g, begin);
	}
	
	private void bfs(Graph g, int begin) {
		Queue<Integer> queue = new LinkedList<>();
		isMarked[begin] = true;
		queue.offer(begin);
		while (!queue.isEmpty()) {
			Integer temp = queue.poll();
			for (Integer i : g.adj(temp)) {
				if (!isMarked[i]) {
					isMarked[i] = true;
					count++;
					edgeTo[i] = temp;
					queue.offer(i);
				}
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
