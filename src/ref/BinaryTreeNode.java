package ref;

public class BinaryTreeNode {

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public BinaryTreeNode left, right;
	int startIndex, endIndex;
	long value;
	
	public BinaryTreeNode(int startIndex, int endIndex, long value) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public BinaryTreeNode insert(BinaryTreeNode root, int startIndex, int endIndex, long value) {
		if(startIndex < root.startIndex && endIndex < root.startIndex) {
			if(null != root.left) {
				root.left = insert(root.left, startIndex, endIndex, value);
			} else {
				root.left = new BinaryTreeNode(startIndex, endIndex, value);
			}
			
		} else if(startIndex > root.endIndex && endIndex > root.endIndex) {
			if(null != root.right) {
				root.right = insert(root.right, startIndex, endIndex, value);
			} else {
				root.right = new BinaryTreeNode(startIndex, endIndex, value);
			}
			
		} else if(startIndex == root.startIndex && endIndex == root.endIndex) {
			root.value += value;
		} else if(startIndex == root.startIndex && endIndex < root.endIndex) {
			root.startIndex = endIndex + 1;
			BinaryTreeNode newRootNode = new BinaryTreeNode(startIndex, endIndex, root.value + value);
			newRootNode.left = root.left;
			newRootNode.right = root;
			return newRootNode;
			
		} else if(startIndex < root.startIndex && endIndex == root.endIndex) {
			root.endIndex = startIndex - 1;
			BinaryTreeNode newRootNode = new BinaryTreeNode(startIndex, endIndex, root.value + value);
			newRootNode.right = root.right;
			newRootNode.left = root;
			return newRootNode;
			
		} else if(startIndex > root.startIndex && endIndex == root.endIndex) {
			root.value += value;
		}
		
		else if(startIndex < root.startIndex && root.startIndex < endIndex) {
			if(null != root.left) {
				root.left = insert(root.left, startIndex, root.startIndex - 1, value);
			} else {
				root.left = new BinaryTreeNode(startIndex, root.startIndex - 1, value);
			}
			root = insert(root, root.startIndex, endIndex, value);
		} else if(startIndex < root.endIndex && root.endIndex < endIndex) {
			if(null != root.right) {
				root.right = insert(root.right, root.endIndex + 1, endIndex, value);
			} else {
				root.right = new BinaryTreeNode(root.endIndex + 1, endIndex, value);
			}
		}
		return root;
	}

}
