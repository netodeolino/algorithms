class MaxSumKElements {

    public static int maxSumKElements(int array[], int k) {
        int max = 0;

        if (k > array.length) return max;

        int run = 0;
        while (run < k) {
            max += array[run];
            run++;
        }

        for (int i = 1; i < array.length-k+1; i++) {
            int arrayMax = (max - array[i-1]) + array[i+k-1];
            if (arrayMax > max) max = arrayMax;
        }

        return max;
    }
    
    public static void main(String[] args) {
        int k = 3;
        int array[] = {1, 2, 3, 4, 5, 6};

        System.out.println(maxSumKElements(array, k));
    }
}
