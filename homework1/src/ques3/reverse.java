package ques3;

public class reverse {
	public static void main(String[] args) {
		String str = "cat";

	    int length = str.length();
	    for (int i = str.length()-1; i >= 0; --i) // want to start cutting of string from reverse
	        str += str.charAt(i);  // add str to reverse of string o get cattac
	    str = str.substring(length); // substring cuts off cat leaving us with tac
	    System.out.println(str);
		}
	}

