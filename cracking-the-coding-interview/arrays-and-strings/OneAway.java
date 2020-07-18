// There are three types of edits that can be performed on strings: insert a character,
// remove a character, or replace a character. Given two strings, write a function to check if they are
// one edit (or zero edits) away.

class OneAway {

	public static boolean oneEdit(String str1, String str2) {
		int cont = 0;
		for (int i = 0; i < str2.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				cont++;
			}
		}
		return (cont > 1) ? false : true;
	}

	public static boolean oneInsert(String str1, String str2) {
		int i1 = 0;
		int i2 = 0;
		while (i2 < str2.length() && i1 < str1.length()) {
			if (str1.charAt(i1) != str2.charAt(i2)) {
				if (i1 != i2) {
					return false;
				}
				i2++;
			} else {
				i1++;
				i2++;
			}
		}
		return true;
	}
	
	public static boolean isOneEdit(String str1, String str2) {
		if (str1.equals(str2)) {
			return true;
		}

		if ((str1.length() - str2.length() > 1) || (str2.length() - str1.length() > 1)) {
			return false;
		}

		if (str1.length() == str2.length()) {
			return oneEdit(str1, str2);
		}

		if (str1.length() + 1 == str2.length()) {
			return oneInsert(str1, str2);
		}

		return oneInsert(str2, str1);
	}

	public static void main(String[] args) {
		System.out.println(isOneEdit("pale", "ple"));
		System.out.println(isOneEdit("pales", "pale"));
		System.out.println(isOneEdit("pale", "bale"));
		System.out.println(isOneEdit("pale", "bake"));
	}
}