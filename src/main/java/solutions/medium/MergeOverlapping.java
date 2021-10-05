package solutions.medium;

import java.util.*;

public class MergeOverlapping {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }
        IntervalComparator comparator = new IntervalComparator();
        Arrays.sort(intervals, comparator);
        int[] prevInterval = intervals[0];
        List<int[]> mergedInterval = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if(prevInterval[1] >= currInterval[1]) {
                continue;
            } else if(prevInterval[1] >= currInterval[0]) {
                prevInterval = new int[] {prevInterval[0], currInterval[1]};
            } else {
                mergedInterval.add(prevInterval);
                prevInterval = currInterval;
            }
        }
        mergedInterval.add(prevInterval);
        int[][] newMerged = new int[mergedInterval.size()][2];
        for(int i=0;i<mergedInterval.size();i++) {
            newMerged[i] = mergedInterval.get(i);
        }
        return newMerged;
    }

    private static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
}
