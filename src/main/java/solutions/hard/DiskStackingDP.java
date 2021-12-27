package solutions.hard;

import java.util.*;

public class DiskStackingDP {
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // Sortng the disks based on height is very important here. So lets sort disks based on height here.
        // O(N^2) solution.
        for(int i=0;i<disks.size()-1;i++) {
            for(int j=i+1;j<disks.size();j++) {
                if(disks.get(i)[2] > disks.get(j)[2]) {
                    Integer[] temp = disks.get(i);
                    disks.set(i, disks.get(j));
                    disks.set(j, temp);
                }
            }
        }

        Map<Integer, List<Integer[]>> map = new HashMap<>();
        int[] heights = new int[disks.size()];
        heights[0] = disks.get(0)[2];
        int maxHeight = heights[0];
        List<Integer[]> list = new ArrayList<>();
        list.add(disks.get(0));
        List<Integer[]> maxList = list;
        map.put(0, list);
        for(int i=1;i<disks.size();i++) {
            int heightAti = disks.get(i)[2];
            Integer[] diskAti = disks.get(i);
            for(int j=0;j<i;j++) {
                Integer[] diskAtj = disks.get(j);
                if(diskAtj[0] < diskAti[0] && diskAtj[1] < diskAti[1] && diskAtj[2] < diskAti[2]) {
                    if(heights[j] + heightAti > heights[i]) {
                        heights[i] = heights[j] + heightAti;
                        List<Integer[]> listAtj = map.get(j);
                        List<Integer[]> listAti = new ArrayList<>();
                        for(Integer[] arr : listAtj) {
                            listAti.add(arr);
                        }
                        listAti.add(diskAti);
                        map.put(i , listAti);
                    }
                }
            }
            if(!map.containsKey(i)) {
                List<Integer[]> listAti = new ArrayList<>();
                listAti.add(diskAti);
                map.put(i, listAti);
                heights[i] = heightAti;
            }
            if(heights[i] > maxHeight) {
                maxHeight = heights[i];
                maxList = map.get(i);
            }
        }
        return maxList;
    }
}
