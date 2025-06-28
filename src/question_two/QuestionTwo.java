public class QuestionTwo {
    public static void main(String[] args) {
        int n = 5;

        System.out.println("Count for n = " + n + ": " + '\n');

        System.out.println("----- Recursive method -----");
        int totalEvenRecursive = RecursiveRedCounter.countEvenRed(n, true);
        System.out.println("Number of colorings with even red  cells: " + totalEvenRecursive);


        System.out.println();
        System.out.println("----- Dynamic method -----");
        int totalEvenDynamic = ColoringsEvenReds.countEvenRedColorings(n);
        System.out.println("Number of colorings with even red cells: " + totalEvenDynamic);
    }
}
