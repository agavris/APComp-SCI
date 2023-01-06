package SortingSearching;

import java.util.Stack;

public class Algorithms {

    public static void swap(int[] n, int j, int i) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
    public static int parition_recursive(int[] n, int high, int low) {
        int pivot = n[high];
        int i = low - 1;
        for(int j = low; j <= high - 1; j++) {
            if(n[j] < pivot) {
                i++;
                swap(n, j, i);
            }
        }
        swap(n, i + 1, high);
        return (i + 1);
    }

    public static void quickSort_recursive(int[] n, int low, int high) {
        if(low < high) {
            int pivot = parition_recursive(n, high, low);
            quickSort_recursive(n, low, pivot - 1);
            quickSort_recursive(n, pivot + 1, high);
        }
    }


    public static int parition_iteration(int[] n, int low, int high) {
        int pivot = n[high];
        int i = low - 1 ;
        for(int j = low; j <= high - 1; j++) {
            if(n[j] <= pivot) {
                i++;
                swap(n, i, j);
            }
        }
        swap(n, i + 1, high);

        return i + 1;
    }

    public static void quickSort_iteration(int[] n, int low, int high) {
        int[] cache = new int[high - low + 1];
        int top = -1;
        cache[++top] = low;
        cache[++top] = high;

        while(top >= 0) {
            high = cache[top--];
            low = cache[top--];
            int p = parition_iteration(n, low, high);
            if(p - 1 > low) {
                cache[++top] = 1;
                cache[++top] = p - 1;
            }

            if(p + 1 < high) {
                cache[++top] = p + 1;
                cache[++top] = high;
            }
        }
    }

    public static void shellSort(int[] n) {
        int l = n.length;
        for(int gap = l/2; gap > 0; gap /= 2) {
            for(int i = gap; i < l; i++) {
                int temp = n[i];
                int j;
                for(j = i; j >= gap && n[j - gap] > temp; j -= gap) {
                    n[j] = n[j - gap];
                }
                n[j] = temp;
            }
        }
    }




    public static void main(String[] args) {
        int[] n = {6,5,3,4,6,3,1,2};
        quickSort_iteration(n, 0, n.length - 1);
        System.out.println("Sorted array (Iteration): ");
        for(int s : n) {
            System.out.println(s);
        }

        int[] n1 = {4, 6, 2, 1, 3, 6, 8, 0};
        quickSort_recursive(n1, 0, n1.length - 1);
        System.out.println("Sorted array (Recursion): ");
        for(int s : n1) {
            System.out.println(s);
        }
        int[] n2 = {2,4,1,6,5,9,7};
        shellSort(n2);
        System.out.println("Sorted array (ShellSort): ");
        for(int s : n2) {
            System.out.println(s);
        }
    }
}
