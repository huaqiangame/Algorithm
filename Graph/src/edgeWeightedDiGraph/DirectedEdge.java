package edgeWeightedDiGraph;

public class DirectedEdge {
	
	private double weight;
	private int from;
	private int to;
	
	public DirectedEdge(int from, int to, double weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public int getFrom() {
		return from;
	}
	
	public int getTo() {
		return to;
	}
	
	public double weight() {
		return weight;
	}
	
	public int compareTo(DirectedEdge e) {
		if (weight > e.weight()) return 1;
		if (weight < e.weight()) return -1;
		return 0;
	}
	
	public String toString() {
		String s = from + " -> " + to + ", weight: " + weight;
		return s;
	}

}
