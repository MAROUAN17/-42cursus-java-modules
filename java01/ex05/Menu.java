import java.util.Scanner;
import java.util.UUID;

class Menu {
    private Scanner sc;
    private TransactionsService ts;
    private boolean devMode;

    Menu() {
        sc = new Scanner(System.in);
        ts = new TransactionsService();
        devMode = false;
    }

    public void launch(String mode) {
        while(true) {
            try {
                if (mode != null && mode.equals("--profile=dev"))
                    devMode = true;

                System.out.println("1. Add a user");
                System.out.println("2. View user balances");
                System.out.println("3. Perform a transfer");
                System.out.println("4. View all transactions for a specific user");
                if (devMode) {
                    System.out.println("5. DEV - remove a transfer by ID");
                    System.out.println("6. DEV - check transfer validity");
                }
                System.out.println("7. Finish execution");

                int selected = sc.nextInt();
                if (selected == 1) {
                    System.out.println("Enter a user name and a balance");
                    String name = sc.next();
                    int balance = sc.nextInt();
                    User usr = new User(name, balance);
                    ts.addUser(usr);
                    System.out.println("User with id = " + usr.getID() + " is added");
                }
                else if (selected == 2) {
                    System.out.println("Enter a user ID");
                    Integer id = sc.nextInt();
                    System.out.println(ts.getBalance(id));
                }
                else if (selected == 3) {
                    System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
                    Integer senderID = sc.nextInt();
                    Integer receipID = sc.nextInt();
                    Integer amount = sc.nextInt();
                    ts.transferTransaction(senderID, receipID, amount);
                    System.out.println("The transfer is completed");
                }
                else if (selected == 4) {
                    System.out.println("Enter a user ID");
                    Integer id = sc.nextInt();
                    Transaction[] trs = ts.getTransfers(id);
                    for(Transaction t : trs) {
                        System.out.println("TO " + t.getRecipient().getName() + "(id = " + t.getRecipient().getID() + ")" + " " + t.getAmount() + " with id = " + t.getID());
                    }
                }
                else if (devMode == true && selected == 5) {
                    System.out.println("Enter a user ID and a transfer ID");
                    int usrID = sc.nextInt();
                    UUID trID = UUID.fromString(sc.next());
                    Transaction t = ts.getTransaction(trID, usrID);
                    ts.removeTransaction(trID, usrID);
                    System.out.println("Transfer To "  + t.getRecipient().getName() + "(id = " + t.getRecipient().getID() + ") " + t.getAmount() + " removed");
                }
                else if (devMode == true && selected == 6) {
                    Transaction[] trs = ts.getUnpairedTransactions();
                    System.out.println("Check results:");
                    for(Transaction t: trs) {
                        System.out.println(t.getRecipient().getName() + "(id = " + t.getRecipient().getID() + ")" + " has an unacknowledged transfer id = " + t.getID() + " from " + t.getSender().getName() + "(id = " + t.getSender().getID() + ") for " + t.getAmount());
                    }
                }
                else if (selected == 7) {
                    System.exit(0);
                }
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}