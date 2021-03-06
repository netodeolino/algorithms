import java.util.HashMap;
import java.util.Map;

// Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

class IsUnique {

	// slow
	public static Boolean isUnique(String A) {
		for (int i = 0; i < A.length(); i++) {
			for (int j = i+1; j < A.length(); j++) {
				if (A.charAt(i) == A.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	// fast
	public static Boolean isUnique2(String A) {
		Map<Character, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < A.length(); i++) {
			if (hashMap.containsKey(A.charAt(i))) {
				return false;
			} else {
				hashMap.put(A.charAt(i), 1);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String testTrue = "abcdefghijlmno";
		String testFalse = "abcdefghijlmnod";

		System.out.println(isUnique2(testTrue));
		System.out.println(isUnique2(testFalse));
	}

}