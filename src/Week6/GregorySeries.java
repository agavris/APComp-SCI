package Week6;

import java.util.Scanner;

public class GregorySeries {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = myScanner.nextInt();

        double sum = 0;
        for (int i = 1; i < number; i++) {
            if (i % 2 == 0) {
                sum -= 4.0 / (2 * i - 1);
            } else {
                sum += 4.0 / (2 * i - 1);
            }
        }
        System.out.println(sum);
    }
}

