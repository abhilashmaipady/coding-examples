package example;

public class MinimumSwap {

	static int minimumSwaps(int[] arr) {
		int noOfSwap = 0;
		checkOrder();
		
		return noOfSwap;
    }
	
	private static int checkOrder(int[] arr) {
		int item = arr[0];
		for(int ele: arr) {
			if(ele > item) break;
			item = ele;
		}
		return item;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {7, 1, 3, 2, 4, 5, 6};
		minimumSwaps(arr);
	}

}
