package solutions.easy;

public class NthFibbo {

    public static int getNthFib(int n) {
        if (n < 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        // 0 1 1 2 3 5 8
        return getNthFib(n - 1) + getNthFib(n - 2);
    }
}
