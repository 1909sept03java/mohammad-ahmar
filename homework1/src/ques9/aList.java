package ques9;

import java.util.ArrayList;
import java.util.Iterator;

public class aList {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		int n = 1;
		while(n != 100) {				// while loop to populate arraylist 1-100
			a.add(n); 
			n++;
		}
		for (int i = 0; i<a.size()-1; i++){
	        if (!isPrime(a.get(i))){			// removes non-prime numbs
	            a.remove(a.get(i));
	            }
	        }
	        System.out.println(a);
	}
	 public static boolean isPrime(int x){
	        boolean check = true;				// checks for prime numbers
	        for (int i = 2; i < x; i++){
	            if(x%i == 0){
	                check = false;  
	            }
	        }
	        return check;
	    }
}
