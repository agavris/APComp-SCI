package SortingSearching;

import java.util.*;

public class Sorting {
    public static int[] generate_nums(int length) {
        int[] nums = new int[length];
        for(int i = 0; i < length; i++) {
            nums[i] = (int) (Math.random() * 89 + 10);
        }
        return nums;
    }
    public static void main(String[] args) {
        int length = 10;
        int[] nums = generate_nums(length);
        for(int i : nums) {
            System.out.print(i + "|" );
        }
        for(int i = 0; i < length; i++) {
            int rdx = (int) (Math.random() * length);
            int idx = (int) (Math.random() * length);
            if(rdx == idx) continue;

            int temp = nums[rdx];
            nums[rdx] = nums[idx];
            nums[idx] = temp;
        }

        for(int i : nums) {
            System.out.print(i + " ");
        }


    }
}
