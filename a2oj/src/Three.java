import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://codeforces.com/problemset/problem/266/B

public class Three {
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


    // question problem states that at any time
    // replace boy position to girl position if a boy standing in front of a girl
    public static void solve() throws IOException {
        int n = nextInt();
        int t = nextInt();
        String s = next();
        char[] arr = s.toCharArray();
        for(int i = 0; i < t; i++) {
            for(int j = 1; j < arr.length; j++) {
                if(arr[j] == 'G') {
                    if(arr[j-1] == 'B') {
                        char temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                        j += 1;
                    }
                }
            }
        }
        out.println(String.valueOf(arr));
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
