package Week2;

import java.util.Scanner;


public class HailstoneSequence {

    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter a number");
        int number = Integer.parseInt(String.valueOf(myScanner.nextInt()));

        int counter = 0;
        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
                System.out.print(number + " ");
            } else {
                number = (number * 3) + 1;
                System.out.print(number + " ");
            }
            counter++;
        }
    }
}