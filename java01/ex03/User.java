public class User {
    private Integer id;
    private String name;

    public User(String name) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
} 