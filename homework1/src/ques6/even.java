package ques6;

public class even {
	public static void main(String[] args) {
		System.out.println(isEven(4)); 
	}

	public static boolean isEven(int n) {
		if((n/2)*2 == n) {        //every even number is divisble by 2.
			return true;
		}
		return false;
	}

}
