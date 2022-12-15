package node;

import java.util.ArrayList;

public class TestGraphNode {

	private String name;
	private ArrayList<TestGraphNode> neigbhours = new ArrayList<>();
	private boolean isVisited;
	private TestGraphNode parent;

	public TestGraphNode(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<TestGraphNode> getNeigbhours() {
		return neigbhours;
	}

	public void setNeighbours(ArrayList<TestGraphNode> neighbours) {
		this.neigbhours = neighbours;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public TestGraphNode getParent() {
		return parent;
	}

	public void setParent(TestGraphNode parent) {
		this.parent = parent;
	}

}
