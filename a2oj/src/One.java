import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://codeforces.com/problemset/problem/69/A
public class One {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer tok;
    static int tc;

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static String nextLine() throws IOException {
        return br.readLine();
    }

    public static String next() throws IOException {
        while(tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(br.readLine());
        }
        return tok.nextToken();
    }


    public static void solve() throws IOException {
        int n = nextInt();
        int xSum = 0, ySum = 0, zSum = 0;
        for(int i = 0; i < n; i++) {
            xSum += nextInt();
            ySum += nextInt();
            zSum += nextInt();
        }
        String result = xSum == 0 && ySum == 0 && zSum == 0 ? "YES": "NO";
        out.println(result);
    }

    public static void main(String[] args) throws IOException {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            br.close();
            out.close();
        }
        catch(Throwable e) {
            e.printStackTrace();
        }
    }
}
