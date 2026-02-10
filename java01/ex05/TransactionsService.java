import java.util.UUID;

public class TransactionsService {
    private UsersList usrList;
    private TransactionsLinkedList unpairedTransactions;

    TransactionsService() {
        usrList = new UsersArrayList();
        unpairedTransactions = new TransactionsLinkedList();
    }
    public void addUser(User usr) {
        usrList.addUser(usr);
    }
    public Integer getBalance(Integer id) {
        return usrList.getUserByID(id).getBalance();
    }
    public Transaction getTransaction(UUID id, Integer usrID) {
        User u = usrList.getUserByID(usrID);
        return u.getTransactions().get(id);
    }
    public Transaction[] getUnpairedTransactions() {
        unpairTransactions();
        return unpairedTransactions.toArray();
    }
    public void transferTransaction(Integer usr1Id, Integer usr2Id, Integer amount) throws IllegalTransactionException {
        User usr1 = usrList.getUserByID(usr1Id);
        User usr2 = usrList.getUserByID(usr2Id);

        if (usr1.getBalance() < amount)
            throw new IllegalTransactionException("The sender balance is not sufficient for the transfer");

        Transaction tr1 = new Transaction(usr1, usr2, TransferCategory.DEBITS, amount);
        Transaction tr2 = new Transaction(tr1.getID(), usr1, usr2, TransferCategory.CREDITS, -amount);

        usr1.getTransactions().addTransaction(tr1);
        usr1.getTransactions().addTransaction(tr2);
        usr2.getTransactions().addTransaction(tr1);
        usr2.getTransactions().addTransaction(tr2);

        usr1.setBalance(usr1.getBalance() - amount);
        usr2.setBalance(usr2.getBalance() + amount);
    }
    public Transaction[] getTransfers(Integer usrId) {
        return usrList.getUserByID(usrId).getTransactions().toArray();
    }
    public void removeTransaction(UUID tranId, Integer usrId) {
        User usr = usrList.getUserByID(usrId);
        usr.getTransactions().removeTransaction(tranId);
    }
    public void unpairTransactions() {
        Integer id = 0;
        User[] users = usrList.getUsers();
        while (users[id] != null) {
            Transaction[] ts = users[id].getTransactions().toArray();
            if (ts == null) {
                System.err.println("No transactions for this user");
                return ;
            }

            for(Transaction t: ts) {
                User o = t.getSender().getID().equals(id) ? t.getRecipient() : t.getSender();
                if (o == null)
                    return;

                if(isUnpaired(o, t.getID()))
                    unpairedTransactions.addTransaction(t);
            }
            id++;
        }
    }
    public Boolean isUnpaired(User usr, UUID trId) {
        Transaction[] trs = usr.getTransactions().toArray();

        for(Transaction t: trs) {
            if (t.getID() == trId) return false;
        }
        return true;
    }
}