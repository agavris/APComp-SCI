package Testing;

import java.util.Arrays;

public class SortingQuiz {

    //returns true if the smallest int in the array is already in position 0
    public static boolean isSmallestFirst(int[] n) {
        int smallest = n[0];
        for (int i = 1; i < n.length; i++) {
            if (n[i] < smallest) {
                smallest = n[i];
            }
        }
        return smallest == n[0];
    }
    public static void sortX(int[] data) {
        for(int k = 0; k < data.length; k++) {
            for(int p = 0; p < data.length - 1; p++) {
                if(data[p] < data[p + 1]) {
                    int temp = data[p];
                    data[p] = data[p + 1];
                    data[p + 1] = temp;
                    System.out.println(Arrays.toString(data));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] unsorted = {3,5,6,1,23,4,2,1,5};
        sortX(unsorted);

        System.out.println("Hello World!");
    }
}
