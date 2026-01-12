import java.lang.IllegalArgumentException;

public class User {
    private Integer id;
    private String name;
    private Integer balance;
    User(Integer id, String name, Integer balance) {
        if (balance < 0)
            throw new IllegalArgumentException("negative balance");

        this.id = id;
        this.name = name;
        this.balance = balance;
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