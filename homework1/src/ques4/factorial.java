package ques4;

public class factorial {
	public static void main(String[] args) {
		System.out.println(fact(4));

	}

	public static int fact(int n) {
		if ( n == 0) {				// base case for recursion
			return 1;
		} else
			return n * fact(n-1);  // 4*3*2*1
	}
}
