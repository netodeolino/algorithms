class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        
        while (start < end) {
            int endTemp = end - start;
            
            int smaller = height[start];
            
            if (height[start] < height[end]) {
                smaller = height[start];
                start++;
            } else {
                smaller = height[end];
                end--;
            }
            
            int tempMax = smaller * endTemp;
            
            if (tempMax > max) max = tempMax;
        }
        
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};

        ContainerWithMostWater cWithMostWater = new ContainerWithMostWater();

        System.out.println(cWithMostWater.maxArea(height));
    }
}
