package a.graph.gfgstriv;

import java.util.Comparator;

//Pair of class is used for Dijkstra Algo & Prim's Algo for PriorityQueue of dist, node
public class PairNode implements Comparator<PairNode> {

	private int v;
	private int weight;

	public PairNode() {
	}

	public PairNode(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}

	public int getV() {
		return v;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compare(PairNode o1, PairNode o2) {
		if (o1.getWeight() < o2.getWeight()) {
			return -1;
		}
		if (o1.getWeight() > o2.getWeight()) {
			return 1;
		}
		return 0;
	}

}
