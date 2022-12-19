package Week1;

import java.util.Objects;
import java.util.Scanner;


public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your full name ex. John Doe: ");
        String fullName = sc.nextLine();

        String[] fullNameArray = fullName.split(" ");

        System.out.println("Confirm your first name is [y/n]: " + fullNameArray[0]);
        String firstNameRes = sc.nextLine();

        if (Objects.equals(firstNameRes, "n")) {
            System.out.println("Please enter your first name: ");
            String firstName = sc.nextLine();
            fullNameArray[0] = firstName;
        } else {
            System.out.println("First name confirmed");
        }

        System.out.println("Confirm your last name is [y/n]: " + fullNameArray[1]);
        String lastNameRes = sc.nextLine();
        if (Objects.equals(lastNameRes, "n")) {
            System.out.println("Please enter your last name: ");
            String lastName = sc.nextLine();
            fullNameArray[1] = lastName;
        } else {
            System.out.println("Last name confirmed");
        }

        System.out.println("What is your Math SAT Range? ex. 800-900: ");
        String mathSAT = sc.nextLine();
        String[] mathSATArray = mathSAT.split("-");

        System.out.println("What is your English SAT Range? ex. 800-900: ");
        String englishSAT = sc.nextLine();
        String[] englishSATArray = englishSAT.split("-");

        System.out.println("What is your ACT Range? ex. 27-33: ");
        String act = sc.nextLine();
        String[] actArray = act.split("-");

        System.out.println("What is your GPA Range? ex. 3.0-4.0: ");
        String gpa = sc.nextLine();
        String[] gpaArray = gpa.split("-");
        System.out.println(gpaArray[0] + " " + gpaArray[1]);

        //test if the student has good scores
        boolean mathGood = Integer.parseInt(mathSATArray[0]) >= 800 && Integer.parseInt(mathSATArray[1]) <= 900;
        boolean englishGood = Integer.parseInt(englishSATArray[0]) >= 800 && Integer.parseInt(englishSATArray[1]) <= 900;
        boolean actGood = Integer.parseInt(actArray[0]) >= 27 && Integer.parseInt(actArray[1]) <= 33;
        boolean gpaGood = Double.parseDouble(gpaArray[0]) >= 3.0 && Double.parseDouble(gpaArray[1]) <= 4.0;
        boolean good = mathGood && englishGood && actGood && gpaGood;

        if (good) {
            System.out.println(fullNameArray[0] + ", you are very academically inclined and you are ready for a possible chance at an IVY League!");
        } else {
            System.out.println(fullNameArray[0] + ", you are not very academically inclined and you are not ready for a possible chance at an IVY League!");
        }





    }
}