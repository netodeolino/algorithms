class MaxProductValue {
    
    public static int maxProductValue(int array[]) {
        int maxOne = (int) Double.NEGATIVE_INFINITY,
            maxTwo = (int) Double.NEGATIVE_INFINITY;

        int minOne = (int) Double.POSITIVE_INFINITY,
            minTwo = (int) Double.POSITIVE_INFINITY;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxOne) {
                maxTwo = maxOne;
                maxOne = array[i];
            } else if (array[i] > maxTwo) {
                maxTwo = array[i];
            }

            if (array[i] < minOne) {
                minTwo = minOne;
                minOne = array[i];
            } else if (array[i] < minTwo) {
                minTwo = array[i];
            }
        }

        return Math.max(maxOne * maxTwo, minOne * minTwo);
    }

    public static void print(int num) {
        System.out.println(num);
    }

    public static void main(String[] args) {
        int[] array = new int[]{ -10, -9, 1, 6, 3, 12 };
        print(maxProductValue(array));
    }

}
