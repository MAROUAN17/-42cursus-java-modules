public class NodeTransaction {
    public Transaction data;
    NodeTransaction next;

    public NodeTransaction(Transaction t) {
        data = t;
        next = null;
    }
};