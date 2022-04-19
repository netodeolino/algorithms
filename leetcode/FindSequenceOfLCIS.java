class FindSequenceOfLCIS {

    public static int findSequenceOfLCIS(int array[]) {
        int sequence = 1, temp = 1;

        for (int i = 1; i < array.length; i++) {
            int run;
            if (array[i] > array[i-1]) {
                temp += 1;
                run = temp;
            } else {
                temp = 1;
                run = temp;
            }

            sequence = Math.max(sequence, run);
        }

        return sequence;
    }

    public static void main(String[] args) {
        int array[] = {1, 3, 5, 4, 7, 8, 9, 10, 11};
        System.out.println(findSequenceOfLCIS(array));
    }

}
