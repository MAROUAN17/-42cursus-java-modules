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


        System.out.println("----- user transactions -----");
        Transaction[] trss = jeff.getTransactions().toArray();
        for(Transaction t: trss) {
            System.out.println(t.getID());
        }
        System.out.println("----------------------------");
        System.out.println("----- user2 transactions -----");
        Transaction[] trss1 = adam.getTransactions().toArray();
        for(Transaction t: trss1) {
            System.out.println(t.getID());
        }
        System.out.println("----------------------------");

        Transaction[] us = s.getUnpairedTransactions();
        for(Transaction t: us) {
            System.out.println(t.getID());
        }
    }
};