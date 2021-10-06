package solutions.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SunsetViews {
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        if(direction.equals("WEST")) {
            int i = 0;
            while (i < buildings.length) {
                if(buildings[i] > max) {
                    max = buildings[i];
                    res.add(i);
                }
                i++;
            }
        } else if(direction.equals("EAST")) {
            int i = buildings.length - 1;
            while (i >= 0) {
                if(buildings[i] > max) {
                    max = buildings[i];
                    res.add(i);
                }
                i--;
            }
        } else {
            throw new RuntimeException("Invalid direction");
        }
        Collections.sort(res);
        return res;
    }
}
