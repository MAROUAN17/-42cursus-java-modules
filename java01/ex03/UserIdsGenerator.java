public class UserIdsGenerator {
    private static UserIdsGenerator uidGen = new UserIdsGenerator();
    private Integer id = 0;

    private UserIdsGenerator() {}
    public static UserIdsGenerator getInstance() {
        return uidGen;
    }
    public int generateId() {
        return this.getInstance().id += 1;
    }
}