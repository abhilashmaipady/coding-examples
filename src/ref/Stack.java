package ref;

import java.util.ArrayList;
import java.util.List;

import exception.OutOfStackIndexException;

public class Stack<T> {
	
	private List<T> stack;
	private int top;
	
	public Stack() {
		stack = new ArrayList<T>();
		top = 0;
	}
	
	public void push(T item) {
		stack.add(item);
		top++;
	}
	
	public T pop() throws OutOfStackIndexException {
		if(top == 0)
			throw new OutOfStackIndexException();
		T item = stack.remove(top-1);
		top--;
		return item;
	}

	public int getTop() {
		return top;
	}

}
