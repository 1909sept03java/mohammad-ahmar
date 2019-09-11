package ques17;

import java.util.Scanner;

public class interest {
	public static void main(String[] args) {
		System.out.println("Enter principal: ");
		Scanner scanner = new Scanner(System.in);
		double prince = scanner.nextDouble();
		System.out.println("Enter rate: ");
		double rate = scanner.nextDouble();
		System.out.println("Enter time: ");
		double time = scanner.nextDouble();
		double intrest = prince * rate * time;
		System.out.println("total intrest: " + intrest);
		
	}
}
