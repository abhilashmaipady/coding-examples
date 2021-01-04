package example;

import ref.BinaryTreeNode;

public class ArrayManipulation {

	static long arrayManipulation(int n, int[][] queries) {

		int[] rootItem = queries[0];
		BinaryTreeNode root = new BinaryTreeNode(rootItem[0], rootItem[1], rootItem[2]);
		for(int i=1; i < n; i++) {
			int[] item = queries[i];
			root.insert(root, item[0], item[1], item[2] - 1);
		}
				
		return findMaxValue(root);
    }
	
	static long findMaxValue(BinaryTreeNode root) {
		long maxValue = 0;
		if(null == root) {
			return maxValue;
		}
		
		if(root.getValue() > maxValue) {
			maxValue = root.getValue();
		}
		long leftMaxValue = findMaxValue(root.left);
		if(leftMaxValue > maxValue) {
			maxValue = leftMaxValue;
		}
		long rightMaxValue = findMaxValue(root.right);
		if(rightMaxValue > maxValue) {
			maxValue = rightMaxValue;
		}
		return maxValue;
	}
	
	static void printBinaryTree(BinaryTreeNode root) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] queries = new int[][] {{1,2,100},{2,5,100},{3,4,100}};
		
		System.out.println(arrayManipulation(n, queries));
	}

}
