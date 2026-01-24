import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        UsersArrayList userList = new UsersArrayList();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Choose : ");
            System.out.println("1. Add a USER: ");
            System.out.println("2. Get a USER by ID: ");
            System.out.println("3. Get a USER by INDEX: ");
            System.out.println("0. EXIT");

            int choosedNbr = sc.nextInt();

            if (choosedNbr == 0)
                System.exit(0);
            if (choosedNbr == 1) {
                System.out.print("Type the USER name: ");
                String userName = sc.next();
                User usr = new User(userName);
                userList.addUser(usr);
            }
            if (choosedNbr == 2) {
                try {
                    System.out.print("Type the USER ID: ");
                    Integer id = sc.nextInt();
                    System.out.println("USER -> " + userList.getUserByID(id).getName());
                } catch (UserNotFoundException e) {
                    System.err.println(e.toString());
                }
            }
            if (choosedNbr == 3) {
                System.out.print("Type the USER INDEX: ");
                Integer index = sc.nextInt();
                System.out.println("USER -> " + userList.getUserByIndex(index).getName());
            }
        }
    }
}