// Write a method to replace all spaces in a string with '%20: You may assume that the string"
// has sufficient space at the end to hold the additional characters, and that you are given the "true"
// length of the string. (Note: If implementing in Java, please use a character array so that you can
// perform this operation in place.)
// EXAMPLE
// Input: "Mr John Smith"
// Output: "Mr%20John%20Smith"

class URLify {

	public static String urlLify(String url) {
		int cont = 0;
		for (int c = 0; c < url.length(); c++) {
			if (url.charAt(c) == ' ') {
				cont++;
			}
		}

		char[] urlChars = new char[url.length() + ("%20".length() * cont) - cont];

		int i = 0;
		int b = 0;
		while (i < url.length()) {
			if (url.charAt(i) == ' ') {
				urlChars[b] = '%';
				urlChars[b+1] = '2';
				urlChars[b+2] = '0';
				b += 3;
			} else {
				urlChars[b] = url.charAt(i);
				b++;
			}

			i++;
		}

		return new String(urlChars);
	}

	public static void main(String[] args) {
		System.out.println(urlLify("Mr John Smith"));	
	}
}