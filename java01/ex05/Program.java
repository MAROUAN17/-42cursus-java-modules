public class Program {
    public static void main(String[] args) {
        Menu m = new Menu();

        if (args.length != 0)
            m.launch(args[0]);
        else
            m.launch(null);
    }
};