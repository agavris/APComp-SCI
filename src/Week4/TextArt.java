package Week4;

public class TextArt {
    public static void astrixRepeat(int num) {
        for (int i = num; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void repeatAmpersand(int num) {

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (i * 2) + 1; k++) {
                System.out.print("&");
            }
            System.out.println();
        }
    }

    public static void repeatWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(word.charAt(i));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        astrixRepeat(15);
        repeatAmpersand(15);
        repeatWord("octopus");
    }
}