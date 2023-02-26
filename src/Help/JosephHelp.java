package Help;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class JosephHelp {

        public static void main(String[] args) {

            int[] theArray = {5, 7, 4, 3, 9, 6};

            for (int i = 0; i < theArray.length - 1; i++) {
                int min = i;

                for (int j = i + 1; j < theArray.length; j++) {
                    if (theArray[j] < theArray[min]) {
                        min = j;
                    }
                }
                int temp = theArray[i];
                theArray[i] = theArray[min];
                theArray[min] = temp;
            }
            System.out.println(Arrays.toString(theArray));
        }
}
