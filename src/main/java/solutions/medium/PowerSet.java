package solutions.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        if(array.isEmpty()) {
            return result;
        }
        result.addAll(powersetUtil(array, 0));
        return result;
    }

    public static List<List<Integer>> powersetUtil(List<Integer> array, int currIndex) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(array.get(currIndex));
        list.add(l1);
        if(currIndex == array.size() - 1) {
            return list;
        }
        List<List<Integer>> l2 = powersetUtil(array, currIndex + 1);
        List<List<Integer>> l3 = new ArrayList<>();

        for(List<Integer> l : l2) {
            List<Integer> res = new ArrayList<>();
            res.addAll(l1);
            res.addAll(l);
            l3.add(res);
        }
        List<List<Integer>> finalList = new ArrayList<>();
        finalList.add(l1);
        finalList.addAll(l2);
        finalList.addAll(l3);
        return finalList;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = powerset(List.of(1,3,4));
        for(List<Integer> l : res) {
            System.out.println(l);
        }
    }
}
