class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        
        int end = firstNonValuePosition(nums, val);
        
        for (int i = 0; i < end; i++) {
            
            if (nums[i] == val) {
                int aux = nums[i];
                nums[i] = nums[end];
                nums[end] = aux;
            }
            
            end = firstNonValuePosition(nums, val);
        }
        
        return end+1;
    }
    
    private static int firstNonValuePosition(int[] nums, int val) {
        int endPosition = nums.length-1;
        
        while (endPosition >= 0 && nums[endPosition] == val) {
            endPosition -= 1;
        }
        
        return endPosition;
    }

    public static void main(String[] args) {
        int val = 2;
        int[] nums = new int[]{0,1,2,2,3,0,4,2};

        System.out.println(removeElement(nums, val));
    }
}
