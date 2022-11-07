package example;

import java.util.Map;

public class RomanNumbers {

	private static final char LETTER_M = 'M';
	private static final char LETTER_D = 'D';
	private static final char LETTER_C = 'C';
	private static final char LETTER_L = 'L';
	private static final char LETTER_X = 'X';
	private static final char LETTER_V = 'V';
	private static final char LETTER_I = 'I';

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RomanNumbers rn = new RomanNumbers();
		
		String romanNumber1 = "MCMXCIV";
		System.out.println(romanNumber1+": "+rn.romanToInt(romanNumber1));
		
		String romanNumber2 = "IV";
		System.out.println(romanNumber2+": "+rn.romanToInt(romanNumber2));
		
		String romanNumber3 = "LVIII";
		System.out.println(romanNumber3+": "+rn.romanToInt(romanNumber3));
	}
	
	public int romanToInt(String s) {
		int num = 0;
		Map<Character, Integer> lookupMap = getLookup();
		Integer iterator = 0;
		
		while(iterator < s.length()) {
			Character current = s.charAt(iterator);
			Character next = iterator+1 < s.length() ? s.charAt(iterator+1) : null; 
			if(null == next) {
				num += lookupMap.get(current);
				break;
			}	
			if(current == LETTER_I) {
				if(next == LETTER_V) {iterator+=2; num += 4;continue;};
				if(next == LETTER_X) {iterator+=2; num += 9;continue;};
				
			}
			
			if(current == LETTER_X) {
				if(next == LETTER_L) {iterator+=2; num += 40;continue;};
				if(next == LETTER_C) {iterator+=2; num += 90;continue;};
				
			}
			
			if(current == LETTER_C) {
				if(next == LETTER_D) {iterator+=2; num += 400;continue;};
				if(next == LETTER_M) {iterator+=2; num += 900;continue;};
			}
			
			num += lookupMap.get(current);
			
			iterator += 1;

//			iterator++;
		}
		return num;
    }


	private Map<Character, Integer> getLookup() {
		return Map.of(LETTER_I,1, LETTER_V, 5, LETTER_X, 10, LETTER_L, 50, LETTER_C, 100, LETTER_D, 500, LETTER_M, 1000);
	}

}
