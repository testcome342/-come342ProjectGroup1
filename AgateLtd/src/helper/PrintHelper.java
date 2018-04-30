package helper;

public class PrintHelper {

	public static void print(String message) {
		System.out.println(message);
	}
	
	public static void print(String message, boolean isNotNewLine) {
		if(isNotNewLine) {
			System.out.print(message);
		} else {
			System.out.println(message);
		}
		
	}
	
	public static void printLine(int number) {
		if(number != 0) {
			for(int i = 0;i < number;i++) {
				System.out.print("-");
			}
			System.out.println("");
		}
	}
	
	public static void printRow(int number) {
		for(int i = 0; i < number; i++) {
			System.out.println("");
		}
	}
	
}
