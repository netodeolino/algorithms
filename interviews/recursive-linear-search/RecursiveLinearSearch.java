class RecursiveLinearSearch {

    public static int search(int[] nums, int index, int value) {
        if (index >= nums.length) return -1;
        if (nums[index] == value) return index;
        return search(nums, index + 1, value);
    }

    public static void print(int num) {
        System.out.println(num);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 0, 1, 6, 3, 12 };
        print(search(nums, 0, 12));
    }
}