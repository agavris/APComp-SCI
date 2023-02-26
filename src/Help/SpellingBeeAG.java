package Help;

import java.util.ArrayList;
import java.util.Scanner;

public class SpellingBeeAG {

    public static ArrayList<String> generate_list_of_letters(int len) {
        ArrayList<String> letters = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < len; i++) {
            int random = (int) (Math.random() * 26);
            letters.add(alphabet.substring(random, random + 1));
        }
        return letters;
    }

    public static boolean validate_word(String word, ArrayList<String> words, String center_letter, ArrayList<String> letters) {
        if(words.contains(word)) {
            System.out.println("Duplicate Word!");
            return false;
        }

        if(word.length() < 4 || word.length() > 7) {
            System.out.println("Word must contain 4 to 7 letters.");
            return false;
        }

        if(!word.contains(center_letter)) {
            System.out.println("You forgot to include your center letter.");
            return false;
        }

        for(int i = 0; i < word.length(); i++) {
            if(!letters.contains(String.valueOf(word.charAt(i)))) {
                System.out.println("Your has at least 1 letter than is not in your list of letters!");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] inputs) {

        Scanner kboard = new Scanner(System.in);

        ArrayList<String> letters = generate_list_of_letters(7);
        String center_letter = letters.get(0);

        System.out.println("Hi! Wellcome to the Spelling Bee game! Attempt to create as many words as possible (over 4 letters long) with the list of letters below. Each word you come up with must include the center letter.");
        System.out.println("The first letter of each set will be considered the \"center\" letter");
        System.out.println("When you are done coming up with words enter \"0\"");
        System.out.println("The letters you will be working with are...");
        letters.forEach(letter -> System.out.print(letter + " "));

        ArrayList<String> theirwords = new ArrayList<>();

       while (true) {
           System.out.println("Enter a word: ");
           String word = kboard.nextLine();

           if(word.equals("0")) break;

           if(validate_word(word, theirwords, center_letter, letters)) {
               theirwords.add(word);
           }
       }
       int points = 0;
        for (String theirword : theirwords) {
            if (theirword.length() == 4) {
                points += 1;
            } else {
                points += theirword.length();
            }
        }
        System.out.print("Your words were: ");
        theirwords.forEach(letter -> System.out.println(letter + " "));
        System.out.println("You scored " + points + "!");
    }
}

