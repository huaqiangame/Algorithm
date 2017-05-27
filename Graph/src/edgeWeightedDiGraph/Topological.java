package edgeWeightedDiGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topological { // 深搜解决图的可达性和路径，保存拓扑排序
	
	private boolean[] isMarked; // 是否可达
	private Integer[] edgeTo; // 记录路径
	private List<Integer> begin; // 开始节点们
	
	private List<Integer> reversePost; // 拓扑排序顺序
	
	public Topological(EdgeWeightDiGraph g) { // 所有节点遍历
		reversePost = new ArrayList<>();
		isMarked = new boolean[g.V()];
		edgeTo = new Integer[g.V()];
		List<Integer> begins = new ArrayList<>();
		for (int i = 0; i < g.V(); i++) {
			begins.add(i);
		}
		this.begin = begins;
		for (int i = 0; i < g.V(); i++) {
			if (!isMarked[i]) {
				dfs(g, i);
			}
		}
	}
	
	public void dfs(EdgeWeightDiGraph g, int begin) { // 深搜将所有节点遍历,标记被访问过的节点
		isMarked[begin] = true;
		for (DirectedEdge e : g.adj(begin)) {
			int node = e.getTo();
			if (!isMarked[node]) {
				edgeTo[node] = begin;
				dfs(g, node);
			}
		}
		reversePost.add(0, begin);
	}
	
	public boolean hasPath(int v) {
		return isMarked[v];
	}
	
	public String pathTo(int v) {
		if (!hasPath(v)) {
			return "";
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		for (int i = v; !begin.contains(i); i = edgeTo[i]) {
			stack.push(edgeTo[i]);
		}
		
		return stack.toString();
	}
	
	public Iterable<Integer> reversePost() {
		return reversePost;
	}
}
