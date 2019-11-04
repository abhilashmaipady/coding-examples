package example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
class MaximumException extends Exception {
	private static final long serialVersionUID = 1L;

	public MaximumException() {
		// TODO Auto-generated constructor stub
	}
	public MaximumException(String msg) {
		this.message = msg;
	}
	private String message;
	void printMessage() {
		System.out.println(this.message);
	}
}
public class Bribe {

	private static Stack<Integer> primary;
	private static Stack<Integer> secondary;
	private static Map<Integer, Integer> bribeMap;
	
	static void minimumBribes(int[] q) {
		primary = new Stack<Integer>();
		secondary = new Stack<Integer>();
		bribeMap = new HashMap<Integer, Integer>();
		int totalBribe = 0;
		try {
			for(int element: q) {
				if(compareWithPrimary(element)) {
					primary.push(element);
				} else {
					int bribe = pushToSecondary(element);
					totalBribe += bribe;
					primary.push(element);
					popFromSecondary();
				}
			}
			System.out.println(totalBribe);
		} catch (MaximumException e) {
			// TODO: handle exception
			e.printMessage();
		}
		
    }
	private static boolean compareWithPrimary(int e) {
		if(primary.empty()) return true;
		int top = primary.peek();
		return e > top;
	}
	
	private static int pushToSecondary(int e) throws MaximumException{
		int top, count = 0;
		do {
			top = primary.pop();
			incrementBribe(top);
			secondary.push(top);
			count++;
		} while(!compareWithPrimary(e));
		return count;
	}
	
	private static void incrementBribe(int e) throws MaximumException {
		int count = null == bribeMap.get(e) ? 0 : bribeMap.get(e);
		if(count >= 2) {
			throw new MaximumException("Too chaotic");
		} else {
			bribeMap.put(e, count+1);
		}
	}
	
	private static void popFromSecondary() {
		while(!secondary.empty()) {
			primary.push(secondary.pop());
		}
	}
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
