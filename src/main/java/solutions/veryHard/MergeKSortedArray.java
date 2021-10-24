package solutions.veryHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        int[] pointers = new int[arrays.size()];
        List<Integer> mergedSortedArray = new ArrayList<>();
        while(true) {
            boolean breakLoop = true;
            // find the index which has minimum value
            int index = -1;
            int minimumValue = Integer.MAX_VALUE;
            for(int i=0;i<arrays.size();i++) {
                List<Integer> currArr = arrays.get(i);
                int currPointerForThisArray = pointers[i];
                if(currPointerForThisArray >= currArr.size()) {
                    continue;
                }
                breakLoop = false;
                int currValue = currArr.get(currPointerForThisArray);
                if(currValue < minimumValue) {
                    index = i;
                    minimumValue = currValue;
                }
            }
            if(breakLoop) {
                break;
            }
            mergedSortedArray.add(arrays.get(index).get(pointers[index]));
            pointers[index]++;
        }
        return mergedSortedArray;
    }

    public static void main(String[] args) {
        List<List<Integer>>arrays = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 5, 9, 21),
                Arrays.asList(-1, 0),
                Arrays.asList(-124, 81, 121),
                Arrays.asList(3, 6, 12, 20, 150)

        ));

        System.out.println(mergeSortedArrays(arrays));
    }
}
