import java.util.Scanner;

public class Program {
    public static int getIndexDay(String day, String[] days) {
        for(int i = 0; i < days.length; i++) {
            if (day.equals(days[i]))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] students = new String[10];
        String[] sessions = new String[10];
        String[] days = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
        int[] attendance = new int[10];
        int i = 0, currentDay = 2;
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        while (!line.equals(".")) {
            students[i++] = line;
            line = sc.nextLine();
        }

        line = sc.nextLine();

        i = 0;
        while(!line.equals(".")) {
            sessions[i++] = line;
            line = sc.nextLine();
        }

//        while(currentDay <= 30) {
//            currentDay += getIndexDay("MO", days);
//        }
    }
}