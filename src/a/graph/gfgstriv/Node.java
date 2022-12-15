package a.graph.gfgstriv;

import java.util.Comparator;

public class Node implements Comparator<Node> {
	// for kruskal algo

	private int u;
	private int v;
	private int weight;

	public Node(int u, int v, int weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	public int getU() {
		return u;
	}

	public int getV() {
		return v;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compare(Node o1, Node o2) {
		if (o1.getWeight() < o2.getWeight()) {
			return -1;
		} else if (o1.getWeight() > o2.getWeight()) {
			return 1;
		}
		return 0;
	}

}
