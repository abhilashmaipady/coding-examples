package example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class MinimumSwap {

	private static Stack<Integer> stack;
	static int minimumSwaps(int[] arr) {
		int noOfSwap = 0;
		int index = 0;
		int swapIndex;
		while(true) {
			stack = new Stack<Integer>();
			index = findOdd(arr);
			if(index == arr.length-1) break;
			swapIndex = findSwapItem(arr, arr[index], index+1);
//			if(swapIndex == arr.length || index == swapIndex) break;
			swap(arr, index, swapIndex);
			noOfSwap++;
		}

		
		return noOfSwap;
    }
	
	private static int findOdd(int[] arr) {
		int index = 0;
		for(int i=index+1;i<arr.length;i++) {
			if(arr[index] < arr[i]) index = i;
			else break;
		}
		return index;
	}
	
	private static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	private static int findSwapItem(int[] arr, int item, int index) {
		int top = index;
		for(int i=index;i<arr.length;i++) {
			if(item > arr[i]) {
				top = i;
				if(!insertStack(arr[i])) {
					return i;
				}
			} else {
				return top;
			}
		}
		return top;
	}
	
	private static boolean insertStack(int item) {
		if(!stack.empty()) {
			int top = stack.peek();
			if(item < top) return false;
		}
		stack.push(item);
		return true;
	}
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
