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
		String strA = "";
		String strB = "";
		String action = "Move_To_&";
		int position = 0;
		char curChar = 'N';
		
		//User Input
		System.out.println("XOR Operation");
		System.out.println("Please input banary number to compare :");
		System.out.println("First value:");
		strA = scanner.nextLine();
		System.out.println("Second value:");
		strB = scanner.nextLine();
		
		//Confirm String
		c = new Cursor(strA, strB);
		System.out.println("String to process : " + c.getResult());
		
		while(!action.equals("End")){
			
			switch (action) {
			
			//Move Right To &
			case "Move_To_&":
				curChar = c.getChar(position);
				switch(curChar){
				case '&':
					action = "Get_First_Bit";
					position--;
					break;
				default:
					position++;
				}
				break;
				
			//Get one unprocessed bit of first number
			case "Get_First_Bit":
				curChar = c.getChar(position);
				switch(curChar){
				case '0':
					c.setChar('A', position);
					action = "Move_To_*_For_0";
					position++;
					break;
				case '1':
					c.setChar('B', position);
					action = "Move_To_*_For_1";
					position++;
					break;
				case '*':
					action = "Transform";
					position++;
					break;
				default:
					position--;
					break;
				}
				break;
				
			//0 bit processing block
			//Move to the end of string
			case "Move_To_*_For_0":
				curChar = c.getChar(position);
				switch(curChar){
				case '*':
					action = "Get_Result_For_0";
					position--;
					break;
				default:
					position++;
					break;
				}
				break;
				
			//Get result for bit of second number XOR with 0
			case "Get_Result_For_0":
				curChar = c.getChar(position);
				switch(curChar){
				case '1':
					c.setChar('B', position);
					action = "Move_To_*_For_W1";
					position--;
					break;
				case '0':
					c.setChar('A', position);
					action = "Move_To_*_For_W0";
					position--;
					break;
				default:
					position--;
					break;
				}
				break;
			
			//1 bit processing block
			//Move to the end of string
			case "Move_To_*_For_1":
				curChar = c.getChar(position);
				switch(curChar){
				case '*':
					action = "Get_Result_For_1";
					position--;
					break;
				default:
					position++;
					break;
				}
				break;
				
			//Get result for bit of second number XOR with 0
			case "Get_Result_For_1":
				curChar = c.getChar(position);
				switch(curChar){
				case '1':
					c.setChar('B', position);
					action = "Move_To_*_For_W0";
					position--;
					break;
				case '0':
					c.setChar('A', position);
					action = "Move_To_*_For_W1";
					position--;
					break;
				default:
					position--;
					break;
				}
				break;
				
			//Write Result
			case "Move_To_*_For_W1" :
				curChar = c.getChar(position);
				switch(curChar){
				case '*':
					action = "Write_1";
					position--;
					break;
				default:
					position--;
				}
				break;
				
			case "Move_To_*_For_W0" :
				curChar = c.getChar(position);
				switch(curChar){
				case '*':
					action = "Write_0";
					position--;
					break;
				default:
					position--;
				}
				break;	
				
			case "Write_0":
				curChar = c.getChar(position);
				switch(curChar){
				case '*':
					c.setChar('0', position);
					position++;
					action = "Move_To_&";
					break;
				default:
					position--;
					break;
				}
				break;
				
			case "Write_1":
				curChar = c.getChar(position);
				switch(curChar){
				case '*':
					c.setChar('1', position);
					position++;
					action = "Move_To_&";
					break;
				default:
					position--;
					break;
				}
				break;
				
			case "Transform":
				curChar = c.getChar(position);
				switch(curChar){
				case 'A':
					c.setChar('0', position);
					position++;
					break;
				case 'B':
					c.setChar('1', position);
					position++;
					break;
				case '*':
					action = "End";
					break;
				default:
					position++;
					break;
				}
				break;
			
			//Default For Action
			default:
				action = "End";
				break;
			}
		}
		
		System.out.println("Result String : " + c.getResult());
	}
}
