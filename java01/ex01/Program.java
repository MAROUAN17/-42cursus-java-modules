public class Program {
    public static void main(String[] args) {
        User test = new User("test");
        User test2 = new User("test2");
        User test3 = new User("test3");
        User test4 = new User("test4");
        User test5 = new User("test5");


        System.out.println("User1: " + test.getId());
        System.out.println("User2: " + test2.getId());
        System.out.println("User3: " + test3.getId());
        System.out.println("User4: " + test4.getId());
        System.out.println("User5: " + test5.getId());
    }
}