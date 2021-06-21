import java.util.Stack;

class LongestValidParentheses {
    
    public static int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> chars = new Stack<>();
        
        chars.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') chars.push(i);
            
            if (c == ')') chars.pop();
            
            if (chars.isEmpty()) chars.push(i);
            
            if (!chars.isEmpty()) max = Math.max(max, i - chars.peek());
        }
        
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()")); // 2
        System.out.println(longestValidParentheses(")()())")); // 4
        System.out.println(longestValidParentheses("())((())")); // 4
    }
}
