package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem

public class RadioTransmitter {
    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        Collections.sort(x);
        int count = 0;
        int size = x.size();
        int i = 0;

        // check for firstPosition where we can place tower
        // based on given description
        // optimize x-k, x, x+k
        // x where tower get placed, check this range
        while(i < size) {
            int firstHouse = x.get(i);
            i++;
            while(i < size && (firstHouse + k) >= x.get(i)) {
                i++;
            }
            i--;
            count+=1;
            int whereTowerGotPlaced = x.get(i);
            i++;
            while(i < size && (whereTowerGotPlaced + k) >= x.get(i)) {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(7);
        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(5);
        arr.add(9);
        arr.add(11);
        arr.add(12);
        int k = 2;
        int result = hackerlandRadioTransmitters(arr, k);
        System.out.println("Total number of towers get placed " + result);

    }
}

