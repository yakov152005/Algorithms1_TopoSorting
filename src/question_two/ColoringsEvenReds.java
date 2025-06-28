public class ColoringsEvenReds {
    public static int countEvenRedColorings(int n) {
        int[] T = new int[n + 1];
        T[0] = 1;

        for (int i = 1; i <= n; i++) {
            T[i] = T[i - 1] + (int)Math.pow(3, i - 1);
        }

        return T[n];
    }
}
