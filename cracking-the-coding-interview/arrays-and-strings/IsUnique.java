// Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

class IsUnique {

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

	public static void main(String[] args) {
		String testTrue = "abcdefghijlmno";
		String testFalse = "abcdefghijlmnod";

		System.out.println(isUnique(testTrue));
		System.out.println(isUnique(testFalse));
	}

}