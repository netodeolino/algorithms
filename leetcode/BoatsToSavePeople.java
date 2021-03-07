/**
 * You are given an array people where people[i] is the weight of the ith person, and an infinite number of
 * boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time,
 * provided the sum of the weight of those people is at most limit.
 * 
 * Example:
 * Input: people = [3,5,3,4], limit = 5
 * Output: 4
 * Explanation: 4 boats (3), (3), (4), (5)
 */

import java.util.Arrays;

class BoatsToSavePeople {

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        
        int i = 0;
        
        for (int j = people.length-1; j >= i; j--) {
            if (people[j] + people[i] <= limit) {
                i++;
            }
            boats++;
        }
        
        return boats;
    }
    
    public static void main(String[] args) {
        int limit1 = 3;
        int[] peoples1 = new int[]{1,2};

        int limit2 = 3;
        int[] peoples2 = new int[]{3,2,2,1};

        int limit3 = 5;
        int[] peoples3 = new int[]{3,5,3,4};

        System.out.println(numRescueBoats(peoples1, limit1));
        System.out.println(numRescueBoats(peoples2, limit2));
        System.out.println(numRescueBoats(peoples3, limit3));
    }

}
