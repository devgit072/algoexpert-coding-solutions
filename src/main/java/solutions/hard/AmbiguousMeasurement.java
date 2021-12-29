package solutions.hard;

import java.util.HashSet;
import java.util.Set;

public class AmbiguousMeasurement {
    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        return util(measuringCups, low, high, 0, 0, 0);
    }

    private boolean util(int[][] measuringCups, int low, int high, int currentLow, int currentHigh, int currentIndex) {
        if (isWithinRange(currentLow, low, high) && isWithinRange(currentHigh, low, high)) {
            return true;
        }
        if (currentLow > high || currentHigh > high) {
            return false;
        }
        for (int i = currentIndex; i < measuringCups.length; i++) {
            int lowToBeAdded = measuringCups[i][0];
            int highToBeAdded = measuringCups[i][1];
            int newLow = currentLow + lowToBeAdded;
            int newHigh = currentHigh + highToBeAdded;
            boolean value = util(measuringCups, low, high, newLow, newHigh, i);
            if (value) {
                return true;
            }
        }
        return false;
    }

    private boolean isWithinRange(int value, int low, int high) {
        if (low <= value && value <= high) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] measuringCups = new int[][]{
                {1, 3},
                {2, 4},
                {5, 6},
                {10, 20}
        };
        AmbiguousMeasurement obj = new AmbiguousMeasurement();
        obj.ambiguousMeasurements(measuringCups, 10, 12);
    }
}
