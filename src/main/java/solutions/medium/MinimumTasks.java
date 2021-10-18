package solutions.medium;

import java.util.*;

public class MinimumTasks {
    int globalMin = Integer.MAX_VALUE;
    List<Integer> minimumList = null;

    static class ValueAndIndexPair {
        int value;
        int index;

        ValueAndIndexPair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    /*
    This one is optimised solution.

    The idea is to use greedy solution. Sort the array. Now if we want to minimize the sum of pair, we can pair least
    element with greatest element, second least element with second greatest element, and so on.
    Why? Because if we want to minimize the sum of pair, then we have to pair largest element with smallest element.
    If the question were to find maximum time, then we could have paired largest with second largest and so on.
    Hence, we sort the above array: (1,1,3,3,4,5) and we can make the pairs like [(1,5),  (1,4), (3,3)]
    Time will `O(nlogn)` and space will be `O(n)`
     */
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        List<ValueAndIndexPair> newList = new ArrayList<>();
        for(int i = 0; i< tasks.size();i++) {
            newList.add(new ValueAndIndexPair(tasks.get(i), i));
        }
        newList.sort(Comparator.comparingInt(o -> o.value));
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<k;i++) {
            ArrayList<Integer> l = new ArrayList<>();
            int index2 = 2*k- i - 1;
            l.add(newList.get(i).index);
            l.add(newList.get(index2).index);
            result.add(l);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> taskAssignmentUnOptimised(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        taskUtil(k, tasks, new ArrayList<>(), new HashSet<>());
        ArrayList<ArrayList<Integer>> globalList = new ArrayList<>();
        for (int i = 0; i < minimumList.size(); i += 2) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(minimumList.get(i));
            list.add(minimumList.get(i + 1));
            globalList.add(list);
        }
        System.out.println(minimumList.toString());
        return globalList;
    }

    public void taskUtil(int k, ArrayList<Integer> tasks, List<Integer> list, Set<Integer> set) {
        //System.out.println(list.toString());
        //System.out.println(set.toString());
        if (list.size() >= 2 * k) {
            int maximumLocal = -1;
            for (int i = 0; i < tasks.size(); i += 2) {
                int timeTaken = tasks.get(list.get(i)) + tasks.get(list.get(i + 1));
                if (timeTaken > maximumLocal) {
                    maximumLocal = timeTaken;
                }
            }
            if (maximumLocal < globalMin) {
                globalMin = maximumLocal;
                minimumList = new ArrayList<>();
                minimumList.addAll(list);
            }
            return;
        }
        for (int i = 0; i < tasks.size() - 1; i++) {
            if (set.contains(i)) {
                continue;
            } else {
                set.add(i);
                list.add(i);
            }
            for (int j = i; j < tasks.size(); j++) {
                if (set.contains(j)) {
                    continue;
                } else if (tasks.get(i) + tasks.get(j) > globalMin) {
                    continue;
                } else {
                    set.add(j);
                    list.add(j);
                    taskUtil(k, tasks, list, set);
                    set.remove(j);
                    list.remove(Integer.valueOf(j));
                }
            }
            set.remove(i);
            list.remove(Integer.valueOf(i));
        }
    }

    public static void main(String[] args) {
        MinimumTasks minimumTasks = new MinimumTasks();
        int k = 7;
        List<Integer> list1 = Arrays.asList(2, 1, 3, 4, 5, 13, 12, 9, 11, 10, 6, 7, 14, 8);
        ArrayList<Integer> list = new ArrayList<>(list1);
        /*list.add(1);
        list.add(3);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(4);*/
        ArrayList<ArrayList<Integer>> globalList = minimumTasks.taskAssignment(k, list);
        for (ArrayList<Integer> l : globalList) {
            System.out.println(l.toString());
        }
    }
}
