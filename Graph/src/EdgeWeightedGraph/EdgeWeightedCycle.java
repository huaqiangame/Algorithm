package EdgeWeightedGraph;

import java.util.Stack;

public class EdgeWeightedCycle { // �ж�ͼ�Ƿ��л�
	
	private boolean[] inStack;
	private Stack<Integer> cycle;
	private Integer[] edgeTo;
	private boolean[] isMarked;
	
	public EdgeWeightedCycle(EdgeWeightGraph g) {
		inStack = new boolean[g.V()];
		edgeTo = new Integer[g.V()];
		isMarked = new boolean[g.V()];
		for (int i = 0; i < g.V(); i++) {
			if (!isMarked[i]) {
				dfs(g, i);
			}
		}
	}
	
	private void dfs(EdgeWeightGraph g, int begin) {
		isMarked[begin] = true;
		inStack[begin] = true;
		for (Edge e : g.adj(begin)) {
			if (hasCycle()) return;
			
			int node = e.other(begin);
			if (!isMarked[node]) {
				edgeTo[node] = begin;
				dfs(g, node);
			} else if (inStack[node] && edgeTo[begin] != node) { // �����ǰ·��Stack�к���node�����ٴη��ʵĻ���˵���л�
				// ������������
				cycle = new Stack<>();
				for (int i = begin; i != node; i = edgeTo[i]) {
					cycle.push(i);
				}
				cycle.push(node);
				cycle.push(begin);
			}
		}
		inStack[begin] = false;
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}
	
	public Stack<Integer> cycle() {
		return cycle;
	}
	
	
}
