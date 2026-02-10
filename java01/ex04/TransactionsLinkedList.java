import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private NodeTransaction head = null;
    private Integer size = 0;

    public Integer getSize() {
        return size;
    }

    public Transaction get(UUID transactionID) {
        NodeTransaction curr = head;
        while(curr != null) {
            if (curr.data.getID() == transactionID) return curr.data;
            curr = curr.next;
        }
        return null;
    }

    public void addTransaction(Transaction tr) {
        NodeTransaction newNode = new NodeTransaction(tr);
        if (head == null) head = newNode;
        else {
            NodeTransaction current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    };

    public void removeTransaction(UUID id) {
        if (head == null) return;
        else {
            size--;
            NodeTransaction curr = head;
            if (id == head.data.getID()) {
                head = head.next;
            }
            else {
                while (curr.next.data.getID() != id)
                    curr = curr.next;
                if (curr.next != null && curr.next.data.getID() != id) throw new TransactionNotFoundException("ID NOT FOUND");
                curr.next = curr.next.next;
            }
        }
    }

    public Transaction[] toArray() {
        Transaction[] trArray = new Transaction[size];
        NodeTransaction curr = head;
        Integer i = 0;

        while (curr != null) {
            trArray[i] = curr.data;
            curr = curr.next;
            i++;
        };
        return trArray;
    }
}