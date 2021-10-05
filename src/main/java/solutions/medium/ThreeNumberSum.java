package solutions.medium;

import java.util.*;

public class ThreeNumberSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Set<Integer> set = new HashSet<>();
        for (int a : array) {
            set.add(a);
        }
        List<Integer[]> results = new ArrayList<>();
        Set<String> arrSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    continue;
                }
                int remainingSum = targetSum - (array[i] + array[j]);
                if (set.contains(remainingSum) && array[i] != remainingSum && array[j] != remainingSum) {
                    Integer[] resArr = new Integer[]{array[i], array[j], remainingSum};
                    Arrays.sort(resArr);
                    String str = String.format("%d#%d#%d", resArr[0], resArr[1], resArr[2]);
                    if(!arrSet.contains(str)) {
                        results.add(resArr);
                        arrSet.add(str);
                    }
                }
            }
        }
        ArrayComparator comparator = new ArrayComparator();
        results.sort(comparator);
        return results;
    }

    static class ArrayComparator implements Comparator<Integer[]> {
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            if (!o1[0].equals(o2[0])) {
                return Integer.compare(o1[0], o2[0]);
            }
            if (!o1[1].equals(o2[1])) {
                return Integer.compare(o1[1], o2[1]);
            }
            if (!o1[2].equals(o2[2])) {
                return Integer.compare(o1[2], o2[2]);
            }
            return 0;
        }
    }
}
