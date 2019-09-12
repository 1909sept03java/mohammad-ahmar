package ques16;

public class commandLine {
	public static void main(String[] args) { 

		System.out.println("The command line"+ " arguments are:"); 

		// iterating the args array and printing 
		for (String x:args) 
			System.out.println(x);				//tested on cmd line
		System.out.println("No command line "+ "arguments found."); 
	}
} 


