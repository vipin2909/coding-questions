import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://codeforces.com/problemset/problem/32/B

public class Four {
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
        String str = next();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '.') {
                sb.append("0");
            }
            else if(i+1 < str.length() && str.startsWith("-.", i)) {
                sb.append("1");
                i+=1;
            }
            else if(i+1 < str.length() && str.startsWith("--", i)) {
                sb.append("2");
                i+=1;
            }
        }
        out.println(sb.toString());
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
