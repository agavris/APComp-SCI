package Week2;

import java.util.Scanner;

public class nim2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int number = (int) (Math.random() * 20) + 10;
        int[] choices = {1, 2, 3};
        System.out.println("Welcome to Nim...");

        while (true) {

            if (number == 1) {
                System.out.println("You lost.");
                break;
            }

            System.out.printf("There are %d sticks on the table. How many would you like to remove? ", number);
            int userChoice = myScanner.nextInt();
            if (userChoice > 3 || userChoice < 1) {
                System.out.println("You can only take 1, 2 or 3 sticks");
                continue;
            }
            number -= userChoice;
            if (number == 1) {
                System.out.println("You won.");
                break;
            }
            if (number == 2 || number == 3 || number == 4) {
                System.out.println("Ive taken the 2nd to last stick, you have lost!");
                break;
            } else {
                int choice = choices[(int) (Math.random() * 3)];

                System.out.println("I choose " + choice + " sticks");
                number -= choice;
                System.out.println("There are " + number + " sticks left");
            }
        }
    }
}
