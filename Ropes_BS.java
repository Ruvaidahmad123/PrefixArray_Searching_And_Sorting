import java.util.*;
import java.io.*;

public class Main {
    static long n;
    static FastReader in = new FastReader();
    static FastWriter out = new FastWriter();

    public static boolean check(double mid, long[] arr, long k) {
        int cnt = 0;
        for (long value : arr) {
            cnt +=  (value / mid); // Count how many pieces of length `mid` can be cut
            if (cnt >= k) { // Early exit if enough pieces are found
                return true;
            }
        }
        return cnt >= k;
    }

    public static void main(String[] args) throws IOException {
        n = in.nextLong();
        long k = in.nextLong();
        long[] arr = new long[(int) n];
        long max = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
            max = Math.max(max, arr[i]);
        }

        double l = 0; 
        double r = max; 
        int lp=100;
        while (lp-->0) {       //0 se 1e18 agar range maane toh log1e18 base2 =60 times loop chalega so for safer side 100 times chala diya
                               //check function o(n) times i.e 10^4 chalega so total 10^6 times.
            double mid = l + (r - l) / 2;
            if (check(mid, arr, k)) {
                l = mid; 
            } else {
                r = mid; 
            }
        }

        out.println(String.format("%.7f",l)); 
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
