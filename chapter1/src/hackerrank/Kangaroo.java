package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerrank.com/challenges/kangaroo/problem
public class Kangaroo {
    public static String kangaroo(int x1, int x2, int v1, int v2) {
        if((x1 < x2 && v1 < v2) || (x2 < x1 && v2 < v1)) {
            return "NO";
        }
        if(x1 < x2) {
            while(x1 < x2) {
                x1 += v1;
                x2 += v2;
            }
            if(x1 == x2) {
                return "YES";
            }
        }
        else if(x2 < x1) {
            while(x2 < x1) {
                x2 += v2;
                x1 += v1;
            }
            if(x1 == x2) {
                return "YES";
            }
        }
        return x1 == x2 ? "YES" : "NO";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x1 = Integer.parseInt(br.readLine());
        int x2 = Integer.parseInt(br.readLine());
        int v1 = Integer.parseInt(br.readLine());
        int v2 = Integer.parseInt(br.readLine());
        String result = kangaroo(x1, x2, v1, v2);
        System.out.println(result);
        br.close();

    }
}
