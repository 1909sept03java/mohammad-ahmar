package ques24;

import java.util.Scanner;

public class decHex {

	public static void main(String args[]) {
		Scanner scanner = new Scanner( System.in );
		System.out.print("Enter a decimal number: ");
		int number = scanner.nextInt();
		int remainder;
		String result=""; 
		// Digits in hexadecimal number system
		char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

		while(number > 0) {
			remainder=number % 16; 
			result= hex[remainder] + result; 
			number= number / 16;
		}
		System.out.println("Decimal to hex: "+ result);
	}

}
