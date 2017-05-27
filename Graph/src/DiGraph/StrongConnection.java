package DiGraph;

/*
 * 1. ��ȡ����ͼ
 * 2. ��ȡ����ͼ����������
 * 3. ������������˳���ԭͼ��������, ��¼countΪ��ͨ����
 * */
public class StrongConnection {
	private boolean[] isMark; // �Ƿ񱻷��ʹ�
	private int[] id;  // ��ͨ����id
	private int count; // ��ǰ��ͨ����
	
	public StrongConnection(DiGraph g) {
		isMark = new boolean[g.V()];
		id = new int[g.V()];
		count = 0;
		// 1.��ȡ����ͼ
		DiGraph reverseG = g.reverse();
		// 2. ��ȡ����ͼ����������
		DirectedDFS dfs = new DirectedDFS(reverseG);
		// 3. ������������˳���ԭͼ��������, ��¼countΪ��ͨ����
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
	
	public boolean isStrongConnect(int v, int w) { // v��w�Ƿ�ǿ��ͨ
		return id[v] == id[w];
	}
	
	public int count() { // ������ͨ��������
		return count;
	}
}
