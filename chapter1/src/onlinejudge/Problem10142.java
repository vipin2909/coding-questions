package onlinejudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem10142 {
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

    public static String nextLine() throws IOException {
        return br.readLine();
    }

    public static void solve() throws IOException {
        int testCase = nextInt();
        nextLine();
        for(int tc = 0; tc < testCase; tc++) {
//            int N = nextInt();
//            String[] name = new String[N];
//            for(int i = 0; i < N; i++) name[i] = nextLine();
//
//            String s;
//            ArrayList<ArrayList<Integer>> votes = new ArrayList<>();
//            while(true) {
//                s = nextLine();
//                if(s == null || s.equals("")) break;
//
//                String[] voting = s.split(" ");
//                ArrayList<Integer> list = new ArrayList<>();
//                votes.add(list);
//                System.out.println(voting.length);
//                for(int n = 0; n < N; n++) list.add(Integer.parseInt(voting[n])-1);
//            }
//
//            String ans = "";
//            boolean[] kicked = new boolean[N];
//            for(int i = 0; i < N; i++) {
//                int[] voteCount = new int[N];
//                for(ArrayList<Integer> v: votes) voteCount[v.get(i)]++;
//                int min = Integer.MAX_VALUE, max = 0;
//                for(int i2 = 0; i2 < N; i2++) {
//                    if(!kicked[i2]) {
//                        min = Math.min(min, voteCount[i2]);
//                        max = Math.max(max, voteCount[i2]);
//                    }
//                }
//                if(min == max) {
//                    StringBuilder sb = new StringBuilder();
//                    for(int i2 = 0; i2 < N; i2++) {
//                        sb.append(name[i2]);
//                        sb.append("\n");
//                    }
//                    sb.setLength(sb.length()-1);
//                    ans = sb.toString();
//                    break;
//                }
//                else {
//                    for(int i2 = 0; i2 < N; i2++) {
//                        if(!kicked[i2] && voteCount[i2] == min) {
//                            kicked[i2] = true;
//                            for(ArrayList<Integer> v: votes) v.remove(Integer.valueOf(i2));
//                        }
//                        i--;
//                    }
//                }
//            }
//            if(tc > 0) {
//                out.println();
//            }
//            out.println(ans);

            int N = nextInt();
            String[] names = new String[N];
            for(int n = 0; n < N; n++) names[n] = nextLine();
            String s;
            ArrayList<ArrayList<Integer>> votes = new ArrayList<>();
            while(true) {
                s = nextLine();
                if(s == null || s.equals("")) break;
                StringTokenizer st = new StringTokenizer(s);
                ArrayList<Integer> list = new ArrayList<>();
                votes.add(list);
                for(int  n = 0; n < N; n++) list.add(Integer.parseInt(st.nextToken()) - 1);
            }

            System.out.println(votes.toString());

            // 1 2 3 => list => votes.add(list)
            // 2 1 3 => list => votes.add(list)
            // 2 3 1 => list => votes.add(list)
            // 1 2 3 => list => votes.add(list)
            // 3 1 2 => list => votes.add(list)

            String ans = "";
            boolean[] kicked = new boolean[N];
            for(int i = 0; i < N; i++) {
                int[] voteCount = new int[N];
                for(ArrayList<Integer> v: votes) voteCount[v.get(i)]++;
                int min = Integer.MAX_VALUE, max = 0;
                for(int i2 = 0; i2 < N; i2++) if(!kicked[i2]) {
                    min = Math.min(min, voteCount[i2]);
                    max = Math.max(max, voteCount[i2]);
                }

                if(min == max) {
                    StringBuilder sb = new StringBuilder();
                    for(int i2 = 0; i2 < N; i2++) {
                        if(!kicked[i2]) {
                            sb.append(names[i2]);
                            sb.append("\n");
                        }
                    }
                    sb.setLength(sb.length()-1);
                    ans = sb.toString();
                    break;
                }
                else {
                    for(int i2 = 0; i2 < N; i2++) {
                        if(!kicked[i2] && voteCount[i2] == min) {
                            kicked[i2] = true;
                            for(ArrayList<Integer> v: votes) v.remove(Integer.valueOf(i2));
                        }
                        i--;
                    }
                }
            }
            if(tc > 0) out.println();
            out.println(ans);
        }
    }



    public static void testingSomething() throws IOException {
        String s = nextLine();
        System.out.println(s);
    }
    public static void main(String[] args) throws IOException {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
//            testingSomething();
            br.close();
            out.close();
        }
        catch(Throwable e) {
            e.printStackTrace();
        }
    }
}
