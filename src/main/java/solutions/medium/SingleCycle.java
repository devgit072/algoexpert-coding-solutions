package solutions.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Time complexity will be O(n)
 */
public class SingleCycle {
    public static boolean hasSingleCycle(int[] array) {
        int len = array.length;
        int currentIndex = 0;
        Set<Integer> visited = new HashSet<>();
        while (true) {
            if (visited.contains(currentIndex)) {
                if (visited.size() == len) {
                    if(currentIndex == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            visited.add(currentIndex);
            int currValue = array[currentIndex];
            int newIndex;
            currValue = currValue % len;
            if (currValue > 0) {
                int newTempIndex = currentIndex+currValue;
                newIndex = newTempIndex%len;
            } else {
                int v = currentIndex + currValue;
                if(v >= 0) {
                    newIndex = v;
                } else {
                    newIndex = len + v;
                }
            }
            currentIndex = newIndex;
        }
    }
}
