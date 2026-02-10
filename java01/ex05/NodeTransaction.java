public class NodeTransaction {
    public Transaction data;
    public NodeTransaction next;

    public NodeTransaction(Transaction t) {
        data = t;
        next = null;
    }
};