package Week3;

import java.util.Scanner;

public class webassign {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int counter = 0;
        int correct = 0;
        while(counter < 10) {
            int firstNum = (int) (Math.random() * 10) + 10;
            int secondNum = (int) (Math.random() * 10) + 10;
            System.out.println("What is " + firstNum + " * " + secondNum + "?: ");
            int answer = myScanner.nextInt();
            if (answer == firstNum * secondNum) {
                System.out.println("Correct");
                correct++;
            } else {
                System.out.println("Incorrect");
            }
            counter++;
        }
        System.out.println("You have completed the quiz, you have got " + correct + " correct");
    }
}