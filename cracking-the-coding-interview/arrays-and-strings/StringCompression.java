// Implement a method to perform basic string compression using the counts
// of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
// "compressed" string would not become smaller than the original string, your method should return
// the original string. You can assume the string has only uppercase and lowercase letters (a - z).

class StringCompression {

	public static String stringCompression(String str) {
		int cont = 0;
		StringBuilder strAux = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			cont++;

			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				strAux.append(str.charAt(i));
				strAux.append(cont);
				cont = 0;
			}
		}

		return strAux.length() > str.length() ? str : strAux.toString();
	}

	public static void main(String[] args) {
		System.out.println(stringCompression("aabcccccaaa"));
		System.out.println(stringCompression("abbccdd"));
	}
}