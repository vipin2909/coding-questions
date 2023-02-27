package hackerrank;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/array-left-rotation/problem
public class ArrayLeftRotation {

    // approach -> 1, 2, 3, 4, 5 and d = 2
    // after first rotation 2 3 4 5 1
    // after second rotation 3 4 5 1 2
    // first add element from d to arr.size()
    // and after that add 0 to d

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {

        // if value of d greater than the size of the given list
        d %= arr.size();

        // if d is multiple of arr.size()
        if(d == 0) return arr;
        List<Integer> result = new ArrayList<>();
        for(int i = d; i < arr.size(); i++) {
            result.add(arr.get(i));
        }

        for(int i = 0; i < d; i++) {
            result.add(arr.get(i));
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            arr.add(i);
        }
        List<Integer> result = rotateLeft(2, arr);
        System.out.println(result.toString());
    }
}
