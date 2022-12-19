package Week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordGame {
    public static ArrayList<Character> generateLetters() {
        ArrayList<Character> letters = new ArrayList<Character>();
        for (int i = 0; i < 7; i++) {
            letters.add((char) (Math.random() * 26 + 'a'));
        }
        return letters;
    }
    public static ArrayList<String> prepareWordList(String filename) {
        ArrayList<String> wordList = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File("src/" + filename));
            while (scan.hasNextLine()) {
                String word = scan.nextLine();
                if (word.length() >= 4 && word.length() <= 7) {
                    wordList.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return wordList;
    }
    public static ArrayList<String> generateWordList(ArrayList<Character> letters, ArrayList<String> wordList, Character centerLetter) {
        ArrayList<String> generatedWordList = new ArrayList<>();
        for (String word : wordList) {
            boolean valid = true;
            for (int i = 0; i < word.length(); i++) {
                if (!letters.contains(word.charAt(i))) {
                    valid = false;
                    break;
                }
            }
            if (valid && word.contains(centerLetter.toString())) {
                generatedWordList.add(word);
            }
        }
        return generatedWordList;
    }
    public static void main(String[] args) {
        ArrayList<String> wordList = prepareWordList("words.txt");
        ArrayList<Character> letters = generateLetters();
        Character centerLetter = letters.get((int) (Math.random() * letters.size()));
        ArrayList<String> validWords = generateWordList(letters, wordList, centerLetter);
        ArrayList<String> userWords = new ArrayList<>();

        System.out.println("CompSci Spelling Bee, here are your letters! ");
        System.out.println(letters);
        System.out.println("Your words must contain: " + centerLetter);
        Scanner scan = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.print("Enter a word: ");
            String word = scan.nextLine();
            if (word.equals("quit")) {
                break;
            }
            if (validWords.contains(word)) {
                if (!userWords.contains(word)) {
                    if(word.length() > 4) {
                        count += word.length();
                    } else {
                        count += 1;
                    }
                    userWords.add(word);
                } else {
                    System.out.println("You already entered that word!");
                }
            } else {
                System.out.println("That word is not valid!");
            }
        }
        System.out.println("You entered " + userWords.size() + " words!");
        System.out.println("Here are the words you entered: ");
        System.out.println(userWords);
        System.out.println("Your score is: " + count);

        System.out.println("Here are the words you missed: ");
        for (String word : validWords) {
            if (!userWords.contains(word)) {
                System.out.print(word + " ");
            }
        }
    }
}