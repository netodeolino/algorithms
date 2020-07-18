// Given two strings, write a method to decide if one is a permutation of the other.

import java.util.*;

class CheckPermutation {

	public static Boolean checkPermutation(String one, String two) {
		if (one.length() != two.length()) return false;

		char[] oneCHars = one.toCharArray();
		char[] twoCHars = two.toCharArray();

		Arrays.sort(oneCHars);
		Arrays.sort(twoCHars);

		for (int i = 0; i < oneCHars.length; i++) {
			if (oneCHars[i] != twoCHars[i]) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(checkPermutation("abc", "bac"));
		System.out.println(checkPermutation("abd", "bac"));
	}
}