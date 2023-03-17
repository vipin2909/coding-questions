import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://codeforces.com/problemset/problem/275/A

public class Six {
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
        int[][] arr = new int[5][5];
        for(int i = 1; i <= 3; i++) {
            for(int j = 1; j <= 3; j++) {
                arr[i][j] = nextInt();
            }
        }


        // this is a trick you should check it manually as
        // input is small to look upon

        int[][] ans = new int[3][3];
        for(int i = 1; i <= 3; i++) {
            for(int j = 1; j <= 3; j++) {
                if((arr[i][j] + arr[i][j+1] + arr[i-1][j] + arr[i][j-1] + arr[i+1][j]) % 2 == 1) {
                    ans[i-1][j-1] = 0;
                }
                else {
                    ans[i-1][j-1] = 0;
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int k = 0; k < 3; k++) {
                out.print(ans[i][k]);
            }
            out.println();
        }
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
