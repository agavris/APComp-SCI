package Week6;

import java.util.ArrayList;
import java.util.Scanner;

public class ClothingCashRegister {
    public static void maze(int n, int w) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (i % 2 == 0) {
                    System.out.print("*");
                } else {
                    if (j == 0 || j == w - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }



    public static ArrayList<Integer> promptUserForPrice() {
        Scanner myScanner = new Scanner(System.in);
        ArrayList<Integer> items = new ArrayList<>();

        while (true) {
            System.out.println("Enter the price of your item: ");
            int number = myScanner.nextInt();
            if (number == 0) {
                break;
            }

            items.add(number);
        }
        return items;
    }

    public static void main(String[] args) {
        maze(4, 4);
        ArrayList<Integer> total = promptUserForPrice();
        int sum = 0;
        for (Integer integer : total) {
            if (integer > 175) {
                sum += (integer - 175) * 0.0625;
            }
            sum += integer;
        }
        System.out.println("Your total is: " + sum);
        maze(4, 4);
    }

}