package solutions.hard;

import java.util.*;

public class DiskStacking {
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // Sortng the disks based on height is very important here. So lets sort disks based on height here.
        for(int i=0;i<disks.size()-1;i++) {
            for(int j=i+1;j<disks.size();j++) {
                if(disks.get(i)[2] > disks.get(j)[2]) {
                    Integer[] temp = disks.get(i);
                    disks.set(i, disks.get(j));
                    disks.set(j, temp);
                }
            }
        }
        return util(disks, null, 0);
    }

    public static List<Integer[]> util(List<Integer[]> disks, Integer[] lastDisk, int currentIndex) {
        if (currentIndex >= disks.size()) {
            return new ArrayList<>();
        }
        Integer[] currentDisk = disks.get(currentIndex);
        // Check if current disk can be included or not.
        if (lastDisk == null || (currentDisk[0] > lastDisk[0] && currentDisk[1] > lastDisk[1] && currentDisk[2] > lastDisk[2])) {
            // We can include it or not include it.
            List<Integer[]> list1 = new ArrayList<>();
            list1.add(currentDisk);
            List<Integer[]> list1_ = util(disks, currentDisk, currentIndex + 1);
            list1.addAll(list1_);
            List<Integer[]> list2 = util(disks, lastDisk, currentIndex + 1);
            // Now check whose sum is most.
            int sum1 = 0;
            for (Integer[] i : list1) {
                sum1 += i[2];
            }
            int sum2 = 0;
            for (Integer[] i : list2) {
                sum2 += i[2];
            }
            List<Integer[]> result = new ArrayList<>();
            if (sum1 > sum2) {
                result.addAll(list1);
            } else {
                result.addAll(list2);
            }
            return result;
        } else {
            return util(disks, lastDisk, currentIndex + 1);
        }
    }
}