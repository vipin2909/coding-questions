import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://codeforces.com/problemset/problem/110/A

public class Nine {
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
        long num = nextLong();
        int cnt = 0;
        while(num > 0) {
            if(num%10 == 4 || num%10 == 7) {
                cnt++;
            }
            num /= 10;
        }
        out.println((cnt == 4 || cnt == 7) ? "YES": "NO");
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
