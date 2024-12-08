import java.util.*;
import java.io.*;

public class Main {
    static long n;
    static FastReader in = new FastReader();
    static FastWriter out = new FastWriter();

    public static int FirstvalueGreaterThanEqualsIdx(long a, long[] arr) {
        int l = 0;              
        int r = arr.length - 1; 
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2; 
            if (arr[mid] >= a) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans; // Return -1 if no such index is found
    }

    public static int FirstvalueLessThanEqualsIdx(long a, long[] arr) {
        int l = 0;              
        int r = arr.length - 1; 
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2; 
            if (arr[mid] <= a) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans; // Return -1 if no such index is found
    }

    public static void main(String[] args) throws IOException {
        n = in.nextLong();
        long[] arr = new long[(int) n]; 
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }

        // Sort the array for binary search
        Arrays.sort(arr);

        long k = in.nextLong();
        for (int i = 0; i < k; i++) {
            long l = in.nextLong();
            long r = in.nextLong();

            int leftidx = FirstvalueGreaterThanEqualsIdx(l, arr);
            int rightidx = FirstvalueLessThanEqualsIdx(r, arr);

            // If indices are invalid, no elements are in the range
            if (leftidx == -1 || rightidx == -1 || leftidx > rightidx) {
                out.println(0);
            } else {
                out.println(rightidx - leftidx + 1);
            }
        }

        out.close();
    }

    // Utility class for reading input
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    // Utility class for writing output
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void flush() throws IOException {
            bw.flush();
        }

        public void close() throws IOException {
            bw.close();
        }
    }
}
