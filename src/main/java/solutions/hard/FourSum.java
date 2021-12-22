package solutions.hard;

import java.util.*;

/**
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class FourSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<List<Integer>> allPairList = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                List<Integer> newPair = new ArrayList<>();
                newPair.add(array[i]);
                newPair.add(array[j]);
                allPairList.add(newPair);
            }
        }
        // Also put each items in the map.
        Set<Integer> set = new HashSet<>();
        for(int i : array) {
            set.add(i);
        }
        List<Integer[]> results = new ArrayList<>();
        // Now for every pair, find another pair whose sum will make overall target sum.
        Set<String> duplicatesQuadruplets = new HashSet<>();
        for(List<Integer> l : allPairList) {
            int num1 = l.get(0);
            int num2 = l.get(1);
            for(int i : array) {
                int remainingSum = targetSum - (num1 + num2 + i);
                // check if remaining sum exists in the set.
                if(set.contains(remainingSum)) {
                    // Now we have all four numbers who are making sum of target sum.
                    // Now just check all are distinct.
                    Integer[] quadruplets = new Integer[] {num1, num2, i, remainingSum};
                    Arrays.sort(quadruplets);
                    // just check for duplicacy.
                    Set<Integer> duplicacyCheck = new HashSet<>();
                    boolean containsDuplicate = false;
                    for(int q : quadruplets) {
                        if(duplicacyCheck.contains(q)) {
                            containsDuplicate = true;
                            break;
                        } else {
                            duplicacyCheck.add(q);
                        }
                    }
                    if(!containsDuplicate) {
                        // Now check if this quadruplets is not present in the results list, else it will be duplicate entry.
                        String entry = String.format("%d#%d#%d#%d", quadruplets[0], quadruplets[1], quadruplets[2], quadruplets[3]);
                        if(!duplicatesQuadruplets.contains(entry)) {
                            results.add(quadruplets);
                            duplicatesQuadruplets.add(entry);
                        }
                    }
                }
            }
        }
        return results;
    }
}