//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> total = new ArrayList<Integer>();;
        int weekNbr = 1, sum = 0, grade = 0, cols = 5;
        String week;
        while(weekNbr <= 18) {
            week = sc.nextLine();
            char weekNbrChar = week.charAt(week.length() - 1);
            if (!week.equals("Week " + weekNbr) || weekNbrChar - '0' != weekNbr) {
                if (!week.equals("42")) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                break;
            }
            grade = 0; cols = 5; sum = 0;
            while (cols-- > 0) {
                grade = sc.nextInt();
                if (grade > 9 || grade < 0) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                sum += grade;
            }
            total.add(sum);
            sc.nextLine();
            weekNbr++;
        }
        int weekIter = 1;
        for(int progress : total) {
            int nbr = progress / 5;
            System.out.print("Week " + weekIter++ + " ");
            while(nbr-- > 0)
                System.out.print("=");
            System.out.println(">");
        }
    }
}