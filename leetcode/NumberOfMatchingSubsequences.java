class NumberOfMatchingSubsequences {

    public static int numMatchingSubseq(String s, String[] words) {
        int cont = 0;
        
        for (String w : words) {
            if (contains(s, w)) cont++;
        }
        
        return cont;
    }
    
    public static boolean contains(String s, String word) {
        int previus = 0;
        
        for (char c : word.toCharArray()) {
            int index = s.indexOf(c, previus);
            
            if (index == -1) return false;
            
            previus = index + 1;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};

        System.out.println(numMatchingSubseq(s, words)); // 3
    }
}
