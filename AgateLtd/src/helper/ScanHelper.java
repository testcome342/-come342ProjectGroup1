package helper;

import java.util.Scanner;

public class ScanHelper {
	
	//Arda Batuhan Demir
	//30.04.2018
	
	/*
	 * ScanHelper
	 * -> scanInt = int scanner
	 * -> scanString = String scanner
	 * -> scanDouble = double scanner
	 * */
	

	private static Scanner scanner;

	public static int scanInt() {
		scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	public static String scanString() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public static Double scanDouble() {
		scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}
}
