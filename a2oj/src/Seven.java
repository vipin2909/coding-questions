import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://codeforces.com/contest/59/problem/A

public class Seven {
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
        char[] arr = str.toCharArray();
        int smallAlphabets = 0, largeAlphabets = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 65 && arr[i] <= 90) {
                smallAlphabets++;
            }
            else {
                largeAlphabets++;
            }
        }
        String ans = (smallAlphabets <= largeAlphabets) ? str.toLowerCase() : str.toUpperCase();
        out.println(ans);
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
