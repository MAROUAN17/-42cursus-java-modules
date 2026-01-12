import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Program {
    static void sortArray(int[] count, char[] characters) {
        int tmpInt = 0;
        char tmpChar;

        for(int i = 0; i < count.length; i++) {
            for(int j = i + 1; j < count.length; j++) {
                if (count[j] > count[i] || (count[i] == count[j] && characters[j] < characters[i])) {
                    tmpInt = count[j];
                    count[j] = count[i];
                    count[i] = tmpInt;

                    tmpChar = characters[j];
                    characters[j] = characters[i];
                    characters[i] = tmpChar;
                }
            }
        }
    }

    static void displayHistogram(int[] count, char[] characters, int max) {
        for(int i = 0; i < 10; i++) {
            if (count[i] != 0) {
                System.out.print(characters[i] + " ");
                int nbrIter = (count[i] * 10) / max;
                for(int j = 0; j < nbrIter; j++)
                    System.out.print("#");
                System.out.println(" " + count[i]);
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] strArr = str.toCharArray();
        int[] count = new int[26];
        int max = 0;
        char[] characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for(int i = 0; i < strArr.length; i++) {
            if (strArr[i] >= 'a' && strArr[i] <= 'z') {
                count[(int) (strArr[i] - 'a')] += 1;
                if ((int) (strArr[i] - 'a') > max) max = (int) (strArr[i] - 'a');
            }
            else if (strArr[i] >= 'A' && strArr[i] <= 'Z') {
                count[(int) (strArr[i] - 'A')] += 1;
                if ((int) (strArr[i] - 'A') > max) max = (int) (strArr[i] - 'A');
            }
        }

        sortArray(count, characters);
        displayHistogram(count, characters, max);
    }
}