package challenge1;

import java.util.ArrayList;

public class geneMutations {
	public static void main(String[] args) {
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String bank[] = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		ArrayList<String> a = new ArrayList<>();
		a.add(start);
		a.add(end);
		System.out.println(mutations(start,end, bank));
	}

	public static int mutations(String start, String end, String bank[]) {
		int count = 0;
		for(int i = 0; i < start.length(); i++) {
			ArrayList<String> temp = new ArrayList<>();
			if(temp.equals(end)) return count;

			if(start.equals(end)) {
				return 0;
			} 
			else if(start.charAt(i) != end.charAt(i)) {
				count++;
				return count;
			}
		}
		return count;
	}
}
