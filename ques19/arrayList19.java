package ques19;

import java.util.ArrayList;
import java.util.Iterator;

public class arrayList19 {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		int n = 1;
		while(n != 11) {
			a.add(n);
			n++;
		}
		System.out.println("Original list: " + a); 
		evenList(a);
		oddList(a);
	}

	public static void evenList(ArrayList<Integer> a) {
		// removes odd numbers
		int even = 0;
		for(Iterator<Integer> Iterator = a.iterator(); Iterator.hasNext();) {
			Integer number = Iterator.next();
			if( (number % 2 == 0) ) {
				Iterator.remove();
				even += number;      // adds all even numbers left
			}
		}
		System.out.println("total for even list: " + even);
	}

	public static void oddList(ArrayList<Integer> a) {
		// removes even numbers
		int odd = 0;
		for(Iterator<Integer> Iterator = a.iterator(); Iterator.hasNext();) {
			Integer number = Iterator.next();
			if( (number % 2 != 0) ) {
				Iterator.remove();
				odd += number;                // adds all odd numbers left
			}
		}
		System.out.println("total for odd list: " + odd);
	}


}

