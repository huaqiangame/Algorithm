package DiGraph;

import java.util.Stack;

public class DirectedCycle { // �ж�ͼ�Ƿ��л�
	
	private boolean[] inStack;
	private Stack<Integer> cycle;
	private Integer[] edgeTo;
	private boolean[] isMarked;
	
	public DirectedCycle(DiGraph g) {
		inStack = new boolean[g.V()];
		edgeTo = new Integer[g.V()];
		isMarked = new boolean[g.V()];
		for (int i = 0; i < g.V(); i++) {
			if (!isMarked[i]) {
				dfs(g, i);
			}
		}
	}
	
	private void dfs(DiGraph g, int begin) {
		isMarked[begin] = true;
		inStack[begin] = true;
		for (Integer node : g.adj(begin)) {
			if (hasCycle()) return;
			
			if (!isMarked[node]) {
				edgeTo[node] = begin;
				dfs(g, node);
			} else if (inStack[node]) { // �����ǰ·��Stack�к���node�����ٴη��ʵĻ���˵���л�
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
