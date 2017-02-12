package xorOperation;

import java.util.Arrays;

public class Cursor {
	private StringBuilder result = new StringBuilder();
	private char[] dummy;
	
	public Cursor() {
		// TODO Auto-generated constructor stub
	}
	
	public Cursor(String strA, String strB) {
		dummy = new char[strA.length() + 1] ;
		Arrays.fill(dummy, '*');
		result.append('=' + strA + "&" + strB + "*");
		result.insert(0, dummy, 0, strA.length()+1);
	}
	
	public void setChar(char strReplace, int position) {
		result.setCharAt(position, strReplace);
		}
	
	public char getChar(int indexOfChar){
		return result.charAt(indexOfChar);
	}

	public String getResult() {
		return result.toString();		
	}
	
	public static void main(String[] args) {
		Cursor c = new Cursor("100", "111");
		System.out.println(c.getResult());
		c.setChar('1', 0);
		System.out.println(c.getResult());
	}
		
	

}
