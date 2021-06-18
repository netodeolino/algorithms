class LongestCommonPrefix {

    public static String slowLongestCommonPrefix(String[] strs) {
        char[] aux = strs[0].toCharArray();
        
        for (int i = 1; i < strs.length; i++) {
            String temp = "";
            char[] word = strs[i].toCharArray();
            for (int j = 0; j < word.length && j < aux.length; j++) {
                if (word[j] != aux[j]) {
                    break;
                } else {
                    temp = temp + word[j];
                }
            }
            
            aux = temp.toCharArray();
        }
        
        return String.valueOf(aux);
    }

    public static String fastLongestCommonPrefix(String[] strs) {
        String word = strs[0];
        
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(word) != 0) {
                word = word.substring(0, word.length() - 1);
            }
        }
        
        return word;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        slowLongestCommonPrefix(strs);
        fastLongestCommonPrefix(strs);
    }
}
