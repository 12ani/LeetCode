import java.util.HashSet;

public class CountKDistinctSubstrings {

	public static void main(String[] args) {
		String inputString = "abcabc";
		int num = 1;
		
		HashSet<Character> h = new HashSet<>();
		int count = 0;
		
		for (int i = 0; i < inputString.length(); i++) {
			h = new HashSet<>();
			for (int j = i; j < inputString.length(); j++) {
				h.add(inputString.charAt(j));
				if (h.size() == num)
					count++;
			}
		}
		
		System.out.println(count);
	}

}