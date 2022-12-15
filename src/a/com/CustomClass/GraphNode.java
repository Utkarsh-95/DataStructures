package a.com.CustomClass;

import java.util.ArrayList;

public class GraphNode {

	private String name;
	private int index;// index is used to map this Node's name with index of Adjacency Matrix' cell#
	private ArrayList<GraphNode> neigbhours = new ArrayList<>();
	private boolean isVisited;
	private GraphNode parent;

//	for inserting direct node like "V1"
	public GraphNode(String name) {
		this.name = name;
	}

//	for inserting node like "V"+1
	public GraphNode(String name, int index) {
		this.name = name+""+index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<GraphNode> getNeigbhours() {
		return neigbhours;
	}

	public void setNeigbhours(ArrayList<GraphNode> neigbhours) {
		this.neigbhours = neigbhours;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public GraphNode getParent() {
		return parent;
	}

	public void setParent(GraphNode parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return name;
	}

}
