package xorOperation;
import java.util.Scanner;

import xorOperation.Cursor;


public class Main {
	public Main() {
	}

	public static void main(String[] args) {
		//Variable
		Cursor c;
		Scanner scanner = new Scanner(System.in);
		String strA = "1100";
		String strB = "1010";
		String action = "Initial";
		int possition = 0;
		char curChar;
		
		//User Input
		//System.out.println("XOR Operation");
		//System.out.println("Please input banary number to compare :");
		//System.out.println("First value:");
		//strA = scanner.nextLine();
		//System.out.println("Second value:");
		//strB = scanner.nextLine();
		
		//Confirm String
		c = new Cursor(strA, strB);
		System.out.println("String to process : " + c.getResult());
		
		while(!action.equals("End")){
			
			switch (action) {
			
				//==========================================================================
				case "Initial":
					curChar = c.getChar(possition);
					switch (curChar) {
						case '*':
							possition++;
							break ;
						case '1':
							possition++;
							break ;
						case '0':
							possition++;
							break ; 
						case '&':
							action = "MakeFirstDecision";
							break ;
						case 'A':
							action = "MakeFirstDecision";
							break ;
						case 'B':
							action = "MakeFirstDecision";
							break ;
						}
					
				//==========================================================================
				case "MakeFirstDecision":
					curChar = c.getChar(possition - 1);
					switch (curChar) {
						case '1':
							action = "MakeDecisionWith1";
							possition++;
							break ;
						case '0':
							action = "End";//"MakeDecisionWith0";
							c.setChar('T', 2);
							possition++;
							break ; 
						case '*':
							action = "End";
							break ;
						}
				}
		}
		System.out.println("String Result : " + c.getResult() + possition);
	}
}
