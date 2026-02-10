import java.lang.IllegalArgumentException;

public class User {
    private Integer id;
    private String name;
    private Integer balance;

    User(String name, Integer balance) {
        if (balance < 0)
            throw new IllegalArgumentException("NEGATIVE BALANCE");

        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.balance = balance;
    }
    User(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    };
    public void setName(String name) {
        this.name = name;
    };
    public Integer getBalance() {
        return balance;
    };
    public void setBalance(Integer balance) {
        this.balance = balance;
    };
}