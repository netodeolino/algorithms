class MinLengthXElement {
    
    public static int minLengthXElement(int array[], int x) {
        int minLength = (int) Float.POSITIVE_INFINITY;
        int start = 0, end = 0, sum = 0;

        while (end < array.length) {
            sum = sum + array[end];
            end++;

            while (start < end && sum >= x) {
                sum = sum - array[start];
                start++;

                int length = end-start+1;
                if (length < minLength) minLength = length;
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        int x = 7;
        int array[] = {1, 2, 3, 4, 5, 6};

        System.out.println(minLengthXElement(array, x));
    }
}
