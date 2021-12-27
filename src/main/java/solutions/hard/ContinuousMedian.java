package solutions.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {
    static class ContinuousMedianHandler {
        double median = 0;

        /**
         * Maxheap will store the smallest half of the elements.
         */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        /**
         * Min heap will store the minimum half of the elements.
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public void insert(int number) {
            int minHeapSize = minHeap.size();
            int maxHeapSize = maxHeap.size();
            if (maxHeapSize == 0 && minHeapSize == 0) {
                maxHeap.add(number);
                return;
            }
            if (maxHeap.peek() > number) {
                maxHeap.add(number);
                maxHeapSize = maxHeap.size();
            } else {
                minHeap.add(number);
                minHeapSize = minHeap.size();
            }
            // Now balance the size of both heaps they their size differ by more than
            if (maxHeapSize > minHeapSize + 1) {
                Integer removedItem = maxHeap.poll();
                minHeap.add(removedItem);
            } else if (maxHeapSize + 1 < minHeapSize){
                Integer removedItem = minHeap.poll();
                maxHeap.add(removedItem);
            }
        }

        public double getMedian() {
            int maxHeapSize = maxHeap.size();
            int minHeapSize = minHeap.size();
            if(minHeapSize == 0) {
                return maxHeap.peek();
            } else if(maxHeapSize == minHeapSize) {
                int value1 = maxHeap.peek();
                int value2 = minHeap.peek();
                median = ((double) value1 + value2)/2;
            } else if(maxHeapSize > minHeapSize) {
                median = (double) maxHeap.peek();
            } else {
                median = (double) minHeap.peek();
            }
            return median;
        }
    }

    public static void main(String[] args) {
        ContinuousMedianHandler handler = new ContinuousMedianHandler();
        handler.insert(5);
        handler.insert(10);
        handler.insert(100);
        System.out.println(handler.getMedian());
    }
}
