package Week8;

import java.util.Arrays;

public class QuizScores {
    public static double getAverage(int[] scores) {
        return Arrays.stream(scores).average().getAsDouble();
    }

    public static void displayScores(int[] scores) {
        Arrays.stream(scores).forEach(score -> {
            if (score == scores[scores.length -  1]) {
                System.out.print(score + " ");
            } else {
                System.out.print(score + ", ");
            }
        });
    }

    public static double averageWithoutLowest(int[] scores) {
        int lowest = Arrays.stream(scores).min().getAsInt();
        double sum = 0;
        for (int score : scores) {
            if (score != lowest) {
                sum += score;
            }
        }
        return sum / (scores.length - 1);
    }

    public static int[] removeLowestScore(int[] scores) {
        int lowest = Arrays.stream(scores).min().getAsInt();
        //make a new array
        int[] newScores = new int[scores.length - 1];
        int index = 0;
        for (int score : scores) {
            if (score != lowest) {
                newScores[index] = score;
                index++;
            }
        }
        return newScores;
    }


    public static void main(String[] args) {

        int[] scores = new int[8];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = (int) (Math.random() * 51 + 50);
        }
        System.out.printf("\nThe average is: %f", getAverage(scores));
        System.out.print("\nThe scores are: ");
        displayScores(scores);
        System.out.printf("\nThe average without the lowest score is: %f", averageWithoutLowest(scores));
        System.out.print("\nThe scores without the lowest score are: ");
        displayScores(removeLowestScore(scores));

    }
}