package leetcode;


import java.util.Arrays;

// https://leetcode.com/problems/wiggle-sort-ii/description/
public class WiggleSortII {

    // special case 1 1 2 2 3 3
    // 1 1 2 2 3 3 if we use i and n-i+1 approach
    // 1 3 1 3 2 2 // in this case it is not working
    // so we have used approach
    // mid-1, n-1, mid-1, n-2, mid-3 n-3.... 0, mid;
    public void wiggleSort(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int mid = (n+1) / 2;
        int startIndex = mid-1;
        int endIndex = n-1;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++) {
            if((i&1) == 0) {
                temp[i] = arr[startIndex--];
            }
            else {
                temp[i] = arr[endIndex--];
            }
        }

        for(int i = 0; i < n; i++) arr[i] = temp[i];
    }
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        WiggleSortII obj = new WiggleSortII();
        obj.wiggleSort(nums);
        for(int i: nums) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
