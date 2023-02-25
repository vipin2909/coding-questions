package leetcode;

import java.util.Stack;

/*
Given an array of integers temperatures represents the
daily temperatures, return an array answer such
that answer[i] is the number of days you have to
wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible,
keep answer[i] == 0 instead.
 */
public class DailyTemperatures {

    // basic approach traverse reverse array and check whether the current element has
    // large element in the array behind it
    // and if it has element than subtract elementIndex - cuurentIndex
    // otherwise store 0

    // one solution is using simple approach
    public int[] dailyTemperatures(int[] arr) {
        int[] ans = new int[arr.length];
        int hottest = Integer.MIN_VALUE;
        for(int i = arr.length-1; i >= 0; i--) {
            if(hottest <= arr[i]) {
                hottest = arr[i];
            }
            else {
                int nextIndex = i+1;
                while(arr[nextIndex] <= arr[i]) {
                    nextIndex = nextIndex+ans[nextIndex];
                }

                ans[i] = nextIndex - i;
            }
        }
        return ans;
    }


    // other solution which has same approach but using stack data structure
    public int[] dailyTemperaturesUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        ans[n-1] = 0;
        stack.add(n-1);
        for(int i = n-2; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                ans[i] = 0;
            }
            else {
                ans[i] = stack.peek()-i;
            }
            stack.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures obj = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 65, 66, 67, 68, 69};
        int[] solution = obj.dailyTemperatures(temperatures);
        for(int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
        System.out.println();
    }
}
