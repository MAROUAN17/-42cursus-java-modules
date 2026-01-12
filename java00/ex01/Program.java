//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Scanner;
public class Program {
    void checkPrime(int num) {
        int steps = 0;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            steps++;
            if (num % i == 0) {
                System.out.println("false " + steps);
                return ;
            }
        }
        steps++;
        System.out.println("true " + steps);
    }
    public static void main(String[] args) {
        Program m = new Program();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), counter = 0;
        while(true) {
            if (num <= 0 || num == 1) {
                System.out.println("IllegalArgument");
                System.exit(-1);
            }
            m.checkPrime(num);
            num = sc.nextInt();
        }
    }
}