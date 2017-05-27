package EdgeWeightedGraph;

public class Edge { // 图的边

	private int v; // 其中一个节点
	private int w; // 另一个节点
	private double weight; // 边的权重
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either() { // 返回其中一个节点
		return v;
	}
	
	public int other(int i) { // 已知一个节点，返回另一个节点
		if (i == v) return w;
		if (i == w) return v;
		System.out.println("error! arg expect: " + v + " or " + w + ",but receive:" + i);
		return -1;
	}
	
	public int compareTo(Edge e) { // 根据权重比较
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
