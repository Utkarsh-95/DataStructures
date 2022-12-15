package a.com.CustomClass;

public class SingleNode {
	public int value;
	public SingleNode next;

	public SingleNode(int value) {
		this.value = value;
	}

	public SingleNode() {
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SingleNode getNext() {
		return next;
	}

	public void setNext(SingleNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return value + "";
	}

}
