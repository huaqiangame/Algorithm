package edgeWeightedDiGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topological { // ���ѽ��ͼ�Ŀɴ��Ժ�·����������������
	
	private boolean[] isMarked; // �Ƿ�ɴ�
	private Integer[] edgeTo; // ��¼·��
	private List<Integer> begin; // ��ʼ�ڵ���
	
	private List<Integer> reversePost; // ��������˳��
	
	public Topological(EdgeWeightDiGraph g) { // ���нڵ����
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
	
	public void dfs(EdgeWeightDiGraph g, int begin) { // ���ѽ����нڵ����,��Ǳ����ʹ��Ľڵ�
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
