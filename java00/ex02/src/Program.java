//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Scanner;
public class Program {
    int calculateSumDigits(int num) {
        int sum = 0;
        while(num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
    boolean checkPrime(int num) {
        boolean prime = true;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
    public static void main(String[] args) {
        Program m = new Program();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), counter = 0;
        while(num != 42) {
            int sum = m.calculateSumDigits(num);
            if (m.checkPrime(sum)) counter++;
            num = sc.nextInt();
        }
        System.out.println("Count of coffee-request : " + counter);
    }
}