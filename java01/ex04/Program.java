public class Program {
    public static void main(String[] args) {
        TransactionsLinkedList trs = new TransactionsLinkedList();
        User jeff = new User("JEFF", 500);
        User adam = new User("ADAM", 500);
        TransactionsService s = new TransactionsService();
        Transaction tr = new Transaction(jeff, adam, TransferCategory.CREDITS, -200);
        Transaction tr2 = new Transaction(adam, jeff, TransferCategory.DEBITS, 200);
        Transaction tr3 = new Transaction(adam, jeff, TransferCategory.CREDITS, -200);


        s.addUser(jeff);
        s.addUser(adam);

        s.transferTransaction(jeff.getID(), adam.getID(), 20);

        System.out.println("jeff -> " + s.getBalance(jeff.getID()));
        System.out.println("adam -> " + s.getBalance(adam.getID()));

        
        s.unpairTransactions(jeff.getID(), tr.getID());


        System.out.println("> " + s.getUnpairedTransactions().length);

    }
};