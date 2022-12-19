package Week2;

import java.util.Scanner;

public class userinput {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int total = 0;

        while (true) {


            System.out.println("Enter a number: ");
            int number = myScanner.nextInt();
            if (number == 0) {
                System.out.println("The total is: " + total);
                break;
            }

            total += number;
        }

    }
}
