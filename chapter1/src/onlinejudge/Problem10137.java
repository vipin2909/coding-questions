package onlinejudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;


public class Problem10137 {
    static StringTokenizer tok;
    static BufferedReader br;
    static PrintWriter out;

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    public static String next() throws IOException {
        while(tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(br.readLine());
        }
        return tok.nextToken();
    }

    public static void solve() throws IOException {
        int tc = nextInt();
        while(tc!=0) {
            double[] money = new double[tc];
            for(int i = 0; i < tc; i++) {
                money[i] = nextDouble();
            }
            double ans = getAns(money, tc);
            out.println(String.format("$%.2f", ans));
            tc = nextInt();
        }
    }

    public static double getAns(double[] money, int n) {
        double diff, mean = 0.0, pos = 0.0, neg = 0.0;
        for(int i = 0; i < n; i++) {
            mean += money[i];
        }
        mean /= n;
        for(int i = 0; i < n; i++) {
            diff = (int)((money[i] - mean) * 100.00) / 100.00;
            if(diff > 0) {
                pos += diff;
            }
            else {
                neg += diff;
            }
        }
        return Math.max(pos, -neg);
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
