import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int n;
    static Map<Integer, Integer> prev_values = new HashMap<>();
    static FastReader in = new FastReader();
    static FastWriter out = new FastWriter();

    public static int query(int idx) throws IOException {
        if (prev_values.containsKey(idx)) {
            return prev_values.get(idx);
        }
        if (idx == 0 || idx == n + 1) return (int) 1e9; 
        out.println("? " + idx);
        out.flush();
        int val = in.nextInt();
        prev_values.put(idx, val);
        return val;
    }

    public static void main(String[] args) throws IOException {
        n = in.nextInt(); 
        int l = 1;        
        int r = n;        
        while (l <= r) {
            int mid = l + (r - l) / 2; 
            int midVal = query(mid);
            int leftVal = query(mid - 1);
            int rightVal = query(mid + 1);

            if (midVal < leftVal && midVal < rightVal) {
                // Local minima found
                out.println("! " + mid);
                out.flush();
                break;
            } else if (midVal > leftVal) {
                // Local minima is on the left side
                r = mid - 1;
            } else {
                // Local minima is on the right side
                l = mid + 1;
            }
        }

        out.close();
    }
    
    static class PrefixSum0Based {
        private int[] prefix;

        public PrefixSum0Based(int[] input) {
            int n = input.length;
            prefix = new int[n];
            prefix[0] = input[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + input[i];
            }
        }

        public int getRangeSum(int l, int r) {
            if (l == 0) return prefix[r];
            return prefix[r] - prefix[l - 1];
        }

        public int getPrefixSum(int i) {
            return prefix[i];
        }
    }

    static class PrefixSum1Based {
        private int[] prefix;

        public PrefixSum1Based(int[] input) {
            int n = input.length;
            prefix = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] + input[i - 1];
            }
        }

        public int getRangeSum(int l, int r) {
            return prefix[r] - prefix[l - 1];
        }

        public int getPrefixSum(int i) {
            return prefix[i];
        }
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
