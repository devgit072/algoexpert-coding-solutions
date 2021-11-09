package solutions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapConstruction {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int mid = (array.size() - 1) / 2;
            for (int i = mid; i >= 0; i--) {
                siftDown(i, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            if (currentIdx > endIdx) {
                return;
            }
            int leftIndex = currentIdx * 2 + 1;
            int rightIndex = currentIdx * 2 + 2;
            int smaller = -1;
            if (leftIndex > endIdx) {
                return;
            } else if (rightIndex > endIdx) {
                smaller = leftIndex;
            } else {
                if (heap.get(leftIndex) <= heap.get(rightIndex)) {
                    smaller = leftIndex;
                } else {
                    smaller = rightIndex;
                }
            }

            if (heap.get(smaller) < heap.get(currentIdx)) {
                int temp = heap.get(smaller);
                heap.set(smaller, heap.get(currentIdx));
                heap.set(currentIdx, temp);
            }
            siftDown(smaller, endIdx, heap);
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            if (currentIdx < 0) {
                return;
            }
            int parentIndex;
            if (currentIdx % 2 == 1) {
                parentIndex = (currentIdx - 1) / 2;
            } else {
                parentIndex = (currentIdx - 2) / 2;
            }
            if (parentIndex < 0) {
                return;
            }
            if (heap.get(parentIndex) > heap.get(currentIdx)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(currentIdx));
                heap.set(currentIdx, temp);
            }
            siftUp(parentIndex, heap);
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            /*
            when we remove the element from heap, it is removed from first index and replaced with last element
             */
            int val = heap.get(0);
            int lastElement = heap.get(heap.size() - 1);
            heap.set(0, lastElement);
            int lastIndex = heap.size() - 1;
            heap.remove(lastIndex);
            siftDown(0, heap.size() - 1, heap);
            return val;
        }

        public void insert(int value) {
            /*
            When we insert the element in the heap, it is inserted at last of array and from there heap need to be build
            towards up.
             */
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }
    }

    public static void main(String[] args) {
        List<Integer> fixedSizeList = Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41);
        List<Integer> list = new ArrayList<>();
        for(int i : fixedSizeList) {
            list.add(i);
        }
        //List<Integer> list = Arrays.asList(48, 12, 24, 7, 8);//, -5, 24, 391, 24, 56, 2, 6, 8, 41);
        MinHeap minHeap = new MinHeap(list);
        for (int i : list) {
            System.out.print("  " + i);
        }
        System.out.println();
        System.out.println(minHeap.remove());
    }
}
