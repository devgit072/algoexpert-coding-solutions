package solutions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaptopRentals {
    public static int laptopRentals(ArrayList<List<Integer>> times) {
        int[] startTimes = new int[times.size()];
        int[] endTimes = new int[times.size()];

        int index = 0;
        for(List<Integer> pair : times) {
            startTimes[index] = pair.get(0);
            endTimes[index] = pair.get(1);
            index++;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int indexForStartTime = 0;
        int indexForEndTime = 0;
        int size = times.size();
        int laptopCount = 0;
        int minimumLaptopCount = 0;
        while (indexForStartTime < size) {
            int checkFromStartTime = endTimes[indexForEndTime];
            int checkTillThisEndtime = startTimes[indexForStartTime];
            while (checkFromStartTime <= checkTillThisEndtime) {
                laptopCount--;
                indexForEndTime++;
                checkFromStartTime = endTimes[indexForEndTime];
            }
            laptopCount++;
            if(laptopCount > minimumLaptopCount) {
                minimumLaptopCount = laptopCount;
            }
            indexForStartTime++;
        }
        return minimumLaptopCount;
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(0, 2));
        lists.add(Arrays.asList(1, 4));
        lists.add(Arrays.asList(4, 6));
        lists.add(Arrays.asList(0, 4));
        lists.add(Arrays.asList(7, 8));
        lists.add(Arrays.asList(9, 11));
        lists.add(Arrays.asList(3, 10));
        System.out.println(laptopRentals(lists));
    }
}