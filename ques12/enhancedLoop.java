package ques12;

public class enhancedLoop {
	public static void main(String[] args) {
		int a [] = new int [101];
		for(int i = 1; i < a.length; i++) {
			a[i] = i;
			//System.out.println(a[i]);		populate arry 1-100
		}
		for(int x : a) {
			if(x % 2 == 0) {				// enhanced for loop even nums
				System.out.println(x);
			}
		}
	}
}
