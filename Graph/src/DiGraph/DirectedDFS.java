package DiGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DirectedDFS { // ���ѽ��ͼ�Ŀɴ��Ժ�·����������������
	
	private boolean[] isMarked; // �Ƿ�ɴ�
	private Integer[] edgeTo; // ��¼·��
	private List<Integer> begin; // ��ʼ�ڵ���
	
	private List<Integer> reversePost; // ��������˳��
	
	public DirectedDFS(DiGraph g) { // ���нڵ����
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
	
	public DirectedDFS(DiGraph g, int begin) { // ��begin�ڵ㿪ʼ����������
		reversePost = new ArrayList<>();
		isMarked = new boolean[g.V()];
		edgeTo = new Integer[g.V()];
		this.begin = new ArrayList<>();
		this.begin.add(begin);
		dfs(g, begin);
	}
	
	public DirectedDFS(DiGraph g, List<Integer> begins) { // �ҳ�һ��begin�����пɴ�ĵط�
		reversePost = new ArrayList<>();
		isMarked = new boolean[g.V()];
		edgeTo = new Integer[g.V()];
		this.begin = begins;
		for (int i = 0; i < begin.size(); i++) {
			if (!isMarked[i]) {
				dfs(g, begin.get(i));
			}
		}
	}
	
	public void dfs(DiGraph g, int begin) { // ���ѽ����нڵ����,��Ǳ����ʹ��Ľڵ�
		isMarked[begin] = true;
		for (Integer node : g.adj(begin)) {
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
