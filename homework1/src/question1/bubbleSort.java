package question1;

public class bubbleSort {
	public static void main(String[] args) {
		int a [] = {1,0,5,6,3,2,3,7,9,8,4};
		bubble(a);
		print(a);

	}
	
	public static void print(int a[]) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void bubble(int a[]) {
		int temp = 0;
		for(int i = 0; i < a.length; i++) {			// iteration for loop
			for(int j = 0; j < a.length - 1; j++) {   // keep track of index checked
				if(a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j+1];			// swap values if current num is greater then next number
					a[j+1] = temp;
				}
			}
		}
	}
}
