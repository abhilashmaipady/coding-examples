package example;

public class ArrayManipulation {

	static long arrayManipulation(int n, int[][] queries) {

		// Create Array based on number of element n
		long[] arr = new long[n];
		// Initializing all elements in array to zero
		for(int i=0; i<n ;i++) {
			arr[i]=0;
		}
		
		
		for(int[] row: queries){
			// substracting 1 to normalize with array index
			int i = row[0] - 1;
			int j = row[1] - 1;
			int k = row[2];
			
			while(i <= j) {
				arr[i++] += k;
			}
		}
		
		long maxValue = 0;
		for(int i = 0 ; i < n ; i++) {
			maxValue = maxValue > arr[i] ? maxValue : arr[i];
		}
		return maxValue;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] queries = new int[][] {{1,2,100},{2,5,100},{3,4,100}};
		System.out.println(arrayManipulation(n, queries));
	}

}
