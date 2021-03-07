/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Example: 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */

import java.util.Arrays;

class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int aux = nums[i];
                nums[i] = nums[lastNonZero];
                nums[lastNonZero] = aux;
                
                lastNonZero++;
            }
        }
    }

    public static void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,1,0,3,12};
        int[] nums2 = new int[]{1,3,0,3,0};

        moveZeroes(nums1);
        moveZeroes(nums2);

        print(nums1);
        print(nums2);
    }

}