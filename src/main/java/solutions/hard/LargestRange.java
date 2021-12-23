package solutions.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LargestRange {
    public static int[] largestRange(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int a : array) {
            if(a < min) {
                min = a;
            }
            if(a > max) {
                max = a;
            }
            set.add(a);
        }
        int lowGlobal = min;
        int highGlobal = min;
        int low = min;
        int high = min;
        int i = min + 1;
        while(i<=max) {
            if(set.contains(i)) {
                high = i;
                if((high-low) > (highGlobal - lowGlobal)) {
                    lowGlobal = low;
                    highGlobal = high;
                }
            } else {
                while (i<=max && !set.contains(i)) {
                    i++;
                }
                if(i>max) {
                    break;
                }
                low = i;
                high = i;
            }
            i++;
        }
        return new int[] {lowGlobal, highGlobal};
    }
}
