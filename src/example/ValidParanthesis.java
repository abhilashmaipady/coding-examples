package example;

import exception.OutOfStackIndexException;
import ref.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		ValidParanthesis vp = new ValidParanthesis();
		String testInput = "()";
		System.out.println(testInput + ":" + vp.isValid(testInput));
	}
	
	public boolean isValid(String s) {
		try {
		Stack<Character> stack = new Stack();
		boolean flag = true;
        for(int i=0; i < s.length(); i++) 
        	if(!insertionOrDeletion(s.charAt(i), stack)) {
        		flag = false;
        		break;
        	}
        
        if(flag && stack.getTop() == 0)
        	return true;
        else
        	return false;
		} catch(OutOfStackIndexException ex) {
			System.err.println("Exception occured");
			return false;
		}
        
    }
	public boolean insertionOrDeletion(Character c, Stack stack) throws OutOfStackIndexException {
		switch(c) {
			case '{':
			case '(':
			case '[':
					stack.push(c);
					return true;
			case '}':
			case ')':
			case ']':
					Character last = (Character) stack.pop();
					if(last == '{' && c == '}') return true;
					if(last == '(' && c == ')') return true;
					if(last == '[' && c == ']') return true;
					return false;
			default:
					return false;
		}
	}
}
