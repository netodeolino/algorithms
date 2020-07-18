class StringRotation {

	// Implement this method!
	private static boolean isSubstring(String string, String s2) {
		return true;
	}

	public static boolean isRotation(String s1, String s2) {
		int len = s1.length();

		if (len == s2.length() && len > 0) {
			return isSubstring((s1 + s1), s2);
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "erbottlewat"));
	}
}