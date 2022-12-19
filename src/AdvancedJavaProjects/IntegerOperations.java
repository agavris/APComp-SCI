package AdvancedJavaProjects;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class IntegerOperations {

    static Scanner myScanner = new Scanner(System.in);

    public static void sumOfSquares() {
        ArrayList<Integer> factors = new ArrayList<>();
        ArrayList<Integer> primeFactors = new ArrayList<>();
        System.out.println("What number?: ");
        int number = myScanner.nextInt();
        int sum = 0;
        for (int i = number; i >= 0; i--) {
            sum += Math.pow(i, 2);
        }
        System.out.println("The sum of the squares of the first " + number + " positive integers is " + sum);
        System.out.println("The factors of " + sum + " are: ");
        for (int i = 1; i <= sum; i++) {
            if (sum % i == 0) {
                factors.add(i);
            }
        }
        System.out.println(factors);
        System.out.println("Amount of factors: " + factors.size());

        //prime factorization of number
        System.out.println("Prime factorization of " + sum + ": ");
        int n = sum;
        int i;
        for (i = 2; i <= sum; i++) {
            if (sum % i == 0) {
                sum /= i;
                i--;
                primeFactors.add(i + 1);
            }
        }
        primeFactors.forEach(num -> {
            if(!Objects.equals(num, primeFactors.get(primeFactors.size() - 1))) {
                System.out.print(num + " * ");
            } else {
                System.out.print(num);
            }
        });
    }



    public static void main(String[] args) {
        sumOfSquares();

    }
}