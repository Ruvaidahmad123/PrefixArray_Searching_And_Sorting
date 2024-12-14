import java.util.Scanner;

public class Main {

    public static boolean canFormCouncils(int k, int n, int[] a, long mid) {
        long totalStudents = 0;
        for (int i = 0; i < n; i++) {
            totalStudents += Math.min(a[i], mid);
        }
        return totalStudents >= mid * k;
    }

    public static long maxCouncils(int k, int n, int[] a) {
        long left = 0, right = 50*(long)1e9+10;
        long result = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canFormCouncils(k, n, a, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(maxCouncils(k, n, a));
        scanner.close();
    }
}
