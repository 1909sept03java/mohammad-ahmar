package ques13;

import java.util.Scanner;

public class printNumbs {
	public static void main(String[] args) {
		triangle();
	}

	public static void triangle(){
		for (int i = 1; i <= 4; i++) {
			for (int x = 1; x <= i; x++){
				System.out.print("*");    
			}
			System.out.println("");
		}
	}
}
