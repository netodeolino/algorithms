import java.util.Arrays;

class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        
        if (index == -1 && target <= nums[0]) return 0;
        if (index < -1) return (index*-1)-1;
        
        return index;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    }
}