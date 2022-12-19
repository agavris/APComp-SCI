package AdvancedJavaProjects;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class PrimeFactors {


    public static void printPrimeNumbers(int n) {
        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                prime.add(i);
            }
        }
        prime.forEach(num -> {
            if (Objects.equals(num, prime.get(prime.size() - 1))) {
                System.out.print("and " + num + " ");
            } else if (Objects.equals(num, prime.get(prime.size() - 2))) {
                System.out.print(num + " ");
            } else {
                System.out.print(num + ", ");
            }
        });
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What number?: ");
        int number = myScanner.nextInt();
        printPrimeNumbers(number);
    }
}