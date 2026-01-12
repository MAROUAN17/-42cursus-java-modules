public class Program {
    public static void main(String[] args) {
        User user1 = new User(1, "user1", 1000);
        User user2 = new User(2, "user2", 1000);
        Transaction tr = new Transaction(user1, user2, TransferCategory.DEBITS, -50);

        System.out.println("Sender: " + user1.getName() + ", Receiver: " + user2.getName() + ", Amount: " + tr.getAmount() + ", Category: " + tr.getTransferCategory());
    }
}