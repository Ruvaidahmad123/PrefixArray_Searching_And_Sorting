import java.util.*;
import java.io.*;

public class Main {
    static long n;
    static FastReader in = new FastReader();
    static FastWriter out = new FastWriter();

    public static boolean check(long n,int x,int y,long mid) {
        long time_to_first_copy = Math.min(x, y);
        if (mid < time_to_first_copy) {
            return false; // Not enough time to make even one copy
        }
        long time_left = mid - time_to_first_copy;
        long copies = time_left / x + time_left / y + 1; // Total copies made in `mid` seconds
        return copies >= n;
    }

    public static void main(String[] args) throws IOException {
        n = in.nextLong();
        int x=in.nextInt();
        int y=in.nextInt();
        long l=0;
        long r = Math.min(x, y) + (n - 1) * Math.min(x, y);
        long ans=-1;
        while (l<=r) {       
            long mid = l + (r - l) / 2;
            if (check(n,x,y,mid)) {
                ans=mid;
                r=mid-1; 
            } else {
                l=mid+1; 
            }
        }

        out.println(ans); 
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
