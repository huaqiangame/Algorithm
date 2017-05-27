package DiGraph;

/*
 * 1. 获取反向图
 * 2. 获取反向图的拓扑排序
 * 3. 根据拓扑排序顺序对原图进行深搜, 记录count为连通分量
 * */
public class StrongConnection {
	private boolean[] isMark; // 是否被访问过
	private int[] id;  // 连通分量id
	private int count; // 当前连通分量
	
	public StrongConnection(DiGraph g) {
		isMark = new boolean[g.V()];
		id = new int[g.V()];
		count = 0;
		// 1.获取反向图
		DiGraph reverseG = g.reverse();
		// 2. 获取反向图的拓扑排序
		DirectedDFS dfs = new DirectedDFS(reverseG);
		// 3. 根据拓扑排序顺序对原图进行深搜, 记录count为连通分量
		for (Integer node : dfs.reversePost()) {
			if (!isMark[node]) {
				System.out.println("node: " + node);
				dfs(g, node);
				count++;
			}
		}
	}
	
	private void dfs(DiGraph g, int begin) {
		isMark[begin] = true;
		id[begin] = count;
		for (Integer node : g.adj(begin)) {
			if (!isMark[node]) {
				dfs(g, node);
			}
		}
	}
	
	public boolean isStrongConnect(int v, int w) { // v和w是否强连通
		return id[v] == id[w];
	}
	
	public int count() { // 返回连通分量数量
		return count;
	}
}
