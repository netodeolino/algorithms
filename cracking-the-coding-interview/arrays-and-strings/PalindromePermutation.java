// Given a string, write a function to check if it is a permutation of a palin-
// drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
// is a rea rrangement of letters. The palindrome does not need to be limited to just dictionary words.

class PalindromePermutation {

	public static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);

		if (a <= val && val <= z) {
			return val - a;
		}

		return -1;
	}

	public static boolean isPermutationOfPalindrome(String phrase) {
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);

			if (x != -1) {
				table[x]++;
				if (table[x] % 2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}

	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome("tactcoapapa"));
		System.out.println(isPermutationOfPalindrome("tttactcoapapaa"));
	}
}