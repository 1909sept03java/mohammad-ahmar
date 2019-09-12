package ques2;

public class fibo {
	public static void main(String[] args) {
		fiboNumbers(25);
	}

	public static void fiboNumbers(int n) {
		int first = 0;           // first 2 numbrs alwyas gona be 0 and 1
		int second = 1;
		int sum;					// add the first two then move the second number to first and sum to second and continue
		for(int i = 0; i < n; i++) {
			sum = first + second;
			first = second;					//swaps and then finds next two numbers 
			second = sum;					
			System.out.print(first + " ");
		}
	}

}
