public class Program {
    public static void main(String[] args) {
        TransactionsLinkedList trs = new TransactionsLinkedList();
        User jeff = new User("JEFF");
        User adam = new User("ADAM");
        
        Transaction tr = new Transaction(jeff, adam, TransferCategory.CREDITS, 200);
        Transaction tr2 = new Transaction(adam, jeff, TransferCategory.DEBITS, -200);
        Transaction tr3 = new Transaction(adam, jeff, TransferCategory.CREDITS, 200);
        trs.addTransaction(tr);
        trs.addTransaction(tr2);
        trs.addTransaction(tr3);


        Transaction[] arr = trs.toArray();

        System.out.println("SIZE -> " + trs.getSize());

        for(int i = 0; i < trs.getSize(); i++) {
            System.out.println("transaction -> " + arr[i].getID());
        }

        try {
            trs.removeTransaction(arr[2].getID());            
        } catch (Exception e) {
            System.err.println("NOT FOUND ID");
        }
        
        System.out.println("------------------");

        Transaction[] arr2 = trs.toArray();

        System.out.println("SIZE -> " + trs.getSize());


        for(int i = 0; i < trs.getSize(); i++) {
            if (arr2[i] != null)
                System.out.println("transaction -> " + arr2[i].getID());
        }




    }
};