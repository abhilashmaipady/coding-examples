package ref;

public class ArrayManipulationNode {
	int startIndex, endIndex;
	long value;
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public ArrayManipulationNode(int startIndex, int endIndex, long value) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.value = value;
	}
}
