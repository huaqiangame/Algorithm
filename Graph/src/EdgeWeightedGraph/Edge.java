package EdgeWeightedGraph;

public class Edge { // ͼ�ı�

	private int v; // ����һ���ڵ�
	private int w; // ��һ���ڵ�
	private double weight; // �ߵ�Ȩ��
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either() { // ��������һ���ڵ�
		return v;
	}
	
	public int other(int i) { // ��֪һ���ڵ㣬������һ���ڵ�
		if (i == v) return w;
		if (i == w) return v;
		System.out.println("error! arg expect: " + v + " or " + w + ",but receive:" + i);
		return -1;
	}
	
	public int compareTo(Edge e) { // ����Ȩ�رȽ�
		if (weight > e.weight) return 1;
		else if (weight < e.weight) return -1;
		return 0;
	}
	
	public String toString() {
		String s = v + " to " + w + ", weight: " + weight;
		return s;
	}
	
	public double weight() {
		return weight;
	}
	
}
