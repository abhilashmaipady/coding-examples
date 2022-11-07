package example;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		
		String[] input1 = {"flower","flow","flight"};
		System.out.println(lcp.longestCommonPrefix(input1));
		
		String[] input2 = {"dog","racecar","car"};
		System.out.println(lcp.longestCommonPrefix(input2));
	}
	
	public String longestCommonPrefix(String[] strs) {
        
		int leastLength = getLeastLength(strs);
		String prefix = "";
		if(strs.length == 0 && strs[0].length() == 0)
			return prefix;
		boolean flag = true;
		for(int i=0; i < leastLength && flag ; i++) {
			char c = strs[0].charAt(i);
			for(String str: strs) {
				if(c != str.charAt(i))
				{
					flag = false;
					break;
				}
			}
			
			if(flag)
				prefix = prefix + strs[0].charAt(i);
		}
		return prefix;
    }

	private int getLeastLength(String[] strs) {
		int length = Integer.MAX_VALUE;
		for(String s: strs) {
			if(s.length() < length) 
				length = s.length();
		}
		if(length == Integer.MAX_VALUE)
			length = 0;
		return length;
	}

}
