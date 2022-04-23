class LongestSubStringWithoutRepeatChars {

    public static int longestSubStringWithoutRepeatChars(String str) {
        if (str == null || str.length() == 0) return 0;

        String sub = "";
        int max = 0;

        for (char c : str.toCharArray()) {
            String curr = String.valueOf(c);

            if (sub.contains(curr)) {
                sub = sub.substring(sub.indexOf(curr) + 1);
            }

            sub += curr;
            max = Math.max(sub.length(), max);
        }

        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcdefghijlmno";
        System.out.println(longestSubStringWithoutRepeatChars(str));
    }

}

//abcabcdbc