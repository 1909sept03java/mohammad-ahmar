package ques21;

public class noRepeat {
	public static void main(String[] args) {
		String str = "penny";
		remove(str);
	}
	
	public static void remove(String s){
	    String result = "";
	    for (int i = 0; i < s.length(); i++) {
	        if(!result.contains(String.valueOf(s.charAt(i)))) {
	            result += String.valueOf(s.charAt(i));
	        }
	    }
	    System.out.println(result);
	}
}
