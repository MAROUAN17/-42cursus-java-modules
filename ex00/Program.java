class Program {
    public int sum = 0;
    public int calculateSum(int i) {
        while (i != 0) {
            sum += (i % 10);
            i /= 10;
        }
        return (sum);
    }
}

class Main {
    public static void main(String[] args) {
        Program p = new Program();
        System.out.println(p.calculateSum(479598));
    }
}