import java.util.UUID;

enum TransferCategory {
    DEBITS,
    CREDITS
};

public class Transaction {
    private UUID id;
    private User recipient;
    private User sender;
    private TransferCategory transferCategory;
    private Integer amount;

    Transaction(UUID id, User sender, User recipient, TransferCategory transferCategory, Integer amount) {
        if (transferCategory == TransferCategory.DEBITS && amount > 0) {
            throw new IllegalArgumentException("Debit amount should be negative");
        }
        if (transferCategory == TransferCategory.CREDITS && amount < 0) {
            throw new IllegalArgumentException("Credit amount should be positive");
        }

        this.id = id;
        this.sender = sender;
        this.recipient = recipient; 
        this.transferCategory = transferCategory; 
        this.amount = amount;
    }

    public UUID getID() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public TransferCategory getTransferCategory() {
        return transferCategory;
    }

    public void setTransferCategory(TransferCategory category) {
        this.transferCategory = category;
    }
}