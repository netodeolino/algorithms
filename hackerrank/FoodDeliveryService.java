
class FoodDeliveryService {

    public static int solve(int n, int x) {
        // Write your code here
        int i = 1, t = 1;
        
        while (i <= n) {
            if (i == x || i == reverse(x)) {
                return t;
            }
            
            if (i*2 <= x) {
                i = i*2;
            } else {
                i++;
            }
            
            t++;
        }
        
        return t;
    }
    
    public static int reverse(int n) {
        int num = n, reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(solve(765, 587)); // has to be 13
        System.out.println(solve(907, 132)); // has to be 8
        System.out.println(solve(277, 163)); // has to be 8
        System.out.println(solve(956, 625)); // has to be 12
        System.out.println(solve(17, 16)); // has to be 4
    }
}